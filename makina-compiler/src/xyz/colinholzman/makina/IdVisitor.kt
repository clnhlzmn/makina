package xyz.colinholzman.makina

class IdVisitor: makinaBaseVisitor<List<String>>() {
    override fun visitId(ctx: makinaParser.IdContext?): List<String> {
        val root = if(ctx!!.root != null) listOf(".") else emptyList()
        return root + ctx.ID().map { it.text }
    }
}