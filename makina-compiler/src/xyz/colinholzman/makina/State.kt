package xyz.colinholzman.makina

data class State(val id: String,
                 val handlers: MutableList<Handler> = arrayListOf(),
                 val parentId: String?): Node() {
}