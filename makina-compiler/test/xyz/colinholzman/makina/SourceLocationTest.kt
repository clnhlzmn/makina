package xyz.colinholzman.makina

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

class SourceLocationTest {
    @Test
    fun sourceLocation() {
        val sourceFile = File.createTempFile("makina", ".mkna")
        val fileName = sourceFile.absoluteFile.toString()
        sourceFile.writeText("""
            machine foo;
            state bar { entry qux; }
            state baz { on this that;
                         exit fred; }
            """.trimIndent())
        val machine = Parse.file(sourceFile.absolutePath)
        val bar = machine.states.find { it.id == "bar" }!!
        val baz = machine.states.find { it.id == "baz" }!!
        val qux = bar.handlers.first() as Handler.Entry
        val this_that = baz.handlers.filterIsInstance<Handler.Event>().first()
        val fred = baz.handlers.filterIsInstance<Handler.Exit>().first()
        assertEquals(SourceLocation(fileName, 1, 1), machine.location)
        assertEquals(SourceLocation(fileName, 2, 1), bar.location)
        assertEquals(SourceLocation(fileName, 3, 1), baz.location)
        assertEquals(SourceLocation(fileName, 2, 13), qux.location)
        assertEquals(SourceLocation(fileName, 3, 13), this_that.location)
        assertEquals(SourceLocation(fileName, 4, 14), fred.location)
    }
}