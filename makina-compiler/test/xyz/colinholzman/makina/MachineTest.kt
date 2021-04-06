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
            Parse.fileFromString("machine foo; state foo {} state .foo.bar {} state baz {} state .baz.bar {}")
            Parse.fileFromString("machine foo; " +
                    "state foo {} " +
                    "state .foo.bar {} " +
                    "state .foo.bar.qux {} " +
                    "state baz {} " +
                    "state .baz.fred {} " +
                    "state .baz.fred.qux {}"
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
            Parse.fileFromString("machine foo; initial state foo {} initial state .foo.bar {}")
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
        var s1 = State("s1")
        var s11 = State("s11", parentId = listOf(".", "s1"))
        var s12 = State("s12", parentId = listOf(".", "s1"))
        var s111 = State("s111", parentId = listOf(".", "s1", "s11"))
        var machine = Machine("foo", listOf(s1, s11, s12, s111))
        var expected = StateConfiguration(s111)
        assertEquals(expected, machine.getInitialStateConfiguration())

        s1 = State("s1", type = State.Type.Default(true))
        machine = Machine("foo", listOf(s1, s11, s12, s111))
        expected = StateConfiguration(s111)
        assertEquals(expected, machine.getInitialStateConfiguration())

        s1 = State("s1")
        s12 = State("s12", parentId = listOf(".", "s1"), type = State.Type.Default(true))
        machine = Machine("foo", listOf(s1, s11, s12, s111))
        expected = StateConfiguration(s12)
        assertEquals(expected, machine.getInitialStateConfiguration())
    }

    @Test
    fun getAllConfigurations() {
        run {
            val machine = Parse.fileFromString("machine test; state s1 { state s11 {} state s12 {} }")
            val actual = machine.getAllConfigurations()
            val expected = listOf(listOf(State("s11", parentId = listOf(".", "s1"))),
                    listOf(State("s12", parentId = listOf(".", "s1"))))
            assertEquals(expected, actual)
        }
        run {
            val machine = Parse.fileFromString("machine test; state s1 { state s11 {} state s12 {} } state s2 {}")
            val actual = machine.getAllConfigurations()
            val expected = listOf(listOf(State("s11", parentId = listOf(".", "s1"))),
                    listOf(State("s12", parentId = listOf(".", "s1"))),
                    listOf(State("s2")))
            assertEquals(expected, actual)
        }
        run {
            val machine = Parse.fileFromString("machine test; parallel s1 { state s11 {} state s12 {} }")
            val actual = machine.getAllConfigurations()
            val expected = listOf(listOf(State("s11", parentId = listOf(".", "s1")),
                                         State("s12", parentId = listOf(".", "s1"))))
            assertEquals(expected, actual)
        }
        run {
            val machine = Parse.fileFromString("machine test; parallel s1 { state s11 { state s111 {} state s112 {} } }")
            val actual = machine.getAllConfigurations()
            val expected = listOf(listOf(State("s111", parentId = listOf(".", "s1", "s11"))),
                                  listOf(State("s112", parentId = listOf(".", "s1", "s11"))))
            assertEquals(expected, actual)
        }
        run {
            val machine = Parse.fileFromString("machine test; parallel s1 { state s11 { state s111 {} state s112 {} } state s12 {} }")
            val actual = machine.getAllConfigurations()
            val expected = listOf(
                    listOf(State("s111", parentId = listOf(".", "s1", "s11")), State("s12", parentId = listOf(".", "s1"))),
                    listOf(State("s112", parentId = listOf(".", "s1", "s11")), State("s12", parentId = listOf(".", "s1")))
            )
            assertEquals(expected, actual)
        }
    }
}