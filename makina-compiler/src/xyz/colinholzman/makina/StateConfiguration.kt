package xyz.colinholzman.makina

data class StateConfiguration(val states: Set<State>) {
    fun isValid(): Boolean {
        if (states.isEmpty()) return false
        //order states deepest first
        val orderedStates = states.sortedBy { it.getDepth() }.reversed()
        val depthGroups = orderedStates.groupBy { it.getDepth() }
        //if any depth has more than one state then not valid
        if (depthGroups.any { it.value.size > 1 }) return false
        if (orderedStates.first().getProperAncestors(null) != orderedStates.drop(1)) return false
        return true
    }
    fun getHandlers(): List<Handler> {
        return emptyList()
    }
}