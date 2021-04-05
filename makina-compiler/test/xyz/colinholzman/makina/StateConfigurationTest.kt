package xyz.colinholzman.makina

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import xyz.colinholzman.makina.StateConfiguration.Companion.groupByIdAndRemoveRedundantHandlers
import xyz.colinholzman.makina.TestStates.Companion.s1
import xyz.colinholzman.makina.TestStates.Companion.s11
import xyz.colinholzman.makina.TestStates.Companion.s111
import xyz.colinholzman.makina.TestStates.Companion.s2

internal class StateConfigurationTest {

    @Test
    fun testIsValid() {
        assertDoesNotThrow {
            StateConfiguration(s111)
        }
        assertThrows<RuntimeException> {
            StateConfiguration(s11)
        }
        assertThrows<RuntimeException> {
            StateConfiguration(s2)
        }
    }

    @Test
    fun getHandlers() {
        val parent = Parse.state("state foo { on bar; }").first()
        val child = Parse.state("state .foo.baz { on qux; }").first()
        parent.subStates = listOf(child)
        child.parent = parent
        val config = StateConfiguration(child)
        assertEquals(listOf(Pair(child, Handler.Event("qux")), Pair(parent, Handler.Event("bar"))), config.getHandlers())
    }

    @Test
    fun getEntryHandlers() {
        val parent = Parse.state("state foo { entry bar; }").first()
        val child = Parse.state("state .foo.baz { entry qux; }").first()
        parent.subStates = listOf(child)
        child.parent = parent
        val config = StateConfiguration(child)
        assertEquals(listOf(Handler.Entry("bar"), Handler.Entry("qux")), config.getEntryHandlers())
    }

    @Test
    fun getAtomicState() {
        val parent = Parse.state("state foo { on bar; }").first()
        val child = Parse.state("state .foo.baz { on qux; }").first()
        parent.subStates = listOf(child)
        child.parent = parent
        val config = StateConfiguration(child)
        assertEquals(child, config.getAtomicState())
    }

    @Test
    fun filterHandlers() {
        var handlers = arrayListOf(
                Pair(s111, Handler.Event("foo")),
                Pair(s11, Handler.Event("foo")),
                Pair(s1, Handler.Event("foo"))
        )
        var expected = mapOf(Pair("foo", listOf(Pair(s111, Handler.Event("foo")))))
        assertEquals(expected, handlers.groupByIdAndRemoveRedundantHandlers())


        handlers = arrayListOf(
                Pair(s111, Handler.Event("foo")),
                Pair(s11, Handler.Event("foo")),
                Pair(s1, Handler.Event("foo", guard = "bar"))
        )
        expected = mapOf(Pair("foo", listOf(Pair(s111, Handler.Event("foo")))))
        assertEquals(expected, handlers.groupByIdAndRemoveRedundantHandlers())


        handlers = arrayListOf(
                Pair(s111, Handler.Event("foo")),
                Pair(s11, Handler.Event("bar")),
                Pair(s1, Handler.Event("foo"))
        )
        expected = mapOf(Pair("foo", listOf(Pair(s111, Handler.Event("foo")))),
                         Pair("bar", listOf(Pair(s11, Handler.Event("bar")))))
        assertEquals(expected, handlers.groupByIdAndRemoveRedundantHandlers())


        handlers = arrayListOf(
                Pair(s111, Handler.Event("foo", guard = "bar")),
                Pair(s11, Handler.Event("foo", guard = "baz")),
                Pair(s1, Handler.Event("foo"))
        )
        expected = mapOf(Pair("foo", listOf(Pair(s111, Handler.Event("foo", guard = "bar")),
                                            Pair(s11, Handler.Event("foo", guard = "baz")),
                                            Pair(s1, Handler.Event("foo")))))
        assertEquals(expected, handlers.groupByIdAndRemoveRedundantHandlers())
    }
}