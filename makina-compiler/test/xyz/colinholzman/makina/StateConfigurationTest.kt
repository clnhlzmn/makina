package xyz.colinholzman.makina

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class StateConfigurationTest {

    @Test
    fun testIsValid() {
        assertTrue(StateConfiguration(setOf(TestStates.s1, TestStates.s11, TestStates.s111)).isValid())
        assertFalse(StateConfiguration(setOf(TestStates.s1, TestStates.s11, TestStates.s12, TestStates.s111)).isValid())
        assertFalse(StateConfiguration(setOf(TestStates.s1, TestStates.s21, TestStates.s111)).isValid())
    }

    @Test
    fun getHandlers() {
        val parent = Parse.state("state foo { on bar; }")
        val child = Parse.state("state baz: foo { on qux; }")
        parent.subStates.add(child)
        child.parent = parent
        val config = StateConfiguration(setOf(child, parent))
        assertEquals(listOf(Handler.Event("qux"), Handler.Event("bar")), config.getHandlers())
    }
}