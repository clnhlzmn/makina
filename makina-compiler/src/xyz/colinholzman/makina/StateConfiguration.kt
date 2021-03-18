package xyz.colinholzman.makina

data class StateConfiguration(val states: Set<State>) {

    init {
        if (!isValid()) throw RuntimeException("invalid state configuration")
    }

    //states ordered by depth, deepest first
    private val orderedStates: List<State>
        get() = states.sortedByDescending { it.getDepth() }

    private fun isValid(): Boolean {
        if (states.isEmpty()) return false
        if (orderedStates.groupBy { it.getDepth() }.any { it.value.size > 1 }) return false
        if (orderedStates.first().getProperAncestors(null) != orderedStates.drop(1)) return false
        return true
    }

    //Returns the list of handlers that this state configuration should handle.
    //The handlers are deepest deepest state first and in document order for handlers within a single state.
    fun getHandlers(): List<Pair<State, Handler.Event>> {
        return orderedStates.flatMap { state -> state.handlers.filterIsInstance<Handler.Event>().map { Pair(state, it) } }
    }

    //Returns the list of entry handlers that should be activated when initializing a machine in this state config.
    fun getEntryHandlers(): List<Handler.Entry> {
        return orderedStates.reversed().flatMap { state -> state.handlers.filterIsInstance<Handler.Entry>() }
    }

    //Returns the leaf state for this configuration.
    fun getLeafState(): State {
        return orderedStates.first()
    }
}