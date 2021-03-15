package xyz.colinholzman.makina

data class StateConfiguration(val states: Set<State>) {
    //states ordered by depth, deepest first
    private val orderedStates: List<State>
        get() = states.sortedByDescending { it.getDepth() }

    fun isValid(): Boolean {
        if (states.isEmpty()) return false
        val depthGroups = orderedStates.groupBy { it.getDepth() }
        //if any depth has more than one state then not valid
        if (depthGroups.any { it.value.size > 1 }) return false
        if (orderedStates.first().getProperAncestors(null) != orderedStates.drop(1)) return false
        return true
    }

    fun getHandlers(): List<Handler> {
        return orderedStates.flatMap { state -> state.handlers.filterIsInstance<Handler.Event>() }
    }
}