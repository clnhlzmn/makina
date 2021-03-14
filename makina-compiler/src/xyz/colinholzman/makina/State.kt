package xyz.colinholzman.makina

data class State(val id: String,
                 val handlers: List<Handler> = listOf(),
                 val parentId: String? = null): Node() {
    val subStates: MutableList<State> = mutableListOf()
    var parent: State? = null
}