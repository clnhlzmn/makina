package xyz.colinholzman.makina

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

internal class StateConfigurationTest {

    @Test
    fun testIsValid() {
        assertDoesNotThrow {
            StateConfiguration(setOf(TestStates.s1, TestStates.s11, TestStates.s111))
        }
        assertThrows<RuntimeException> {
            StateConfiguration(setOf(TestStates.s1, TestStates.s11, TestStates.s12, TestStates.s111))
        }
        assertThrows<RuntimeException> {
            StateConfiguration(setOf(TestStates.s1, TestStates.s21, TestStates.s111))
        }
    }

    @Test
    fun getHandlers() {
        val parent = Parse.state("state foo { on bar; }").first()
        val child = Parse.state("state baz: foo { on qux; }").first()
        parent.subStates = listOf(child)
        child.parent = parent
        val config = StateConfiguration(setOf(child, parent))
        assertEquals(listOf(Handler.Event("qux"), Handler.Event("bar")), config.getHandlers())
    }

    @Test
    fun getEntryHandlers() {
        val parent = Parse.state("state foo { entry bar; }").first()
        val child = Parse.state("state baz: foo { entry qux; }").first()
        parent.subStates = listOf(child)
        child.parent = parent
        val config = StateConfiguration(setOf(child, parent))
        assertEquals(listOf(Handler.Entry("bar"), Handler.Entry("qux")), config.getEntryHandlers())
    }

    @Test
    fun getLeafState() {
        val parent = Parse.state("state foo { on bar; }").first()
        val child = Parse.state("state baz: foo { on qux; }").first()
        parent.subStates = listOf(child)
        child.parent = parent
        val config = StateConfiguration(setOf(child, parent))
        assertEquals(child, config.getLeafState())
    }
}