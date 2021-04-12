package xyz.colinholzman.makina

import org.junit.jupiter.api.Test

class ParallelEventTest {
    @Test
    fun parallelEvent() {
        externalMakefileTest("../test/parallel_event")
    }
}