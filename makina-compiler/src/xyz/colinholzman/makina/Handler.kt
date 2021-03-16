package xyz.colinholzman.makina

sealed class Handler: Node() {
    data class Entry(val action: String): Handler()
    data class Exit(val action: String): Handler()
    data class Event(val id: String, val guard: String? = null, val action: String? = null, val target: String? = null): Handler() {
        fun getTargetState(machine: Machine): State {
            if (target == null) throw RuntimeException("handler doesn't define a transition")
            return machine.states.find { it.id == target } ?: throw RuntimeException("target state not found")
        }
    }
}