package xyz.colinholzman.makina

class Machine(val id: String, val states: List<State> = emptyList(),
              location: SourceLocation = SourceLocation.none): Node(location) {

    init {
        linkStateGraph()
        checkForDuplicateStates()
        checkForDuplicateInitialStates()
    }

    private fun linkStateGraph() {
        states.forEach {
            it.assignParent(this)
            it.assignSubStates(this)
        }
    }

    private fun checkForDuplicateStates() {
        val set = HashSet<Pair<String, State?>>()
        for (state in states) {
            val entry = Pair(state.id, state.parent)
            if (set.contains(entry))
                throw RuntimeException("duplicate state at ${state.location}")
            else
                set.add(entry)
        }
    }

    private fun checkForDuplicateInitialStates() {
        var count = 0
        for (state in states) {
            if (state.type.initial && state.parent == null) {
                if (count == 0) count++
                else throw RuntimeException("duplicate initial state at ${state.location}")
            }
        }
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
        val designatedInitial = children.find { it.type.initial }
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
