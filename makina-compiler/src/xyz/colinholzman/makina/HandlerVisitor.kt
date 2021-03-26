package xyz.colinholzman.makina

class HandlerVisitor: makinaBaseVisitor<Handler>() {
    override fun visitEntryHandler(ctx: makinaParser.EntryHandlerContext?): Handler {
        return Handler.Entry(ctx!!.action().text, SourceLocation.fromParseContext(ctx))
    }

    override fun visitExitHandler(ctx: makinaParser.ExitHandlerContext?): Handler {
        return Handler.Exit(ctx!!.action().text, SourceLocation.fromParseContext(ctx))
    }

    override fun visitEventHandler(ctx: makinaParser.EventHandlerContext?): Handler {
        val event = ctx!!.ID().text
        val guard = if (ctx.guard() != null) ctx.guard().ID().text else null
        val action = if (ctx.action() != null) ctx.action().ID().text else null
        val target = if (ctx.target() == null) null else ctx.target().accept(TargetVisitor())
        return Handler.Event(event, guard, action, target, SourceLocation.fromParseContext(ctx))
    }
}