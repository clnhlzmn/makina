package xyz.colinholzman.makina

data class Machine(val id: String, val states: List<State> = emptyList()): Node() {

    fun hasDuplicateStates(): Boolean {
        val stateIds = states.map { it.id }
        return HashSet(stateIds).size != stateIds.size
    }
}
