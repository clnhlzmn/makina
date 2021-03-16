package xyz.colinholzman.makina

data class State(val id: String,
                 val handlers: List<Handler> = listOf(),
                 val parentId: String? = null,
                 val initial: Boolean = false): Node() {

    init {
        if (hasDuplicateHandlers()) throw RuntimeException("duplicate handlers")
    }

    var subStates: List<State> = ArrayList()
        set(value) {
            field = value
            if (hasDuplicateInitialStates()) throw RuntimeException("duplicate initial states")
        }
    var parent: State? = null

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
        subStates = machine.states.filter { it != this && it.parentId == id }
    }

    fun assignParent(machine: Machine) {
        if (parentId == null) return
        val foundParent = machine.states.find { it.id == parentId } ?:
            throw RuntimeException("parent state $parentId not found")
        parent = foundParent
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