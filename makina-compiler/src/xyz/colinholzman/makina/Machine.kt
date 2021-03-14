package xyz.colinholzman.makina

data class Machine(val id: String, val states: List<State> = emptyList()): Node() {
}
