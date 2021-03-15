package xyz.colinholzman.makina

import java.io.File
import java.nio.file.Paths

fun main(args: Array<String>) {
    for (arg in args) {
        println(arg)
        val machine = Parse.file(arg)
        if (machine.hasDuplicateStates() || machine.states.any { it.hasDuplicateHandlers() })
            throw RuntimeException("duplicate state or handler")
        machine.states.forEach { it.assignSubStates(machine); it.assignParent(machine) }
        val directoryPath = Paths.get(arg).parent.toString()
        val headerPath = Paths.get(directoryPath, "${machine.id}.h").toString()
        val sourcePath = Paths.get(directoryPath, "${machine.id}.c").toString()
        File(headerPath).printWriter().use {
            CodeGenerator.generateHeader(machine, it)
        }
    }
}
