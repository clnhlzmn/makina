package xyz.colinholzman.makina

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
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
        file.writeText("machine Foo; state Bar {}")
        val actual = Parse.file(file.absolutePath)
        val expected = Machine("Foo", listOf(State("Bar", listOf())))
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
        val expected = Handler.Event("Foo", null, null)
        assertEquals(expected, actual)
    }

    @Test
    fun testParseGuardEventHandler() {
        val actual = Parse.handler("on Foo (bar);")
        val expected = Handler.Event("Foo", "bar", null)
        assertEquals(expected, actual)
    }

    @Test
    fun testParseActionEventHandler() {
        val actual = Parse.handler("on Foo bar;")
        val expected = Handler.Event("Foo", null, "bar")
        assertEquals(expected, actual)
    }

    @Test
    fun testParseTransitionEventHandler() {
        val actual = Parse.handler("on Foo -> bar;")
        val expected = Handler.Event("Foo", null, null, Target(listOf("bar")))
        assertEquals(expected, actual)
    }

    @Test
    fun testParseLocalTransitionEventHandler() {
        val actual = Parse.handler("on Foo --> bar;")
        val expected = Handler.Event("Foo", null, null, Target(listOf("bar"), Target.Kind.EXTERNAL))
        assertEquals(expected, actual)
    }

    @Test
    fun testParseEmptyState() {
        val actual = Parse.state("state Foo {}").first()
        val expected = State("Foo", listOf(), parentId = listOf("."))
        assertEquals(expected, actual)
    }

    @Test
    fun testParseStateWithParent() {
        val actual = Parse.state("state Bar.Foo {}").first()
        val expected = State("Foo", listOf(), listOf(".", "Bar"))
        assertEquals(expected, actual)
    }

    @Test
    fun testParseStateWithParentAbsolute() {
        val actual = Parse.state("state .Bar.Foo {}").first()
        val expected = State("Foo", listOf(), listOf(".", "Bar"))
        assertEquals(expected, actual)
    }

    @Test
    fun testParseStateWithHandler() {
        val actual = Parse.state("state Foo { entry bar; }").first()
        val expected = State("Foo", listOf(Handler.Entry("bar")))
        assertEquals(expected, actual)
    }

    @Test
    fun testParseInitialState() {
        val actual = Parse.state("initial state Foo { }").first()
        val expected = State("Foo", listOf(), initial = true)
        assertEquals(expected, actual)
    }

    @Test
    fun testFinalState() {
        val actual = Parse.state("final state Foo {}").first()
        val expected = State(id = "Foo", final = true)
        assertEquals(expected, actual)
    }

    @Test
    fun initialFinalState() {
        assertThrows<RuntimeException> {
            Parse.state("initial final state foo {}")
        }
    }

    @Test
    fun testParseStateWithSubStates() {
        val actual = Parse.state("state foo { state bar {} }").toSet()
        val expected = setOf(State("foo"), State("bar", parentId = listOf(".", "foo")))
        assertEquals(expected, actual)
    }

    @Test
    fun testNestedStateIsAtomic() {
        val machine = Parse.fileFromString("machine foo; state bar { state baz {} state qux {} } state fred {}")
        val bar = machine.states.find { it.id == "bar" }!!
        val baz = machine.states.find { it.id == "baz" }!!
        val qux = machine.states.find { it.id == "qux" }!!
        val fred = machine.states.find { it.id == "fred" }!!
        assertFalse(bar.isAtomic())
        assert(baz.isAtomic())
        assert(qux.isAtomic())
        assert(fred.isAtomic())
    }
}
