package xyz.colinholzman.makina

import picocli.CommandLine
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.OutputStreamWriter
import java.io.PrintWriter
import java.nio.file.Paths

fun main(args: Array<String>) {
    val options = CliOptions()
    CommandLine(options).parseArgs(*args)
    for (file in options.files) {
        try {
            val machine = Parse.file(file)

            val outputDirectoryPath = options.outputDir ?: Paths.get(file).parent.toString()
            val outputDirectory = File(outputDirectoryPath)
            if (!outputDirectory.exists())
                outputDirectory.mkdirs()

            val headerPath = Paths.get(outputDirectoryPath, "${machine.id}.h").toString()
            val sourcePath = Paths.get(outputDirectoryPath, "${machine.id}.c").toString()

            val generator = CodeGenerator(machine)

            val headerStream = ByteArrayOutputStream()
            val implementationStream = ByteArrayOutputStream()

            val headerWriter = PrintWriter(headerStream)
            val impementationWriter = PrintWriter(implementationStream)

            generator.generateHeader(headerWriter)
            generator.generateSource(impementationWriter)

            headerWriter.flush()
            impementationWriter.flush()

            File(headerPath).printWriter().use {
                it.write(headerStream.toString())
            }
            File(sourcePath).printWriter().use {
                it.write(implementationStream.toString())
            }
        } catch (e: RuntimeException) {
            println(e.localizedMessage)
        }
    }
}
