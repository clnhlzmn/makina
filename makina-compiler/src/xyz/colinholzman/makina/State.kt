package xyz.colinholzman.makina

data class State(val id: String,
                 val handlers: List<Handler> = listOf(),
                 val parentId: String? = null,
                 val initial: Boolean = false): Node() {

    val subStates: MutableList<State> = mutableListOf()
    var parent: State? = null

    fun hasDuplicateHandlers(): Boolean {
        val handlerIds = handlers.map {
            when (it) {
                is Handler.Entry -> "entry"
                is Handler.Exit -> "exit"
                is Handler.Event -> it.id
            }
        }
        return HashSet(handlerIds).size != handlerIds.size
    }

    fun assignSubStates(machine: Machine) {
        subStates.addAll(machine.states.filter { it != this && it.parentId == id })
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

    fun isDescendantOf(other: State): Boolean {
        var current: State? = this
        while (current != null) {
            if (current.parent == other)
                return true
            current = current.parent
        }
        return false
    }

}