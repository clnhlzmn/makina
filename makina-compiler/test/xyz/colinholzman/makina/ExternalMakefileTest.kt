package xyz.colinholzman.makina

import java.io.File
import java.util.concurrent.TimeUnit
import kotlin.test.assertEquals

fun externalMakefileTest(path: String) {
    val makeClean = ProcessBuilder()
            .directory(File(path))
            .command("make", "clean").start()
    makeClean.waitFor(10, TimeUnit.SECONDS)
    assertEquals(false, makeClean.isAlive)
    assertEquals(0, makeClean.exitValue())

    val make = ProcessBuilder()
            .directory(File(path))
            .command("make").start()
    make.waitFor(10, TimeUnit.SECONDS)
    assertEquals(false, make.isAlive)
    assertEquals(0, make.exitValue())
}
