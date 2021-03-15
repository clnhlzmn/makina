package xyz.colinholzman.makina

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TransitionTest {

    @Test
    fun getEntrySet() {
        val transition = Transition(TestStates.s111, TestStates.s122)
        assertEquals(listOf(TestStates.s12, TestStates.s122), transition.getEntrySet())
    }

    @Test
    fun getExitSet() {
        val transition = Transition(TestStates.s111, TestStates.s122)
        assertEquals(listOf(TestStates.s111, TestStates.s11), transition.getExitSet())
    }
}