package xyz.colinholzman.makina

fun main(args: Array<String>) {
    for (arg in args) {
        println(arg)
        val machine = Parse.file(arg)
        if (machine.hasDuplicateStates() || machine.states.any { it.hasDuplicateHandlers() })
            throw RuntimeException("duplicate state or handler")
        machine.states.forEach { it.assignSubStates(machine); it.assignParent(machine) }
        println(machine)
    }
}
