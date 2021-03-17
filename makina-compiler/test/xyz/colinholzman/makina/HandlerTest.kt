package xyz.colinholzman.makina

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class HandlerTest {
    @Test
    fun getTargetState() {
        val s1 = State("s1")
        val s11 = State("s11", parentId = listOf("s1"))
        val s12 = State("s12", parentId = listOf("s1"))
        val handler = Handler.Event("foo", target = "s2")
        val s111 = State("s111", parentId = listOf("s1", "s11"), handlers = listOf(handler))
        val s2 = State("s2")
        val machine = Machine("test", listOf(s1, s11, s12, s111, s2))
        assertEquals(s2, handler.getTargetState(machine))
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
        assertEquals(qux_baz, handler.getTargetState(machine))
    }
}