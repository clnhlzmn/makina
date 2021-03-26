package xyz.colinholzman.makina

class TargetVisitor: makinaBaseVisitor<Target>() {
    override fun visitExternalTransition(ctx: makinaParser.ExternalTransitionContext?): Target {
        val targetId = ctx!!.id().accept(IdVisitor())
        return Target(targetId, Target.Kind.EXTERNAL)
    }

    override fun visitLocalTransition(ctx: makinaParser.LocalTransitionContext?): Target {
        val targetId = ctx!!.id().accept(IdVisitor())
        return Target(targetId, Target.Kind.LOCAL)
    }
}