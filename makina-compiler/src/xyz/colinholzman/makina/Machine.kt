package xyz.colinholzman.makina

class Machine(val id: String, val states: List<State> = emptyList(),
              location: SourceLocation = SourceLocation.none): Node(location) {

    init {
        linkStateGraph()
        if (hasDuplicateStates()) throw RuntimeException("duplicate states")
        if (hasDuplicateInitialStates()) throw RuntimeException("duplicate initial states")
    }

    private fun linkStateGraph() {
        states.forEach {
            it.assignParent(this)
            it.assignSubStates(this)
        }
    }

    private fun hasDuplicateStates(): Boolean {
        val stateIds = states.map { Pair(it.id, it.parent) }
        return HashSet(stateIds).size != stateIds.size
    }

    private fun hasDuplicateInitialStates(): Boolean {
        return states.filter { it.initial && it.parent == null }.count() > 1
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
        val children = this.states.filter { it.parent == null }
        val designatedInitial = children.find { it.initial }
        val initial = designatedInitial ?: children.first()
        return initial.getStateConfiguration()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Machine

        if (id != other.id) return false
        if (states != other.states) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + states.hashCode()
        return result
    }
}
