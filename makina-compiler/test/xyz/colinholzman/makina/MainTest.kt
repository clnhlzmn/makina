package xyz.colinholzman.makina

import org.junit.jupiter.api.Test
import java.io.File
import java.nio.file.Paths

class MainTest {

    @Test
    fun main() {
        val sourceFile = File.createTempFile("makina", ".mkna")
        val name = "foo"
        sourceFile.writeText("machine $name; state bar {}")
        main(arrayOf(sourceFile.absolutePath))
        val header = File(Paths.get(sourceFile.parent, "$name.h").toUri())
        val implementation = File(Paths.get(sourceFile.parent, "$name.c").toUri())
        assert(header.exists())
        assert(implementation.exists())
    }

    @Test
    fun outputDirectory() {
        val sourceFile = File.createTempFile("makina", ".mkna")
        val name = "foo"
        sourceFile.writeText("machine $name; state bar {}")
        val outputDirectoryName = "test"
        val outputDir = Paths.get(sourceFile.parent, outputDirectoryName).toString()
        val outputDirFile = File(outputDir)
        if (outputDirFile.exists()) {
            outputDirFile.deleteRecursively()
        }
        main(arrayOf(sourceFile.absolutePath, "-o", outputDir))
        val header = File(Paths.get(outputDir, "$name.h").toUri())
        val implementation = File(Paths.get(outputDir, "$name.c").toUri())
        assert(header.exists())
        assert(implementation.exists())
    }

}