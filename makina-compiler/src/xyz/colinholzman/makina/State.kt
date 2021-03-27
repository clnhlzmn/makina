package xyz.colinholzman.makina

class State(val id: String,
            val handlers: List<Handler> = listOf(),
            val parentId: List<String> = listOf("."),
            val initial: Boolean = false,
            location: SourceLocation = SourceLocation.none): Node(location) {

    init {
        checkForDuplicateHandlers()
    }

    //subStates field is valid only after this State has been included in a Machine
    var subStates: List<State> = ArrayList()
        set(value) {
            field = value
            checkForDuplicateInitialStates()
        }

    //parent field is valid only after this State has been included in a Machine
    var parent: State? = null

    fun getSiblings(machine: Machine): List<State> {
        return if (parent == null)
            machine.states.filter { it.parent == null && it != this }
        else
            parent!!.subStates.filter { it != this }
    }

    fun getFullyQualifiedId(): List<String> {
        return if (parent == null) listOf(".", id)
        else parent!!.getFullyQualifiedId() + id
    }

    fun getFullyQualifiedIdString(): String {
        return getFullyQualifiedId().drop(1).joinToString("_")
    }

    private fun checkForDuplicateHandlers() {
        val set = HashSet<Pair<String, String?>>()
        for (handler in handlers) {
            val entry = when (handler) {
                is Handler.Exit -> Pair("exit", null)
                is Handler.Entry -> Pair("entry", null)
                is Handler.Event -> Pair(handler.id, handler.guard)
            }
            if (set.contains(entry)) {
                throw RuntimeException("duplicate handler at ${handler.location}")
            } else {
                set.add(entry)
            }
        }
    }

    private fun checkForDuplicateInitialStates() {
        var count = 0
        for (subState in subStates) {
            if (subState.initial) {
                if (count == 0) count++
                else throw RuntimeException("duplicate initial state at ${subState.location}")
            }
        }
    }

    fun assignSubStates(machine: Machine) {
        subStates = machine.states
                .filter { it.parentId.isNotRoot() }
                .filter { it.parentId == parentId + id }
    }

    fun assignParent(machine: Machine) {
        if (parentId.isRoot()) return
        parent = machine.states.find { it.parentId + it.id == parentId }
                ?: throw RuntimeException("parent state $parentId not found at $location")
    }

    fun isLeafState(): Boolean {
        return subStates.isEmpty()
    }

    fun getDepth(): Int {
        var ret = 0
        var current: State? = parent
        while (current != null) {
            ret++
            current = current.parent
        }
        return ret
    }

    fun isDescendantOf(other: State?): Boolean {
        if (other == null) return true
        var current: State? = this
        while (current != null) {
            if (current.parent == other)
                return true
            current = current.parent
        }
        return false
    }

    private fun getAncestors(): List<State> {
        return sequence<State> {
            var ancestor = parent
            while (ancestor != null) {
                yield(ancestor)
                ancestor = ancestor.parent
            }
        }.toList()
    }

    fun getProperAncestors(other: State?): List<State> {
        return when {
            other == null -> getAncestors()
            this == other || other.isDescendantOf(this) -> emptyList()
            else -> getAncestors().filterNot { a -> (other.getAncestors() + other).contains(a) }.toList()
        }
    }

    //if this is a leaf state then get the config that is this state + ancestors
    //it this is not a leaf state then get the initial state configuration
    fun getStateConfiguration(): StateConfiguration {
        return if (isLeafState())
            StateConfiguration((getAncestors() + this).toSet())
        else {
            val initial = subStates.find { it.initial } ?: subStates.first()
            initial.getStateConfiguration()
        }
    }

    fun getInitialSubState(): State {
        return subStates.find { it.initial } ?: subStates.first()
    }

    //gets a list of the sub states to enter if this is the target of a transition
    fun getDefaultEntrySet(): List<State> {
        return if (isLeafState()) {
            emptyList()
        } else {
            val initialSubState = getInitialSubState()
            listOf(initialSubState) + initialSubState.getDefaultEntrySet()
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as State

        if (id != other.id) return false
        if (handlers != other.handlers) return false
        if (parentId != other.parentId) return false
        if (initial != other.initial) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + handlers.hashCode()
        result = 31 * result + parentId.hashCode()
        result = 31 * result + initial.hashCode()
        return result
    }

    companion object {

        fun List<State>.getLCCA(): State? {
            if (size <= 1) return null
            first().getAncestors().forEach { a ->
                if (drop(1).all { s -> s.isDescendantOf(a) }) return a
            }
            return null
        }
    }

}