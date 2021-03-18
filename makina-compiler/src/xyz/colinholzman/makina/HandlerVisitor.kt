package xyz.colinholzman.makina

class HandlerVisitor: makinaBaseVisitor<Handler>() {
    override fun visitEntryHandler(ctx: makinaParser.EntryHandlerContext?): Handler {
        return Handler.Entry(ctx!!.action().text)
    }

    override fun visitExitHandler(ctx: makinaParser.ExitHandlerContext?): Handler {
        return Handler.Exit(ctx!!.action().text)
    }

    override fun visitEventHandler(ctx: makinaParser.EventHandlerContext?): Handler {
        val event = ctx!!.ID().text
        val guard = if (ctx.guard() != null) ctx.guard().ID().text else null
        val action = if (ctx.action() != null) ctx.action().ID().text else null
        val target = if (ctx.target() == null) emptyList<String>()
                        else ctx.target().id().accept(IdVisitor())
        return Handler.Event(event, guard, action, target)
    }
}