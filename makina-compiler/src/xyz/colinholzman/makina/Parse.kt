package xyz.colinholzman.makina

import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

class Parse {
    companion object {
        private fun parser(stream: CharStream): makinaParser {
            val lexer = makinaLexer(stream)
            val tokens = CommonTokenStream(lexer)
            val parser = makinaParser(tokens)
            parser.removeErrorListeners()
            parser.addErrorListener(ThrowingErrorListener.INSTANCE)
            return parser
        }
        fun fileFromString(content: String): File {
            val stream = CharStreams.fromString(content)
            val parser = parser(stream)
            val context = parser.file()
            return context.accept(FileVisitor())
        }
        fun file(path: String): File {
            val stream = CharStreams.fromFileName(path)
            val parser = parser(stream)
            val context = parser.file()
            return context.accept(FileVisitor())
        }
    }
}