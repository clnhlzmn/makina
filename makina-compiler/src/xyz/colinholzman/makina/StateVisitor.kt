package xyz.colinholzman.makina

class StateVisitor: makinaBaseVisitor<State>() {
    override fun visitState(ctx: makinaParser.StateContext?): State {
        val id = ctx!!.ID().text
        val parentId = if (ctx.parent() != null) ctx.parent().ID().text else null
        val handlers = ctx.handler().map { it.accept(HandlerVisitor()) }.toMutableList()
        return State(id, handlers, parentId)
    }
}