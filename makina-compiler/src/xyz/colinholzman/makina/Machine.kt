package xyz.colinholzman.makina

data class Machine(val id: String, val states: List<State> = emptyList()): Node() {

    fun linkStateGraph() {
        states.forEach {
            it.assignParent(this)
            it.assignSubStates(this)
        }
    }

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

    fun getAllEventNames(): Set<String> {
        return states.flatMap { state ->
            state.handlers.filterIsInstance<Handler.Event>().map { handler ->
                handler.id
            }
        }.toSet()
    }

    fun getInitialStateConfiguration(): StateConfiguration {
        var children = this.states.filter { it.parent == null }
        val set = hashSetOf<State>()
        while (children.isNotEmpty()) {
            val initial = children.find { it.initial }
            val first = children.first()
            children = if (initial != null) {
                set.add(initial)
                initial.subStates
            } else {
                set.add(first)
                first.subStates
            }
        }
        return StateConfiguration(set)
    }
}
