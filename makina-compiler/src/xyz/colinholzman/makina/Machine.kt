package xyz.colinholzman.makina

data class Machine(val id: String, val states: List<State> = emptyList()): Node() {

    fun hasDuplicateStates(): Boolean {
        val stateIds = states.map { it.id }
        return HashSet(stateIds).size != stateIds.size
    }

    fun hasDuplicateInitialStates(): Boolean {
        return states.filter { it.initial }.count() > 1
    }

    fun getAllActionAndGuardNames(): Set<String> {
        return states.flatMap { state->
            state.handlers.flatMap { handler ->
                when (handler) {
                    is Handler.Entry -> setOf(handler.action)
                    is Handler.Exit -> setOf(handler.action)
                    is Handler.Event -> {
                        val set = hashSetOf<String>()
                        if (handler.action != null) set.add(handler.action)
                        if (handler.guard != null) set.add(handler.guard)
                        set
                    }
                }
            }
        }.toSet()
    }
}
