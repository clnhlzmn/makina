package xyz.colinholzman.makina

import java.io.PrintWriter

class CodeGenerator(val machine: Machine) {

    private val machineStructName = "struct ${machine.id}"
    private val machineEventName = "struct ${machine.id}_event"
    private val machineEventIdName = "enum ${machine.id}_event_id"

    fun generateHeader(output: PrintWriter) {
        output.apply {
            println("/*This file was generated by Makina. Do not modify.*/")
            println("#ifndef ${machine.id.toUpperCase()}_H")
            println("#define ${machine.id.toUpperCase()}_H")
            println()
            println("$machineStructName;")
            println("$machineEventName;")
            println()
            machine.getAllActionAndGuardNames().forEach {
                println("int $it($machineStructName *, $machineEventName *);")
            }
            println()
            println("$machineEventIdName {")
            machine.getAllEventNames().forEach {
                println("\t${machine.id}_event_$it,")
            }
            println("};")
            println()
            println("$machineEventName {")
            println("\t$machineEventIdName id;")
            println("\tvoid *ctx;")
            println("};")
            println()
            println("$machineStructName {")
            println("\tint (*state)($machineStructName *, $machineEventName *);")
            println("\tvoid *ctx;")
            println("};")
            println()
            println("int ${machine.id}_init($machineStructName *);")
            println()
            println("int ${machine.id}_process_event($machineStructName *, $machineEventName *);")
            println()
            println("#endif /*${machine.id.toUpperCase()}_H*/")
        }
    }
    fun generateSource(output: PrintWriter) {
        output.apply {
            println("/*This file was generated by Makina. Do not modify.*/")
            println("#include \"${machine.id}.h\"")
            println()
            for (state in machine.states.filter { it.isLeafState() }) {
                println("static int ${machine.id}_${state.getFullyQualifiedName()}($machineStructName *, $machineEventName *);")
            }
            println()
            for (state in machine.states.filter { it.isLeafState() }) {
                println("static int ${machine.id}_${state.getFullyQualifiedName()}($machineStructName *self, $machineEventName *event) {")
                println("\tif (!self || !event) return -1;")
                val config = state.getStateConfiguration()
                val handlers = config.getHandlers()
                for (handler in handlers) {
                    val guard = if (handler.guard != null) "${handler.guard}(self, event)" else "1"
                    println("\tif (event->id == ${machine.id}_event_${handler.id} && $guard) {")
                    if (handler.target != null) {
                        var target = handler.getTargetState(machine)
                        if (!target.isLeafState())
                            target = target.getStateConfiguration().getLeafState()
                        val transition = Transition(state, target)
                        val exitSet = transition.getExitSet()
                        for (stateToExit in exitSet) {
                            for (exit in stateToExit.handlers.filterIsInstance<Handler.Exit>()) {
                                println("\t\t${exit.action}(self, event);")
                            }
                        }
                        if (handler.action != null) {
                            println("\t\t${handler.action}(self, event);")
                        }
                        println("\t\tself->state = ${machine.id}_${target.getFullyQualifiedName()};")
                        val entrySet = transition.getEntrySet()
                        for (stateToEnter in entrySet) {
                            for (entry in stateToEnter.handlers.filterIsInstance<Handler.Entry>()) {
                                println("\t\t${entry.action}(self, event);")
                            }
                        }
                    } else if (handler.action != null) {
                        println("\t\t${handler.action}(self, event);")
                    }
                    println("\t\treturn 0;")
                    println("\t}")
                }
                println("\treturn 0;")
                println("}")
                println()
            }
            println("int ${machine.id}_init($machineStructName *self) {")
            println("\tif (!self) return -1;")
            val initialConfig = machine.getInitialStateConfiguration()
            val initialLeafState = initialConfig.getLeafState()
            println("\tself->state = ${machine.id}_${initialLeafState.getFullyQualifiedName()};")
            val entryHandlers = initialConfig.getEntryHandlers()
            for (handler in entryHandlers) {
                println("\t${handler.action}(self, NULL);")
            }
            println("\treturn 0;")
            println("}")
            println()
            println("int ${machine.id}_process_event($machineStructName *self, $machineEventName *event) {")
            println("\tif (!self || !event) return -1;")
            println("\tif (!self->state) return -1;")
            println("\tself->state(self, event);")
            println("\treturn 0;")
            println("}")
        }
    }
}