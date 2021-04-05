package xyz.colinholzman.makina

data class StateConfiguration(val state: State) {

    init {
        if (!state.isAtomic()) throw RuntimeException("invalid configuration")
    }

    //states ordered by depth, deepest first
    private val orderedStates: List<State>
        get() = state.getBranch()

    //Returns the list of handlers that this state configuration should handle.
    //The handlers are deepest state first and in document order for handlers within a single state.
    fun getHandlers(): List<Pair<State, Handler.Event>> {
        return orderedStates.flatMap { state -> state.handlers.filterIsInstance<Handler.Event>().map { Pair(state, it) } }
    }

    //Returns the list of entry handlers that should be activated when initializing a machine in this state config.
    fun getEntryHandlers(): List<Handler.Entry> {
        return orderedStates.reversed().flatMap { state -> state.handlers.filterIsInstance<Handler.Entry>() }
    }

    //Returns the atomic state for this configuration.
    fun getAtomicState(): State {
        return orderedStates.first()
    }

    //Returns the top level state of this configuration
    fun getParentState(): State {
        return orderedStates.last()
    }

    companion object {
        fun List<Pair<State, Handler.Event>>.groupByIdAndRemoveRedundantHandlers(): Map<String, List<Pair<State, Handler.Event>>> {
            return groupBy { it.second.id }.mapValues { entry ->
                val guards = HashSet<String?>()
                entry.value.filter { !guards.contains(null) && guards.add(it.second.guard) }
            }
        }
    }
}