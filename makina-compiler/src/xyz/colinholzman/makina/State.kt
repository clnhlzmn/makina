package xyz.colinholzman.makina

class State(val id: String,
            val handlers: List<Handler> = listOf(),
            val parentId: List<String> = listOf("."),
            val initial: Boolean = false,
            location: SourceLocation = SourceLocation.none): Node(location) {

    init {
        if (hasDuplicateHandlers()) throw RuntimeException("duplicate handlers at $location")
    }

    //subStates field is valid only after this State has been included in a Machine
    var subStates: List<State> = ArrayList()
        set(value) {
            field = value
            if (hasDuplicateInitialStates()) throw RuntimeException("duplicate initial states")
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

    private fun hasDuplicateHandlers(): Boolean {
        val handlerIds = handlers.map {
            when (it) {
                is Handler.Entry -> Pair("entry", null)
                is Handler.Exit -> Pair("exit", null)
                is Handler.Event -> Pair(it.id, it.guard)
            }
        }
        return HashSet(handlerIds).size != handlerIds.size
    }

    private fun hasDuplicateInitialStates(): Boolean {
        return subStates.filter { it.initial }.size > 1
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

    fun isDescendantOf(other: State): Boolean {
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