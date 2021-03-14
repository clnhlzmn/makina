package xyz.colinholzman.makina

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MachineTest {
    @Test
    fun testHasDuplicateStates() {
        val machine = Parse.fileFromString("machine foo; state foo {} state foo {}")
        assert(machine.hasDuplicateStates())
    }

    @Test
    fun testNoDuplicateStates() {
        val machine = Parse.fileFromString("machine foo; state foo {} state bar {}")
        assert(!machine.hasDuplicateStates())
    }

    @Test
    fun testHasDuplicateInitialStates() {
        val machine = Parse.fileFromString("machine foo; initial state foo {} initial state bar {}")
        assert(machine.hasDuplicateInitialStates())
    }

    @Test
    fun testHasNoDuplicateInitialStates() {
        val machine = Parse.fileFromString("machine foo; initial state foo {} state bar {}")
        assert(!machine.hasDuplicateInitialStates())
    }
}