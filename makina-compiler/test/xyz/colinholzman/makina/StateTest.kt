package xyz.colinholzman.makina

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.RuntimeException

internal class StateTest {
    @Test
    fun testHasDuplicateEntry() {
        val state = Parse.state("state foo { entry foo; entry bar; }")
        assert(state.hasDuplicateHandlers())
    }
    @Test
    fun testHasDuplicateExit() {
        val state = Parse.state("state foo { exit foo; exit bar; }")
        assert(state.hasDuplicateHandlers())
    }
    @Test
    fun testHasDuplicateEvent() {
        val state = Parse.state("state foo { on foo -> Bar; on foo (bar); }")
        assert(state.hasDuplicateHandlers())
    }

    @Test
    fun testNoDuplicateHandlers() {
        val state = Parse.state("state foo { entry foo; on bar; on qux; exit baz; }")
        assertFalse(state.hasDuplicateHandlers())
    }

    @Test
    fun testAssignSubStates() {
        val machine = Parse.fileFromString("machine foo; state bar {} state baz: bar {}")
        val bar = machine.states[0]
        val baz = machine.states[1]
        bar.assignSubStates(machine)
        baz.assignSubStates(machine)
        assertEquals(listOf(baz), bar.subStates)
        assertEquals(emptyList<State>(), baz.subStates)
    }

    @Test
    fun testAssignParent() {
        val machine = Parse.fileFromString("machine foo; state bar {} state baz: bar {}")
        val bar = machine.states[0]
        val baz = machine.states[1]
        bar.assignParent(machine)
        baz.assignParent(machine)
        assertEquals(null, bar.parent)
        assertEquals(bar, baz.parent)
    }

    @Test
    fun testAssignParentNotFound() {
        val machine = Parse.fileFromString("machine foo; state bar {} state baz: oops {}")
        val baz = machine.states[1]
        assertThrows<RuntimeException> {
            baz.assignParent(machine)
        }
    }

    @Test
    fun testIsLeafState() {
        val machine = Parse.fileFromString("machine foo; state bar {} state baz: bar {}")
        val bar = machine.states[0]
        val baz = machine.states[1]
        bar.assignSubStates(machine)
        baz.assignSubStates(machine)
        assertFalse(bar.isLeafState())
        assert(baz.isLeafState())
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

}