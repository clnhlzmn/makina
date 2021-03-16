package xyz.colinholzman.makina

class IdVisitor: makinaBaseVisitor<List<String>>() {
    override fun visitId(ctx: makinaParser.IdContext?): List<String> {
        return ctx!!.ID().map { it.text }
    }
}