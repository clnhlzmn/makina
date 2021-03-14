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
}