package xyz.colinholzman.makina

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ParseTest {
    @Test
    fun testParseFileFromString() {
        val actual = Parse.fileFromString("machine Foo;")
        val expected = Machine("Foo")
        assertEquals(expected, actual)
    }

    @Test
    fun testParseFile() {
        val file = java.io.File.createTempFile("makina", "makina")
        file.writeText("machine Foo;")
        val actual = Parse.file(file.absolutePath)
        val expected = Machine("Foo")
        assertEquals(expected, actual)
    }
}