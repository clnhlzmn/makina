package xyz.colinholzman.makina

import java.io.PrintWriter

class CodeGenerator(val machine: Machine,
                    val machineDataType: String = "void *",
                    val eventDataType: String = "void *",
                    val includes: List<String> = emptyList()) {

    private val machineStructName = "struct ${machine.id}"
    private val machineEventName = "struct ${machine.id}_event"
    private val machineEventIdName = "enum ${machine.id}_event_id"

    fun generateHeader(output: PrintWriter) {
        output.apply {
            println("/*This file was generated by Makina. Do not modify.*/")
            println("#ifndef ${machine.id.toUpperCase()}_H")
            println("#define ${machine.id.toUpperCase()}_H")
            for (include in includes) {
                println()
                println("#include \"$include\"")
            }
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
            println("\t${eventDataType} ctx;")
            println("\t$machineEventIdName id;")
            println("};")
            println()
            println("$machineStructName {")
            println("\tint (*state)($machineStructName *, $machineEventName *);")
            println("\t${machineDataType} ctx;")
            println("};")
            println()
            println("int ${machine.id}_init($machineStructName *);")
            println()
            println("int ${machine.id}_process_event($machineStructName *, $machineEventName *);")
            println()
            println("#endif /*${machine.id.toUpperCase()}_H*/")
        }
    }

    private fun generateExitActions(handler: Handler.Event, sourceState: State, activeConfiguration: List<State>, output: PrintWriter) {
        if (handler.target != null) output.apply {
            val target = handler.getTargetState(sourceState, machine)
            val transition = Transition(activeConfiguration, sourceState, target, handler.target.kind)
            val exitSet = transition.getExitSet()
            for (stateToExit in exitSet) {
                for (exit in stateToExit.handlers.filterIsInstance<Handler.Exit>()) {
                    println("\t\t\t${exit.action}(self, event);")
                }
            }
            println("\t\t\tself->state = NULL;")
        }
    }

    private fun generateEntryActions(handler: Handler.Event, sourceState: State, activeConfiguration: List<State>, output: PrintWriter) {
        if (handler.target != null) output.apply {
            val target = handler.getTargetState(sourceState, machine)
            val transition = Transition(activeConfiguration, sourceState, target, handler.target.kind)
            val entrySet = transition.getEntrySet()
            val targetAtomicState = entrySet.last()
            println("\t\t\tself->state = ${machine.id}_${targetAtomicState.getFullyQualifiedIdString()};")
            for (stateToEnter in entrySet) {
                for (entry in stateToEnter.handlers.filterIsInstance<Handler.Entry>()) {
                    println("\t\t\t${entry.action}(self, event);")
                }
            }
        }
    }

    private fun configurationName(config: List<State>): String {
        return config.sortedWith(State.entryOrder).joinToString("_") { it.getFullyQualifiedIdString() }
    }

    fun generateSource(output: PrintWriter) {
        output.apply {
            println("/*This file was generated by Makina. Do not modify.*/")
            println("#include <stddef.h>")
            println("#include \"${machine.id}.h\"")
            println()
            val activeConfigurations = machine.getAllConfigurations()
            for (config in activeConfigurations) {
                println("static int ${machine.id}_${configurationName(config)}($machineStructName *, $machineEventName *);")
            }
            println()
            for (config in activeConfigurations) {
                println("static int ${machine.id}_${configurationName(config)}($machineStructName *self, $machineEventName *event) {")
                println("\t(void)self; (void)event;")
                println("\tswitch (event->id) {")
                val handlerGroups = config.getEventHandlers()
                for (entry in handlerGroups) {
                    val eventId = entry.key
                    println("\tcase ${machine.id}_event_$eventId:")
                    for (handlerStatePair in entry.value) {
                        val sourceState = handlerStatePair.first
                        val handler = handlerStatePair.second
                        val guard = if (handler.guard != null) "${handler.guard}(self, event)" else "1"
                        println("\t\tif ($guard) {")
                        generateExitActions(handler, sourceState, config, output)
                        if (handler.action != null) {
                            println("\t\t\t${handler.action}(self, event);")
                        }
                        generateEntryActions(handler, sourceState, config, output)
                        println("\t\t\tbreak;")
                        println("\t\t}")
                    }
                    println("\t\tbreak;")
                }
                println("\tdefault: break;")
                println("\t}")
                println("\treturn 0;")
                println("}")
                println()
            }
            println("int ${machine.id}_init($machineStructName *self) {")
            println("\tif (!self) return -1;")
            val initialConfig = machine.getInitialStateConfiguration()
            println("\tself->state = ${machine.id}_${configurationName(initialConfig)};")
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