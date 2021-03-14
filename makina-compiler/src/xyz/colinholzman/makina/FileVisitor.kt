package xyz.colinholzman.makina

class FileVisitor: makinaBaseVisitor<File>() {
    override fun visitFile(ctx: makinaParser.FileContext?): File {
        return super.visitFile(ctx)
    }
}
