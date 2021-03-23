package xyz.colinholzman.makina

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import xyz.colinholzman.makina.TestStates.Companion.s1
import xyz.colinholzman.makina.TestStates.Companion.s11
import xyz.colinholzman.makina.TestStates.Companion.s111
import xyz.colinholzman.makina.TestStates.Companion.s12
import xyz.colinholzman.makina.TestStates.Companion.s122
import xyz.colinholzman.makina.TestStates.Companion.s2
import xyz.colinholzman.makina.TestStates.Companion.s21

internal class TransitionTest {

    @Test
    fun getEntrySet() {
        var transition = Transition(s111, s122)
        assertEquals(listOf(s12, s122), transition.getEntrySet())
        transition = Transition(s111, s21)
        assertEquals(listOf(s2, s21), transition.getEntrySet())
    }

    @Test
    fun getExitSet() {
        var transition = Transition(s111, s122)
        assertEquals(listOf(s111, s11), transition.getExitSet())
        transition = Transition(s111, s21)
        assertEquals(listOf(s111, s11, s1), transition.getExitSet())
    }
}