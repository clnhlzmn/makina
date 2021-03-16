package xyz.colinholzman.makina

class ParentVisitor: makinaBaseVisitor<List<String>>() {
    override fun visitParent(ctx: makinaParser.ParentContext?): List<String> {
        if (ctx!!.ID() == null) return emptyList()
        else return ctx.ID().map { it.text }
    }
}