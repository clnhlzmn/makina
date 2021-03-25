package xyz.colinholzman.makina

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File
import java.nio.file.Paths
import java.util.concurrent.TimeUnit

internal class CodeGeneratorTest {

    private val testOutput = listOf("s1_entry",
                                    "s1_s2_entry",
                                    "s1_s2_e1_guard",
                                    "s1_s2_exit",
                                    "s1_exit",
                                    "s2_entry",
                                    "s2_s1_entry",
                                    "s2_s1_exit",
                                    "s2_exit",
                                    "s2_s1_e1_action",
                                    "s1_entry",
                                    "s1_s2_entry",
                                    "s1_s2_e1_guard",
                                    "s1_s2_e1_action",
                                    "s1_s2_exit",
                                    "s1_exit",
                                    "s2_entry",
                                    "s2_s3_entry",
                                    "s2_s3_exit",
                                    "s2_exit",
                                    "s1_entry",
                                    "s1_s2_entry")

    @Test
    fun testCodeGenerator() {
        val makeClean = ProcessBuilder()
                .directory(File("./../test/code_generator_test"))
                .command("make", "clean").start()
        makeClean.waitFor(10, TimeUnit.SECONDS)

        val make = ProcessBuilder()
                .directory(File("./../test/code_generator_test"))
                .command("make").start()
        make.waitFor(10, TimeUnit.SECONDS)

        File("./../test/code_generator_test/out/test_output.txt").reader().use {
            assertEquals(testOutput, it.readLines())
        }
    }
}