package xyz.colinholzman.makina

import xyz.colinholzman.makina.State.Companion.getLCCA

data class Transition(val activeLeafState: State,
                      val source: State, val target: State,
                      val kind: Target.Kind = Target.Kind.DEFAULT) {
    fun getEntrySet(): List<State> {
        return (listOf(target) + target.getDefaultEntrySet() + target.getProperAncestors(getDomain()))
                .sortedBy { it.getDepth() }
    }

    fun getExitSet(): List<State> {
        val domain = getDomain()
        return activeLeafState.getStateConfiguration().states
                .filter { it.isDescendantOf(domain) }
                .sortedBy { it.getDepth() }.reversed()
    }

    fun getDomain(): State? {
        return if (kind == Target.Kind.DEFAULT
                && !source.isLeafState()
                && target.isDescendantOf(source))
            source
        else
            listOf(source, target).getLCCA()
    }
}
