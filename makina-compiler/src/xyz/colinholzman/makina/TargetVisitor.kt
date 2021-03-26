package xyz.colinholzman.makina

class TargetVisitor: makinaBaseVisitor<Target>() {
    override fun visitExternalTransition(ctx: makinaParser.ExternalTransitionContext?): Target {
        val targetId = ctx!!.id().accept(IdVisitor())
        return Target(targetId, Target.Kind.EXTERNAL)
    }

    override fun visitDefaultTransition(ctx: makinaParser.DefaultTransitionContext?): Target {
        val targetId = ctx!!.id().accept(IdVisitor())
        return Target(targetId, Target.Kind.DEFAULT)
    }
}