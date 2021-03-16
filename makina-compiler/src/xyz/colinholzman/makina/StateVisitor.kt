package xyz.colinholzman.makina

class StateVisitor: makinaBaseVisitor<List<State>>() {
    var currentParentId: String? = null
    override fun visitState(ctx: makinaParser.StateContext?): List<State> {
        val id = ctx!!.ID().text
        var parentId = if (ctx.parent() != null) ctx.parent().ID().text else null
        if (parentId == null)
            parentId = currentParentId
        else if (currentParentId != null && parentId != currentParentId)
            throw RuntimeException("invalid parent specified")
        val handlers = ctx.handler().map { it.accept(HandlerVisitor()) }
        val initial = ctx.initial != null
        currentParentId = id
        val childStates = ctx.state().flatMap { it.accept(this) }
        return childStates + State(id, handlers, parentId, initial)
    }
}