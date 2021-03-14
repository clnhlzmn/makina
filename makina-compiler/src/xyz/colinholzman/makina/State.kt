package xyz.colinholzman.makina

data class State(val id: String,
                 val handlers: List<Handler> = listOf(),
                 val parentId: String? = null): Node() {

    val subStates: MutableList<State> = mutableListOf()
    var parent: State? = null

    fun hasDuplicateHandlers(): Boolean {
        val handlerIds = handlers.map {
            when (it) {
                is Handler.Entry -> "entry"
                is Handler.Exit -> "exit"
                is Handler.Event -> it.id
            }
        }
        return HashSet(handlerIds).size != handlerIds.size
    }

}