package xyz.colinholzman.makina

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import xyz.colinholzman.makina.GetState.Companion.getState
import xyz.colinholzman.makina.TestStates.Companion.s1
import xyz.colinholzman.makina.TestStates.Companion.s11
import xyz.colinholzman.makina.TestStates.Companion.s111
import xyz.colinholzman.makina.TestStates.Companion.s12
import xyz.colinholzman.makina.TestStates.Companion.s121
import xyz.colinholzman.makina.TestStates.Companion.s122
import xyz.colinholzman.makina.TestStates.Companion.s2
import xyz.colinholzman.makina.TestStates.Companion.s21

internal class TransitionTest {

    @Test
    fun getEntrySet() {
        assertEquals(listOf(s12, s122), Transition(s111, s111, s122).getEntrySet())
        assertEquals(listOf(s2, s21), Transition(s111, s111, s21).getEntrySet())
        assertEquals(listOf(s111), Transition(s111, s111, s111).getEntrySet())
        assertEquals(listOf(s1, s12, s121), Transition(s111, s111, s1).getEntrySet())
        assertEquals(listOf(s1, s12, s121), Transition(s111, s1, s1).getEntrySet())
        assertEquals(listOf(s2, s21), Transition(s111, s111, s2).getEntrySet())
    }

    @Test
    fun getExitSet() {
        assertEquals(listOf(s111, s11), Transition(s111, s111, s122).getExitSet())
        assertEquals(listOf(s111, s11, s1), Transition(s111, s111, s21).getExitSet())
        assertEquals(listOf(s111), Transition(s111, s111, s111).getExitSet())
        assertEquals(listOf(s111, s11, s1), Transition(s111, s111, s1).getExitSet())
        assertEquals(listOf(s111, s11, s1), Transition(s111, s1, s1).getExitSet())
        assertEquals(listOf(s111, s11), Transition(s111, s1, s12).getExitSet())
        assertEquals(listOf(s111, s11, s1), Transition(s111, s1, s12, Target.Kind.EXTERNAL).getExitSet())
        assertEquals(listOf(s111, s11, s1), Transition(s111, s1, s121, Target.Kind.EXTERNAL).getExitSet())
        assertEquals(listOf(s111), Transition(s111, s111, s111, Target.Kind.EXTERNAL).getExitSet())
        assertEquals(listOf(s111, s11, s1), Transition(s111, s1, s1, Target.Kind.EXTERNAL).getExitSet())
        assertEquals(listOf(s21, s2), Transition(s21, s2, s21, Target.Kind.EXTERNAL).getExitSet())
    }

    @Test
    fun getParallelExitSet() {
        run {
            val machine = Parse.fileFromString("""
                machine test;
                parallel foo {
                    state bar {}
                    state baz {}
                }
                state qux {}
            """.trimIndent())
            val foo = machine.getState(".foo")
            val bar = machine.getState(".foo.bar")
            val baz = machine.getState(".foo.baz")
            val qux = machine.getState(".qux")
            val actual = Transition(listOf(bar, baz), bar, qux).getExitSet()
            val expected = listOf(baz, bar, foo)
            assertEquals(expected, actual)
        }
    }

    @Test
    fun getParallelEntrySet() {
        run {
            val machine = Parse.fileFromString("""
                machine test;
                parallel foo {
                    state bar {}
                    state baz {}
                }
                state qux {}
            """.trimIndent())
            val foo = machine.getState(".foo")
            val bar = machine.getState(".foo.bar")
            val baz = machine.getState(".foo.baz")
            val qux = machine.getState(".qux")
            val actual = Transition(listOf(qux), qux, foo).getEntrySet()
            val expected = listOf(foo, bar, baz)
            assertEquals(expected, actual)
        }
        run {
            val machine = Parse.fileFromString("""
                machine test;
                parallel foo {
                    state bar {}
                    state baz {}
                }
                state qux {}
            """.trimIndent())
            val foo = machine.getState(".foo")
            val bar = machine.getState(".foo.bar")
            val baz = machine.getState(".foo.baz")
            val qux = machine.getState(".qux")
            val actual = Transition(listOf(qux), qux, bar).getEntrySet()
            val expected = listOf(foo, bar, baz)
            assertEquals(expected, actual)
        }
    }

    @Test
    fun getDomain() {
        assertEquals(null, Transition(s111, s1, s2).getDomain())
        assertEquals(null, Transition(s111, s11, s21).getDomain())
        assertEquals(s1, Transition(s111, s11, s12).getDomain())
        assertEquals(s1, Transition(s111, s1, s11).getDomain())
        assertEquals(null, Transition(s111, s1, s11, Target.Kind.EXTERNAL).getDomain())
        assertEquals(null, Transition(s111, s11, s1).getDomain())
    }
}