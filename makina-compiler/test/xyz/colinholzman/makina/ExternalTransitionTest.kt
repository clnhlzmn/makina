package xyz.colinholzman.makina

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File
import java.util.concurrent.TimeUnit
import kotlin.test.assertEquals

class ExternalTransitionTest {

    val output = listOf(
        "s1_entry",
        "s1_s2_entry",
        "s1_s2_e1_guard",
        "s1_s2_exit",
        "s1_exit",
        "s1_entry",
        "s1_s2_entry",
        "s1_s2_e1_guard",
        "s1_s2_exit",
        "s1_exit",
        "s1_entry",
        "s1_s2_entry",
        "s1_s2_e2_guard",
        "s1_s2_exit",
        "s1_s2_entry",
        "s1_s2_e2_guard",
        "s1_s2_exit",
        "s1_s2_entry"
    )
    @Test
    fun externalTransition() {
        val makeClean = ProcessBuilder()
                .directory(File("./../test/external_transition"))
                .command("make", "clean").start()
        makeClean.waitFor(10, TimeUnit.SECONDS)
        assertEquals(false, makeClean.isAlive)
        assertEquals(0, makeClean.exitValue())

        val make = ProcessBuilder()
                .directory(File("./../test/external_transition"))
                .command("make").start()
        make.waitFor(10, TimeUnit.SECONDS)
        assertEquals(false, make.isAlive)
        assertEquals(0, make.exitValue())
    }
}