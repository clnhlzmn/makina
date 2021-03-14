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
        assert(!state.hasDuplicateHandlers())
    }

    @Test
    fun testAssignSubStates() {
        val machine = Parse.fileFromString("machine foo; state bar {} state baz: bar {}")
        val bar = machine.states[0]
        val baz = machine.states[1]
        bar.assignSubStates(machine)
        val expected = listOf(baz)
        assertEquals(expected, bar.subStates)
    }

    @Test
    fun testAssignParent() {
        val machine = Parse.fileFromString("machine foo; state bar {} state baz: bar {}")
        val bar = machine.states[0]
        val baz = machine.states[1]
        baz.assignParent(machine)
        assertEquals(bar, baz.parent)
    }

    @Test
    fun testAssignParentNotFound() {
        val machine = Parse.fileFromString("machine foo; state bar {} state baz: oops {}")
        val bar = machine.states[0]
        val baz = machine.states[1]
        assertThrows<RuntimeException> {
            baz.assignParent(machine)
        }
    }
}