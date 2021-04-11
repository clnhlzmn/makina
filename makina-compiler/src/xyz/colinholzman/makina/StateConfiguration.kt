package xyz.colinholzman.makina


fun List<Pair<State, Handler.Event>>.groupByIdAndRemoveRedundantHandlers(): Map<String, List<Pair<State, Handler.Event>>> {
    return groupBy { it.second.id }.mapValues { entry ->
        val guards = HashSet<String?>()
        entry.value.filter { !guards.contains(null) && guards.add(it.second.guard) }
    }
}

//Returns all handlers a given state configuration should handle
fun List<State>.getEventHandlers(): Map<String, List<Pair<State, Handler.Event>>> {
    return flatMap { atomicState ->
        if (atomicState.type is State.Type.Final) emptyList()
        else atomicState.getBranch().flatMap {
            state -> state.handlers.filterIsInstance<Handler.Event>().map { Pair(state, it) }
        }
    }.sortedByDescending { it.first.getDepth() }.groupByIdAndRemoveRedundantHandlers()
}

//Returns a list of the entry handlers that must be activated to enter the given initial configuration
fun List<State>.getEntryHandlers(): List<Handler.Entry> {
    return flatMap { atomicState ->
        atomicState.getBranch().reversed().flatMap { state ->
            state.handlers.filterIsInstance<Handler.Entry>().map { state to it }
        }
    }.distinct().map { it.second }
}
