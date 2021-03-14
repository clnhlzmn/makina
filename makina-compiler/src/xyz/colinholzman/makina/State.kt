package xyz.colinholzman.makina

data class State(val id: String,
                 val handlers: ArrayList<Handler> = arrayListOf(),
                 val subStates: HashSet<State> = hashSetOf(),
                 val parent: State?): Node() {
}