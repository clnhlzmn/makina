package xyz.colinholzman.makina

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class MachineTest {
    @Test
    fun testHasDuplicateStates() {
        assertThrows<RuntimeException> {
            Parse.fileFromString("machine foo; state foo {} state foo {}")
        }
    }

    @Test
    fun hasDuplicateStatesBecauseOfIncompleteParentSpecification() {
        assertThrows<RuntimeException> {
            Parse.fileFromString("machine foo; " +
                    "state foo {} " +
                    "state foo.bar {} " +
                    "state bar.baz {} " +  //should be foo.bar.baz
                    "state qux {} " +
                    "state qux.bar {} " +
                    "state bar.baz {}")    //should be qux.bar.baz
        }
    }

    @Test
    fun testHasDuplicateStatesWithInitial() {
        assertThrows<RuntimeException> {
            Parse.fileFromString("machine foo; state foo {} initial state foo {}")
        }
    }

    @Test
    fun testNoDuplicateStates() {
        assertDoesNotThrow {
            Parse.fileFromString("machine foo; state foo {} state bar {}")
            Parse.fileFromString("machine foo; state foo {} state foo.bar {} state baz {} state baz.bar {}")
            Parse.fileFromString("machine foo; " +
                    "state foo {} " +
                    "state foo.bar {} " +
                    "state foo.bar.qux {} " +
                    "state baz {} " +
                    "state baz.fred {} " +
                    "state baz.fred.qux {}"
            )
            Parse.fileFromString("machine foo; state foo { state foo {} } state bar { state foo {} }")
            Parse.fileFromString("machine foo; state foo { state bar { state baz {} } } state qux { state bar { state baz {} } }")
        }
    }

    @Test
    fun testHasDuplicateInitialStates() {
        assertThrows<RuntimeException> {
            Parse.fileFromString("machine foo; initial state foo {} initial state bar {}")
        }
    }

    @Test
    fun testHasNoDuplicateInitialStates() {
        assertDoesNotThrow {
            Parse.fileFromString("machine foo; initial state foo {} state bar {}")
            Parse.fileFromString("machine foo; initial state foo {} initial state foo.bar {}")
        }
    }

    @Test
    fun getAllActionAndGuardNames() {
        val machine = Parse.fileFromString("machine foo; state bar { entry do_it; } state baz { exit do_that; on Foo do_this; }")
        assertEquals(setOf("do_it", "do_that", "do_this"), machine.getAllActionAndGuardNames())
    }

    @Test
    fun getAllEventNames() {
        val machine = Parse.fileFromString("machine foo; state bar { on qux do_it; } state baz { exit do_that; on Foo do_this; }")
        assertEquals(setOf("qux", "Foo"), machine.getAllEventNames())
    }

    @Test
    fun getInitialStateConfiguration() {
        var s1 = State("s1", initial = false)
        var s11 = State("s11", parentId = listOf("s1"), initial = false)
        var s12 = State("s12", parentId = listOf("s1"), initial = false)
        var s111 = State("s111", parentId = listOf("s1", "s11"), initial = false)
        var machine = Machine("foo", listOf(s1, s11, s12, s111))
        var expected = StateConfiguration(setOf(s1, s11, s111))
        assertEquals(expected, machine.getInitialStateConfiguration())

        s1 = State("s1", initial = true)
        machine = Machine("foo", listOf(s1, s11, s12, s111))
        expected = StateConfiguration(setOf(s1, s11, s111))
        assertEquals(expected, machine.getInitialStateConfiguration())

        s1 = State("s1", initial = false)
        s12 = State("s12", parentId = listOf("s1"), initial = true)
        machine = Machine("foo", listOf(s1, s11, s12, s111))
        expected = StateConfiguration(setOf(s1, s12))
        assertEquals(expected, machine.getInitialStateConfiguration())
    }
}