package xyz.colinholzman.makina

import xyz.colinholzman.makina.State.Companion.getLCCA

data class Transition(val source: State, val target: State) {
    init {
        if (!source.isLeafState())
            throw RuntimeException("source must be a leaf state")
    }
    fun getEntrySet(): List<State> {
        return (listOf(target) + target.getProperAncestors(listOf(source, target).getLCCA())).reversed()
    }
    fun getExitSet(): List<State> {
        return listOf(source) + source.getProperAncestors(listOf(source, target).getLCCA())
    }
}