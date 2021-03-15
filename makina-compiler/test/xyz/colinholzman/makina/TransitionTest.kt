package xyz.colinholzman.makina

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TransitionTest {

    @Test
    fun isValid() {
        assertFalse(Transition(TestStates.s111, TestStates.s2).isValid())
        assertFalse(Transition(TestStates.s11, TestStates.s21).isValid())
        assertTrue(Transition(TestStates.s111, TestStates.s21).isValid())
    }

    @Test
    fun getEntrySet() {
        var transition = Transition(TestStates.s111, TestStates.s122)
        assertEquals(listOf(TestStates.s12, TestStates.s122), transition.getEntrySet())
        transition = Transition(TestStates.s111, TestStates.s21)
        assertEquals(listOf(TestStates.s2, TestStates.s21), transition.getEntrySet())
    }

    @Test
    fun getExitSet() {
        var transition = Transition(TestStates.s111, TestStates.s122)
        assertEquals(listOf(TestStates.s111, TestStates.s11), transition.getExitSet())
        transition = Transition(TestStates.s111, TestStates.s21)
        assertEquals(listOf(TestStates.s111, TestStates.s11, TestStates.s1), transition.getExitSet())
    }
}