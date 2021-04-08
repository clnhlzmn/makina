package xyz.colinholzman.makina

import xyz.colinholzman.makina.State.Companion.getLCCA

data class Transition(val activeConfiguration: List<State>,
                      val source: State, val target: State,
                      val kind: Target.Kind = Target.Kind.DEFAULT) {

    constructor (activeAtomicState: State, source: State, target: State,
                 kind: Target.Kind = Target.Kind.DEFAULT): this(listOf(activeAtomicState), source, target, kind)

    fun getEntrySet(): List<State> {
        val ret = ArrayList<State>()
        ret.add(target)
        ret.addAll(target.getDefaultEntrySet())
        val domain = getDomain()
        val ancestors = target.getProperAncestors(domain)
        ancestors.forEach { ret.add(it); ret.addAll(it.getDefaultEntrySet()) }
        return ret.distinct().sortedBy { it.getDepth() }
    }

    fun getExitSet(): List<State> {
        val domain = getDomain()
        return activeConfiguration.flatMap { activeState ->
            activeState.getBranch()
                .filter { it.isDescendantOf(domain) }
        }.distinct().sortedBy { it.getDepth() }.reversed()
    }

    fun getDomain(): State? {
        return if (kind == Target.Kind.DEFAULT
                && target.isDescendantOf(source))
            source
        else
            listOf(source, target).getLCCA()
    }
}
