package xyz.colinholzman.makina

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import xyz.colinholzman.makina.GetState.Companion.getState
import xyz.colinholzman.makina.TestStates.Companion.s1
import xyz.colinholzman.makina.TestStates.Companion.s11
import xyz.colinholzman.makina.TestStates.Companion.s111
import xyz.colinholzman.makina.TestStates.Companion.s2

internal class StateConfigurationTest {

    @Test
    fun filterHandlers() {
        var handlers = arrayListOf(
                Pair(s111, Handler.Event("foo")),
                Pair(s11, Handler.Event("foo")),
                Pair(s1, Handler.Event("foo"))
        )
        var expected = mapOf(Pair("foo", listOf(Pair(s111, Handler.Event("foo")))))
        assertEquals(expected, handlers.groupByIdAndRemoveRedundantHandlers())


        handlers = arrayListOf(
                Pair(s111, Handler.Event("foo")),
                Pair(s11, Handler.Event("foo")),
                Pair(s1, Handler.Event("foo", guard = "bar"))
        )
        expected = mapOf(Pair("foo", listOf(Pair(s111, Handler.Event("foo")))))
        assertEquals(expected, handlers.groupByIdAndRemoveRedundantHandlers())


        handlers = arrayListOf(
                Pair(s111, Handler.Event("foo")),
                Pair(s11, Handler.Event("bar")),
                Pair(s1, Handler.Event("foo"))
        )
        expected = mapOf(Pair("foo", listOf(Pair(s111, Handler.Event("foo")))),
                         Pair("bar", listOf(Pair(s11, Handler.Event("bar")))))
        assertEquals(expected, handlers.groupByIdAndRemoveRedundantHandlers())


        handlers = arrayListOf(
                Pair(s111, Handler.Event("foo", guard = "bar")),
                Pair(s11, Handler.Event("foo", guard = "baz")),
                Pair(s1, Handler.Event("foo"))
        )
        expected = mapOf(Pair("foo", listOf(Pair(s111, Handler.Event("foo", guard = "bar")),
                                            Pair(s11, Handler.Event("foo", guard = "baz")),
                                            Pair(s1, Handler.Event("foo")))))
        assertEquals(expected, handlers.groupByIdAndRemoveRedundantHandlers())
    }

    @Test
    fun getEventHandlers() {
        run {
            val machine = Parse.fileFromString("""
                machine test;
                state foo {
                    on e;
                    state bar {
                        on e (guard);
                    }
                }
            """.trimIndent())
            val foo = machine.getState(".foo")
            val bar = machine.getState(".foo.bar")
            val actual = listOf(bar).getEventHandlers()
            val expected = mapOf(Pair("e", listOf(Pair(bar, Parse.handler("on e (guard);")),
                                                  Pair(foo, Parse.handler("on e;")))))
            assertEquals(expected, actual)
        }
        run {
            val machine = Parse.fileFromString("""
                machine test;
                parallel foo {
                    on e;
                    state bar {
                        on e (bar_guard);
                    }
                    state baz {
                        on e (baz_guard);
                    }
                }
            """.trimIndent())
            val foo = machine.getState(".foo")
            val bar = machine.getState(".foo.bar")
            val baz = machine.getState(".foo.baz")
            val actual = listOf(bar, baz).getEventHandlers()
            val expected = mapOf(Pair("e", listOf(Pair(bar, Parse.handler("on e (bar_guard);")),
                                                  Pair(baz, Parse.handler("on e (baz_guard);")),
                                                  Pair(foo, Parse.handler("on e;")))))
            assertEquals(expected, actual)
        }
    }

    @Test
    fun getEntryHandlers() {
        run {
            val machine = Parse.fileFromString("""
                machine test;
                parallel foo {
                    entry foo;
                    state bar {
                        entry bar;
                    }
                    state baz {
                        entry baz;
                    }
                }
            """.trimIndent())
            val bar = machine.getState(".foo.bar")
            val baz = machine.getState(".foo.baz")
            val actual = listOf(bar, baz).getEntryHandlers()
            val expected = listOf(Handler.Entry("foo"), Handler.Entry("bar"), Handler.Entry("baz"))
            assertEquals(expected, actual)
        }
        run {
            val machine = Parse.fileFromString("""
                machine test;
                parallel foo {
                    entry foo;
                    state bar {
                        entry foo;
                    }
                    state baz {
                        entry foo;
                    }
                }
            """.trimIndent())
            val bar = machine.getState(".foo.bar")
            val baz = machine.getState(".foo.baz")
            val actual = listOf(bar, baz).getEntryHandlers()
            val expected = listOf(Handler.Entry("foo"), Handler.Entry("foo"), Handler.Entry("foo"))
            assertEquals(expected, actual)
        }
    }

    @Test
    fun getParallelEventHandlers() {
        val machine = Parse.fileFromString("""
            machine test;
            parallel s1 {
                state s11 {
                    state s111 {
                        on e -> s112;
                    }
                    state s112 {}
                }
                state s12 {
                    state s121 {
                        on e -> s122;
                    }
                    state s122 {}
                }
            }
        """.trimIndent())
        val s111 = machine.getState(".s1.s11.s111")
        val s112 = machine.getState(".s1.s11.s112")
        val s121 = machine.getState(".s1.s12.s121")
        val s122 = machine.getState(".s1.s12.s122")
        val initialConfig = listOf(s111, s121)
        val targetConfig = listOf(s112, s122)
        val actual = initialConfig.getEventHandlers()["e"]
        val expected = listOf(Pair(s111, Handler.Event("e", target = Target(listOf("s112")))), Pair(s121, Handler.Event("e", target = Target(listOf("s112")))))
        assertEquals(expected, actual)
    }
}