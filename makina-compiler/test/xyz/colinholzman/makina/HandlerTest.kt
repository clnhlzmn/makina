package xyz.colinholzman.makina

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import xyz.colinholzman.makina.GetState.Companion.getState
import xyz.colinholzman.makina.TestStates.Companion.machine
import xyz.colinholzman.makina.TestStates.Companion.s1
import xyz.colinholzman.makina.TestStates.Companion.s11
import xyz.colinholzman.makina.TestStates.Companion.s111
import xyz.colinholzman.makina.TestStates.Companion.s12
import xyz.colinholzman.makina.TestStates.Companion.s121
import xyz.colinholzman.makina.TestStates.Companion.s2
import xyz.colinholzman.makina.TestStates.Companion.s21
import xyz.colinholzman.makina.TestStates.Companion.s3
import xyz.colinholzman.makina.TestStates.Companion.s3_s12

internal class HandlerTest {
    @Test
    fun getTargetState() {
        val s1 = State("s1")
        val s11 = State("s11", parentId = listOf(".", "s1"))
        val s12 = State("s12", parentId = listOf(".", "s1"))
        val handler = Handler.Event("foo", target = Target(listOf(".", "s2")))
        val s111 = State("s111", parentId = listOf(".", "s1", "s11"), handlers = listOf(handler))
        val s2 = State("s2")
        val machine = Machine("test", listOf(s1, s11, s12, s111, s2))
        assertEquals(s2, handler.getTargetState(s111, machine))
    }

    @Test
    fun getMaybeAmbiguousTargetState() {
        val machine = Parse.fileFromString("machine foo; " +
                "state bar { state foo { }                state baz { } } " +
                "state qux { state foo { on foo -> baz; } state baz { } }")
        val bar_foo = machine.states.find { it.parent?.id == "bar" && it.id == "foo" }!!
        val qux_foo = machine.states.find { it.parent?.id == "qux" && it.id == "foo" }!!
        val bar_baz = machine.states.find { it.parent?.id == "bar" && it.id == "baz" }!!
        val qux_baz = machine.states.find { it.parent?.id == "qux" && it.id == "baz" }!!
        val handler = qux_foo.handlers.first() as Handler.Event
        assertEquals(qux_baz, handler.getTargetState(qux_foo, machine))
    }

    @Test
    fun getPartiallySpecifiedTargetState() {
        var handler = Handler.Event("foo", target = Target(listOf("s11", "s111")))
        assertEquals(s111, handler.getTargetState(s12, machine))

        handler = Handler.Event("foo", target = Target(listOf("s121")))
        assertEquals(s121, handler.getTargetState(s12, machine))

        handler = Handler.Event("foo", target = Target(listOf("s3", "s12")))
        assertEquals(s3_s12, handler.getTargetState(s1, machine))

        handler = Handler.Event("foo", target = Target(listOf("s12")))
        assertEquals(s12, handler.getTargetState(s1, machine))

        handler = Handler.Event("foo", target = Target(listOf(".", "s2")))
        assertEquals(s2, handler.getTargetState(s3, machine))

        handler = Handler.Event("foo", target = Target(listOf("s12")))
        assertEquals(s12, handler.getTargetState(s11, machine))

        handler = Handler.Event("foo", target = Target(listOf("s1")))
        assertEquals(s1, handler.getTargetState(s2, machine))
    }

    @Test
    fun entryOrder() {
        run {
            val machine = Parse.fileFromString("""
                machine test;
                state foo { on e; } state bar { on e; }
                state baz { on e; state qux { on e; } }
                """.trimIndent())
            val stateNames = listOf(".foo", ".bar", ".baz", ".baz.qux")
            val states = stateNames.map { machine.getState(it) }
            val pairs = states.map { Pair(it, it.handlers.first()) }
            val actual = pairs.shuffled().sortedWith(Handler.entryOrder)
            val expected = pairs
            assertEquals(expected, actual)
        }
    }

    @Test
    fun exitOrder() {
        run {
            val machine = Parse.fileFromString("""
                machine test;
                state foo { on e; } state bar { on e; }
                state baz { on e; state qux { on e; } }
                """.trimIndent())
            val stateNames = listOf(".foo", ".bar", ".baz", ".baz.qux").reversed()
            val states = stateNames.map { machine.getState(it) }
            val pairs = states.map { Pair(it, it.handlers.first()) }
            val actual = pairs.shuffled().sortedWith(Handler.exitOrder)
            val expected = pairs
            assertEquals(expected, actual)
        }
    }
}