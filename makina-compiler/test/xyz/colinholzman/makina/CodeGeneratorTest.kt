package xyz.colinholzman.makina

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File
import java.nio.file.Paths
import java.util.concurrent.TimeUnit

internal class CodeGeneratorTest {

    private val testSource =
        """
            machine test;

            state s1 {
                entry s1_entry;
                on e1 -> .s2;
                state s2 {
                    entry s1_s2_entry;
                    on e1 (s1_s2_e1_guard) s1_s2_e1_action;
                    on e2 -> s2.s3;
                    exit s1_s2_exit;
                }
                exit s1_exit;
            }
            state s2 {
                entry s2_entry;
                state s3 {
                    entry s2_s3_entry;
                    on e2 -> .s1;
                    exit s2_s3_exit;
                }
                initial state s1 {
                    entry s2_s1_entry;
                    on e1 s2_s1_e1_action -> .s1;
                    exit s2_s1_exit;
                }
                exit s2_exit;
            }
        """.trimIndent()

    private val testDriver =
        """
            #include <stdio.h>
            #include "test.h"

            FILE *output;

            int s1_s2_entry(struct test *self, struct test_event *event) {
                fprintf(output, "s1_s2_entry\n");
                return 0;
            }

            int s1_s2_e1_guard_value = 0;

            int s1_s2_e1_guard(struct test *self, struct test_event *event) {
                fprintf(output, "s1_s2_e1_guard\n");
                return s1_s2_e1_guard_value;
            }

            int s1_s2_e1_action(struct test *self, struct test_event *event) {
                fprintf(output, "s1_s2_e1_action\n");
                return 0;
            }

            int s1_s2_exit(struct test *self, struct test_event *event) {
                fprintf(output, "s1_s2_exit\n");
                return 0;
            }

            int s1_entry(struct test *self, struct test_event *event) {
                fprintf(output, "s1_entry\n");
                return 0;
            }

            int s1_exit(struct test *self, struct test_event *event) {
                fprintf(output, "s1_exit\n");
                return 0;
            }

            int s2_s3_entry(struct test *self, struct test_event *event) {
                fprintf(output, "s2_s3_entry\n");
                return 0;
            }

            int s2_s3_exit(struct test *self, struct test_event *event) {
                fprintf(output, "s2_s3_exit\n");
                return 0;
            }

            int s2_s1_entry(struct test *self, struct test_event *event) {
                fprintf(output, "s2_s1_entry\n");
                return 0;
            }

            int s2_s1_e1_action(struct test *self, struct test_event *event) {
                fprintf(output, "s2_s1_e1_action\n");
                return 0;
            }

            int s2_s1_exit(struct test *self, struct test_event *event) {
                fprintf(output, "s2_s1_exit\n");
                return 0;
            }

            int s2_entry(struct test *self, struct test_event *event) {
                fprintf(output, "s2_entry\n");
                return 0;
            }

            int s2_exit(struct test *self, struct test_event *event) {
                fprintf(output, "s2_exit\n");
                return 0;
            }

            int main (void) {
                output = fopen("test_output.txt", "w+");
                struct test instance;
                test_init(&instance);                                                //s1_entry, s1_s2_entry
                test_process_event(&instance, &(struct test_event) {test_event_e1}); //s1_s2_e1_guard, s1_s2_exit, s1_exit, s2_entry, s2_s1_entry
                test_process_event(&instance, &(struct test_event) {test_event_e2}); //...
                test_process_event(&instance, &(struct test_event) {test_event_e1}); //s2_s1_exit, s2_exit, s2_s1_e1_action, s1_entry, s1_s2_entry
                s1_s2_e1_guard_value = 1;
                test_process_event(&instance, &(struct test_event) {test_event_e1}); //s1_s2_e1_guard, s1_s2_e1_action
                test_process_event(&instance, &(struct test_event) {test_event_e2}); //s1_s2_exit, s1_exit, s2_entry, s2_s3_entry
                test_process_event(&instance, &(struct test_event) {test_event_e2}); //s2_s3_exit, s2_exit, s1_entry, s1_s2_entry
                fclose(output);
                return 0;
            }
        """.trimIndent()

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
        val testSourceFile = File.createTempFile("makina-test", ".mkna")
        testSourceFile.writeText(testSource)

        val testDir = Paths.get(testSourceFile.path).parent

        val testDriverFile = File.createTempFile("makina-test", ".c")
        testDriverFile.writeText(testDriver)

        //invoke Makina
        main(arrayOf(testSourceFile.absolutePath))


        val makinaOutputFilePath = testDir.resolve("test.c").toString()
        val compiledExecutablePath = testDir.resolve("test.exe").toString()

        val compileProcess = ProcessBuilder()
                .directory(testDir.toFile())
                .command("gcc", makinaOutputFilePath, testDriverFile.absolutePath, "-o", compiledExecutablePath, "-std=c99").start()
        compileProcess.waitFor(10, TimeUnit.SECONDS)

        val runProcess = ProcessBuilder().directory(testDir.toFile()).command(compiledExecutablePath).start()
        runProcess.waitFor(10, TimeUnit.SECONDS)

        testDir.resolve("test_output.txt").toFile().reader().use {
            assertEquals(testOutput, it.readLines())
        }
    }
}