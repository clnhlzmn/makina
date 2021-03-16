package xyz.colinholzman.makina

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import xyz.colinholzman.makina.TestStates.Companion.s1
import xyz.colinholzman.makina.TestStates.Companion.s2
import xyz.colinholzman.makina.TestStates.Companion.s21
import xyz.colinholzman.makina.TestStates.Companion.s11
import xyz.colinholzman.makina.TestStates.Companion.s12
import xyz.colinholzman.makina.TestStates.Companion.s111
import xyz.colinholzman.makina.TestStates.Companion.s121

internal class StateTest {
    @Test
    fun testHasDuplicateEntry() {
        assertThrows<RuntimeException> {
            Parse.state("state foo { entry foo; entry bar; }")
        }
    }
    @Test
    fun testHasDuplicateExit() {
        assertThrows<RuntimeException> {
            Parse.state("state foo { exit foo; exit bar; }")
        }
    }
    @Test
    fun testHasDuplicateEvent() {
        assertThrows<RuntimeException> {
            Parse.state("state foo { on foo -> Bar; on foo do_it; }")
        }
        assertDoesNotThrow {
            Parse.state("state foo { on foo -> Bar; on foo (bar); }")
        }
    }

    @Test
    fun testNoDuplicateHandlers() {
        assertDoesNotThrow {
            Parse.state("state foo { entry foo; on bar; on qux; exit baz; }")
        }
    }

    @Test
    fun hasDuplicateSubstates() {
        val state = State("foo")
        val child = State("child", initial = true)
        val child2 = State("child2", initial = true)
        assertThrows<RuntimeException> {
            state.subStates = listOf(child, child2)
        }
    }

    @Test
    fun testAssignSubStates() {
        val machine = Parse.fileFromString("machine foo; state bar {} state baz: bar {}")
        val bar = machine.states[0]
        val baz = machine.states[1]
        assertEquals(listOf(baz), bar.subStates)
        assertEquals(emptyList<State>(), baz.subStates)
    }

    @Test
    fun testAssignParent() {
        val machine = Parse.fileFromString("machine foo; state bar {} state baz: bar {}")
        val bar = machine.states[0]
        val baz = machine.states[1]
        assertEquals(null, bar.parent)
        assertEquals(bar, baz.parent)
    }

    @Test
    fun testAssignParentNotFound() {
        assertThrows<RuntimeException> {
            Parse.fileFromString("machine foo; state bar {} state baz: oops {}")
        }
    }

    @Test
    fun testIsLeafState() {
        val machine = Parse.fileFromString("machine foo; state bar {} state baz: bar {}")
        val bar = machine.states[0]
        val baz = machine.states[1]
        assertFalse(bar.isLeafState())
        assert(baz.isLeafState())
    }

    @Test
    fun testGetDepth() {
        assertEquals(2, TestStates.s111.getDepth())
        assertEquals(0, TestStates.s1.getDepth())
    }

    @Test
    fun testIsDescendantOf() {
        val foo = Parse.state("state foo {}")
        val bar = Parse.state("state bar {}")
        bar.parent = foo
        assert(bar.isDescendantOf(foo))
        assertFalse(foo.isDescendantOf(bar))
    }

    @Test
    fun testGetProperAncestors() {
        assertEquals(listOf(TestStates.s11, TestStates.s1), TestStates.s111.getProperAncestors(null))
        assertEquals(listOf(TestStates.s2), TestStates.s21.getProperAncestors(null))
        assertEquals(emptyList<State>(), TestStates.s1.getProperAncestors(null))
        assertEquals(emptyList<State>(), TestStates.s1.getProperAncestors(TestStates.s111))
        assertEquals(listOf(TestStates.s11), TestStates.s111.getProperAncestors(TestStates.s1))
    }

    @Test
    fun testGetLCCA() {
        assertEquals(TestStates.s1, State.getLCCA(listOf(TestStates.s111, TestStates.s121)))
        assertEquals(TestStates.s11, State.getLCCA(listOf(TestStates.s111, TestStates.s112)))
        assertEquals(null, State.getLCCA(listOf(TestStates.s12, TestStates.s21)))
    }

    @Test
    fun getStateConfiguration() {
        assertEquals(StateConfiguration(setOf(s2, s21)), s21.getStateConfiguration())
        assertEquals(StateConfiguration(setOf(s2, s21)), s2.getStateConfiguration())
        assertEquals(StateConfiguration(setOf(s1, s12, s121)), s1.getStateConfiguration())
        assertEquals(StateConfiguration(setOf(s1, s11, s111)), s11.getStateConfiguration())
        assertEquals(StateConfiguration(setOf(s1, s11, s111)), s111.getStateConfiguration())
    }

}