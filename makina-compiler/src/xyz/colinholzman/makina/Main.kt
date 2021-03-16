package xyz.colinholzman.makina

import java.io.File
import java.nio.file.Paths

fun main(args: Array<String>) {
    for (arg in args) {
        println(arg)
        val machine = Parse.file(arg)
        val directoryPath = Paths.get(arg).parent.toString()
        val headerPath = Paths.get(directoryPath, "${machine.id}.h").toString()
        val sourcePath = Paths.get(directoryPath, "${machine.id}.c").toString()
        val generator = CodeGenerator(machine)
        File(headerPath).printWriter().use {
            generator.generateHeader(it)
        }
        File(sourcePath).printWriter().use {
            generator.generateSource(it)
        }
    }
}
