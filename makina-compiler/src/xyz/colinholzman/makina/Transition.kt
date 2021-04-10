package xyz.colinholzman.makina

import xyz.colinholzman.makina.State.Companion.getLCCA

data class Transition(val activeConfiguration: List<State>,
                      val source: State, val target: State,
                      val kind: Target.Kind = Target.Kind.DEFAULT) {

    constructor (activeAtomicState: State, source: State, target: State,
                 kind: Target.Kind = Target.Kind.DEFAULT): this(listOf(activeAtomicState), source, target, kind)

    private fun addDescendantsOfParallelStateToEnter(parallel: State, statesToEnter: MutableList<State>) {
        for (child in parallel.subStates)
            if (!statesToEnter.any { it.isDescendantOf(child) })
                addDescendantStatesToEnter(child, statesToEnter)
    }

    private fun addDescendantStatesToEnter(target: State, statesToEnter: MutableList<State>) {
        statesToEnter.add(target)
        if (target.isParallel()) {
            addDescendantsOfParallelStateToEnter(target, statesToEnter)
        } else if (target.isCompound()) {
            addDescendantStatesToEnter(target.getInitialSubState(), statesToEnter)
            addAncestorStatesToEnter(target.getInitialSubState(), target, statesToEnter)
        }
    }

    private fun addAncestorStatesToEnter(target: State, ancestor: State?, statesToEnter: MutableList<State>) {
        for (anc in target.getProperAncestors(ancestor)) {
            statesToEnter.add(anc)
            if (anc.isParallel())
                addDescendantsOfParallelStateToEnter(anc, statesToEnter)
        }
    }

    fun getEntrySet(): List<State> {
        val entrySet = ArrayList<State>()
        addDescendantStatesToEnter(target, entrySet)
        addAncestorStatesToEnter(target, getDomain(), entrySet)
        return entrySet.distinct().sortedWith(State.entryOrder)
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
