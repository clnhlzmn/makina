package xyz.colinholzman.makina

data class StateConfiguration(val states: Set<State>) {
    //states ordered by depth, deepest first
    private val orderedStates: List<State>
        get() = states.sortedByDescending { it.getDepth() }

    fun isValid(): Boolean {
        if (states.isEmpty()) return false
        if (orderedStates.groupBy { it.getDepth() }.any { it.value.size > 1 }) return false
        if (orderedStates.first().getProperAncestors(null) != orderedStates.drop(1)) return false
        return true
    }

    fun getHandlers(): List<Handler> {
        return orderedStates.flatMap { state -> state.handlers.filterIsInstance<Handler.Event>() }
    }
}