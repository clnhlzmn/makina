package xyz.colinholzman.makina

import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token

data class SourceLocation(val fileName: String, val lineNumber: Int, val column: Int) {
    override fun toString(): String {
        return "$lineNumber:$column in $fileName"
    }

    fun compareTo(other: SourceLocation): Int {
        val lineComparison = lineNumber.compareTo(other.lineNumber)
        return if (lineComparison != 0) lineComparison
        else column.compareTo(other.column)
    }

    companion object {
        fun fromToken(token: Token): SourceLocation {
            return SourceLocation(token.inputStream.sourceName, token.line, token.charPositionInLine + 1)
        }

        fun fromParseContext(ctx: ParserRuleContext): SourceLocation {
            return SourceLocation(ctx.start.inputStream.sourceName, ctx.start.line, ctx.start.charPositionInLine + 1)
        }

        val none = SourceLocation("?", -1, -1)
    }

}