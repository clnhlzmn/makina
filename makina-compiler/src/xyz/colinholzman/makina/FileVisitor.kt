package xyz.colinholzman.makina

class FileVisitor: makinaBaseVisitor<Machine>() {
    override fun visitFile(ctx: makinaParser.FileContext?): Machine {
        val states = ctx!!.state().map { it.accept(StateVisitor()) }
        return Machine(ctx.ID().text, states)
    }
}
