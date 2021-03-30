package xyz.colinholzman.makina

class StateTypeVisitor: makinaBaseVisitor<State.Type>() {
    override fun visitFinalType(ctx: makinaParser.FinalTypeContext?): State.Type {
        return State.Type.Final
    }

    override fun visitInitialType(ctx: makinaParser.InitialTypeContext?): State.Type {
        return State.Type.Default(true)
    }

    override fun visitParallelType(ctx: makinaParser.ParallelTypeContext?): State.Type {
        return State.Type.Parallel(ctx!!.initial != null)
    }

    override fun visitDefaultType(ctx: makinaParser.DefaultTypeContext?): State.Type {
        return State.Type.Default(false)
    }
}