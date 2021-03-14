package xyz.colinholzman.makina

import org.junit.jupiter.api.Test
import kotlin.math.exp
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

    @Test
    fun testParseEntryHandler() {
        val actual = Parse.handler("entry Foo;")
        val expected = Handler.Entry("Foo")
        assertEquals(expected, actual)
    }

    @Test
    fun testParseExitHandler() {
        val actual = Parse.handler("exit Foo;")
        val expected = Handler.Exit("Foo")
        assertEquals(expected, actual)
    }

    @Test
    fun testParseSimpleEventHandler() {
        val actual = Parse.handler("on Foo;")
        val expected = Handler.Event("Foo", null, null, null)
        assertEquals(expected, actual)
    }

    @Test
    fun testParseGuardEventHandler() {
        val actual = Parse.handler("on Foo (bar);")
        val expected = Handler.Event("Foo", "bar", null, null)
        assertEquals(expected, actual)
    }

    @Test
    fun testParseActionEventHandler() {
        val actual = Parse.handler("on Foo bar;")
        val expected = Handler.Event("Foo", null, "bar", null)
        assertEquals(expected, actual)
    }

    @Test
    fun testParseTransitionEventHandler() {
        val actual = Parse.handler("on Foo -> bar;")
        val expected = Handler.Event("Foo", null, null, "bar")
        assertEquals(expected, actual)
    }
}