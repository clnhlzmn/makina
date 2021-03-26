package xyz.colinholzman.makina

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File
import java.util.concurrent.TimeUnit
import kotlin.test.assertEquals

class DefaultTransitionTest {
    @Test
    fun defaultTransition() {
        externalMakefileTest("./../test/default_transition")
    }
}