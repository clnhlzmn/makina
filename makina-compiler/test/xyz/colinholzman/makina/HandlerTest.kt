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
}