package xyz.colinholzman.makina

import xyz.colinholzman.makina.State.Companion.areRelated
import xyz.colinholzman.makina.State.Companion.getLCCA

data class Transition(val source: State, val target: State, val kind: Target.Kind = Target.Kind.EXTERNAL) {
    init {
        if (!source.isLeafState())
            throw RuntimeException("source must be a leaf state")
        if (kind == Target.Kind.LOCAL) {
            //The UML spec says local transitions can't have the same source and target,
            //but I don't see why not, Yet...
            //It seems like a useful way to 'restart' a sub state without triggering
            //entry and exit actions for all parents
            //if (source == target)
            //  throw RuntimeException("source must not equal target")
            if (!listOf(source, target).areRelated())
                throw RuntimeException("source and target must be related")
        }
    }
    fun getEntrySet(): List<State> {
        return when (kind) {
            Target.Kind.EXTERNAL ->
                (listOf(target) + target.getProperAncestors(listOf(source, target).getLCCA())).reversed()
            Target.Kind.LOCAL ->
                TODO("same as for external but not including containing state")
        }
    }
    fun getExitSet(): List<State> {
        return when (kind) {
            Target.Kind.EXTERNAL ->
                listOf(source) + source.getProperAncestors(listOf(source, target).getLCCA())
            Target.Kind.LOCAL ->
                TODO("same as for external but not including containing state")
        }
    }
}