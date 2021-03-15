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

    //               s1            s2
    //             /   \           |
    //           /      \         s21
    //         s11      s12
    //        /  \      /  \
    //     s111 s112 s121 s122

    val s111 = State("s111")
    val s112 = State("s112")
    val s11 = State("s11")

    val s121 = State("s121")
    val s122 = State("s122")
    val s12 = State("s12")

    val s1 = State("s1")

    val s21 = State("s21")
    val s2 = State("s2")

    init {
        s111.parent = s11
        s112.parent = s11

        s121.parent = s12
        s122.parent = s12

        s11.parent = s1
        s12.parent = s1

        s21.parent = s2

        s2.subStates.add(s21)
        s1.subStates.addAll(listOf(s11, s12))

        s11.subStates.addAll(listOf(s111, s112))
        s12.subStates.addAll(listOf(s121, s122))
    }

    @Test
    fun testGetProperAncestors() {
        assertEquals(setOf(s1, s11), s111.getProperAncestors(null))
        assertEquals(setOf(s2), s21.getProperAncestors(null))
        assertEquals(emptySet<State>(), s1.getProperAncestors(null))
        assertEquals(emptySet<State>(), s1.getProperAncestors(s111))
        assertEquals(setOf(s11), s111.getProperAncestors(s1))
    }

    @Test
    fun testGetLCCA() {
        assertEquals(s1, State.getLCCA(listOf(s111, s121)))
        assertEquals(s11, State.getLCCA(listOf(s111, s112)))
        assertEquals(null, State.getLCCA(listOf(s12, s21)))
    }

}