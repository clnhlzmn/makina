package xyz.colinholzman.makina

class StateVisitor: makinaBaseVisitor<List<State>>() {
    var currentParentId = listOf(".")

    private fun withNewParentId(id: String, block: ()->Unit) {
        val lastParentId = currentParentId
        currentParentId = currentParentId + id
        block()
        currentParentId = lastParentId
    }

    override fun visitState(ctx: makinaParser.StateContext?): List<State> {
        val fullId = ctx!!.id().accept(IdVisitor())
        val id = fullId.last()
        var parentId = fullId.dropLast(1)
        if (parentId.isEmpty())
            parentId = currentParentId
        else if (currentParentId.isRoot() && parentId.first() != ".")
            parentId = listOf(".") + parentId
        else if (currentParentId.isNotRoot() && parentId != currentParentId)
            throw RuntimeException("invalid parent specified at ${SourceLocation.fromParseContext(ctx)}")
        val handlers = ctx.handler().map { it.accept(HandlerVisitor()) }
        val initial = ctx.initial != null
        val final = ctx.final_ != null
        var childStates: List<State> = emptyList()
        withNewParentId(id) {
            childStates = ctx.state().flatMap { it.accept(this) }
        }
        return childStates + State(id, handlers, parentId, initial, final, SourceLocation.fromParseContext(ctx))
    }
}