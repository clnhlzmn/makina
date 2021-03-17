package xyz.colinholzman.makina

sealed class Handler: Node() {
    data class Entry(val action: String): Handler()
    data class Exit(val action: String): Handler()
    data class Event(val id: String, val guard: String? = null, val action: String? = null, val target: List<String> = emptyList()): Handler() {
        fun getTargetState(source: State, machine: Machine): State {
            if (target.isEmpty()) throw RuntimeException("handler doesn't define a transition")
            var scope: State? = source
            while (scope != null) {
                val fullTargetId = scope.getFullyQualifiedId() + target
                val found = machine.states.find { it.getFullyQualifiedId() == fullTargetId }
                if (found != null) return found
                scope = scope.parent
            }
            val found = machine.states.find { it.getFullyQualifiedId() == target }
            if (found != null) return found
            throw RuntimeException("target not found")
        }
    }
}