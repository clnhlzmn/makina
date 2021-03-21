package xyz.colinholzman.makina

import org.junit.jupiter.api.Test
import java.io.File
import java.nio.file.Paths

class MainTest {

    @Test
    fun main() {
        val name = "foo"
        val sourceFile = File.createTempFile("makina", ".mkna")
        sourceFile.writeText("machine $name; state bar {}")

        val header = File(Paths.get(sourceFile.parent, "$name.h").toUri())
        val implementation = File(Paths.get(sourceFile.parent, "$name.c").toUri())

        if (header.exists()) header.deleteRecursively()
        if (implementation.exists()) implementation.deleteRecursively()

        main(arrayOf(sourceFile.absolutePath))
        assert(header.exists())
        assert(implementation.exists())
    }

    @Test
    fun outputDirectory() {
        val name = "foo"
        val sourceFile = File.createTempFile("makina", ".mkna")
        sourceFile.writeText("machine $name; state bar {}")

        val outputDirectoryName = "test"
        val outputDirPath = Paths.get(sourceFile.parent, outputDirectoryName).toString()

        val header = File(Paths.get(outputDirPath, "$name.h").toUri())
        val implementation = File(Paths.get(outputDirPath, "$name.c").toUri())

        if (header.exists()) header.deleteRecursively()
        if (implementation.exists()) implementation.deleteRecursively()

        val outputDir = File(outputDirPath)
        if (outputDir.exists()) outputDir.deleteRecursively()

        main(arrayOf(sourceFile.absolutePath, "-o", outputDirPath))

        assert(header.exists())
        assert(implementation.exists())
    }

    @Test
    fun dataTypes() {
        val name = "foo"
        val sourceFile = File.createTempFile("makina", ".mkna")
        sourceFile.writeText("machine $name; state bar {}")

        val header = File(Paths.get(sourceFile.parent, "$name.h").toUri())
        if (header.exists()) header.deleteRecursively()

        val machineDataType = "struct machine_data"
        val eventDataType = "struct event_data"
        main(arrayOf(sourceFile.absolutePath, "-m", machineDataType, "-e", eventDataType))

        val headerContent = header.readBytes().toString(Charsets.UTF_8)
        assert(headerContent.contains("$machineDataType ctx;"))
        assert(headerContent.contains("$eventDataType ctx;"))
    }

    @Test
    fun includes() {
        val name = "foo"
        val sourceFile = File.createTempFile("makina", ".mkna")
        sourceFile.writeText("machine $name; state bar {}")

        val header = File(Paths.get(sourceFile.parent, "$name.h").toUri())
        if (header.exists()) header.deleteRecursively()

        val include1 = "../some_header.h"
        val include2 = "another_header.h"
        main(arrayOf(sourceFile.absolutePath, "-i", include1, "-i", include2))

        val headerContent = header.readBytes().toString(Charsets.UTF_8)
        assert(headerContent.contains("#include \"$include1\""))
        assert(headerContent.contains("#include \"$include2\""))
    }

}