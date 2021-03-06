package xyz.colinholzman.makina

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import xyz.colinholzman.makina.State.Companion.getLCCA
import xyz.colinholzman.makina.TestStates.Companion.machine
import xyz.colinholzman.makina.TestStates.Companion.s1
import xyz.colinholzman.makina.TestStates.Companion.s2
import xyz.colinholzman.makina.TestStates.Companion.s3
import xyz.colinholzman.makina.TestStates.Companion.s21
import xyz.colinholzman.makina.TestStates.Companion.s11
import xyz.colinholzman.makina.TestStates.Companion.s12
import xyz.colinholzman.makina.TestStates.Companion.s111
import xyz.colinholzman.makina.TestStates.Companion.s112
import xyz.colinholzman.makina.TestStates.Companion.s121

internal class StateTest {

    @Test
    fun getSiblings() {
        assertEquals(setOf(s1, s3), s2.getSiblings(machine).toSet())
        assertEquals(setOf(s12), s11.getSiblings(machine).toSet())
    }

    @Test
    fun fullyQualifiedName() {
        assertEquals("s1_s11_s111", s111.getFullyQualifiedIdString())
        assertEquals("s1_s11", s11.getFullyQualifiedIdString())
        assertEquals("s2_s21", s21.getFullyQualifiedIdString())
        assertEquals("s2", s2.getFullyQualifiedIdString())
    }

    @Test
    fun testHasDuplicateEntry() {
        assertThrows<RuntimeException> {
            Parse.state("state foo { entry foo; entry bar; }")
        }
    }
    @Test
    fun testHasDuplicateExit() {
        assertThrows<RuntimeException> {
            Parse.state("state foo { exit foo; exit bar; }")
        }
    }
    @Test
    fun testHasDuplicateEvent() {
        assertThrows<RuntimeException> {
            Parse.state("state foo { on foo -> Bar; on foo do_it; }")
        }
        assertDoesNotThrow {
            Parse.state("state foo { on foo -> Bar; on foo (bar); }")
        }
    }

    @Test
    fun testNoDuplicateHandlers() {
        assertDoesNotThrow {
            Parse.state("state foo { entry foo; on bar; on qux; exit baz; }")
        }
    }

    @Test
    fun hasDuplicateSubstates() {
        val state = State("foo")
        val child = State("child", initial = true)
        val child2 = State("child2", initial = true)
        assertThrows<RuntimeException> {
            state.subStates = listOf(child, child2)
        }
    }

    @Test
    fun testAssignSubStates() {
        val machine = Parse.fileFromString("machine foo; state bar {} state .bar.baz {}")
        val bar = machine.states.find { it.id == "bar" }!!
        val baz = machine.states.find { it.id == "baz" }!!
        assertEquals(listOf(baz), bar.subStates)
        assertEquals(emptyList<State>(), baz.subStates)

        val machine2 = Parse.fileFromString("machine foo; state bar { state bar {} } state .bar.foo {} ")
        val bar2 = machine2.states.find { it.id == "bar" && it.parent == null }!!
        val bar_bar = machine2.states.find { it.id == "bar" && it.parent != null }!!
        val bar_foo = machine2.states.find { it.id == "foo" && it.parent != null }!!
        assertEquals(setOf(bar_bar, bar_foo), bar2.subStates.toSet())
        assertEquals(emptySet<State>(), bar_bar.subStates.toSet())
        assertEquals(emptySet<State>(), bar_foo.subStates.toSet())
    }

    @Test
    fun finalMustBeAtomic() {
        assertThrows<RuntimeException> {
            Parse.fileFromString("machine foo; state top { final state child { state err { } } }")
        }
    }

    @Test
    fun testAssignParent() {
        val machine = Parse.fileFromString("machine foo; state bar {} state .bar.baz {}")
        val bar = machine.states.find { it.id == "bar" }!!
        val baz = machine.states.find { it.id == "baz" }!!
        assertEquals(null, bar.parent)
        assertEquals(bar, baz.parent)
    }

    @Test
    fun testAssignParentNotFound() {
        assertThrows<RuntimeException> {
            Parse.fileFromString("machine foo; state bar {} state .oops.baz {}")
        }
    }

    @Test
    fun testIsAtomic() {
        val machine = Parse.fileFromString("machine foo; state bar {} state .bar.baz {}")
        val bar = machine.states.find { it.id == "bar" }!!
        val baz = machine.states.find { it.id == "baz" }!!
        assertFalse(bar.isAtomic())
        assert(baz.isAtomic())
    }

    @Test
    fun isAtomicStateNested() {
        val machine = Parse.fileFromString("machine foo; state bar { state baz {} } state .bar.qux {}")
        val baz = machine.states.find { it.id == "baz" }!!
        val qux = machine.states.find { it.id == "qux" }!!
        assert(baz.isAtomic())
        assert(qux.isAtomic())
    }

    @Test
    fun testGetDepth() {
        assertEquals(2, s111.getDepth())
        assertEquals(0, s1.getDepth())
    }

    @Test
    fun testIsDescendantOf() {
        val foo = Parse.state("state foo {}").first()
        val bar = Parse.state("state bar {}").first()
        bar.parent = foo
        assert(bar.isDescendantOf(foo))
        assertFalse(foo.isDescendantOf(bar))
        assertTrue(foo.isDescendantOf(null))
    }

    @Test
    fun testGetProperAncestors() {
        assertEquals(listOf(s11, s1), s111.getProperAncestors(null))
        assertEquals(listOf(s2), s21.getProperAncestors(null))
        assertEquals(emptyList<State>(), s1.getProperAncestors(null))
        assertEquals(emptyList<State>(), s1.getProperAncestors(s111))
        assertEquals(listOf(s11), s111.getProperAncestors(s1))
    }

    @Test
    fun testGetLCCA() {
        assertEquals(s1, listOf(s111, s121).getLCCA())
        assertEquals(s11, listOf(s111, s112).getLCCA())
        assertEquals(null, listOf(s12, s21).getLCCA())
    }

    @Test
    fun getStateConfiguration() {
        assertEquals(StateConfiguration(setOf(s2, s21)), s21.getStateConfiguration())
        assertEquals(StateConfiguration(setOf(s2, s21)), s2.getStateConfiguration())
        assertEquals(StateConfiguration(setOf(s1, s12, s121)), s1.getStateConfiguration())
        assertEquals(StateConfiguration(setOf(s1, s11, s111)), s11.getStateConfiguration())
        assertEquals(StateConfiguration(setOf(s1, s11, s111)), s111.getStateConfiguration())
    }

    @Test
    fun eventHandlerInFinalState() {
        assertThrows<RuntimeException> {
            Parse.state("final state foo { on foo do_it; }")
        }
    }

    @Test
    fun entryExitHandlerInFinalState() {
        assertDoesNotThrow {
            Parse.state("final state foo { entry do_it; exit do_that; }")
        }
    }

}