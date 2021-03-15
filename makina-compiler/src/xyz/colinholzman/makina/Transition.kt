package xyz.colinholzman.makina

data class Transition(val source: State, val target: State) {
    fun getEntrySet(): List<State> {
        return (listOf(target) + target.getProperAncestors(State.getLCCA(listOf(source, target)))).reversed()
    }
    fun getExitSet(): List<State> {
        return listOf(source) + source.getProperAncestors(State.getLCCA(listOf(source, target)))
    }
}