package xyz.colinholzman.makina

class FileVisitor: makinaBaseVisitor<Machine>() {
    override fun visitFile(ctx: makinaParser.FileContext?): Machine {
        return Machine(ctx!!.ID().text)
    }
}
