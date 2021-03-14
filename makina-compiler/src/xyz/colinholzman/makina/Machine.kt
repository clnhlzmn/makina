package xyz.colinholzman.makina

data class Machine(val id: String, val states: List<State> = emptyList()): Node() {

    fun hasDuplicateStates(): Boolean {
        val stateIds = states.map { it.id }
        return HashSet(stateIds).size != stateIds.size
    }

    fun hasDuplicateInitialStates(): Boolean {
        return states.filter { it.initial }.count() > 1
    }
}
