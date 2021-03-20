package xyz.colinholzman.makina

sealed class Handler: Node() {
    data class Entry(val action: String): Handler() {
        constructor(action: String, location: SourceLocation): this(action) {
            this.location = location
        }
    }
    data class Exit(val action: String): Handler() {
        constructor(action: String, location: SourceLocation): this(action) {
            this.location = location
        }
    }
    data class Event(val id: String, val guard: String? = null,
                     val action: String? = null, val target: List<String> = emptyList()): Handler() {
        constructor(id: String, guard: String? = null,
                    action: String? = null, target: List<String> = emptyList(),
                    location: SourceLocation = SourceLocation.none): this(id, guard, action, target) {
            this.location = location
        }
        fun getTargetState(source: State, machine: Machine): State {
            if (target.isEmpty()) throw RuntimeException("handler doesn't define a transition")

            //first look in the top level if the target is so specified
            if (target.first() == ".")
                return machine.states.find { it.getFullyQualifiedId() == target } ?:
                    throw RuntimeException("target $target not found")

            //then look for the target among the children of the source state,
            //then among the siblings of the source state and the source state itself,
            //then among the parent and siblings of the parent of the source state, etc...
            var scope: State? = source
            while (true) {
                //append the scope's fully qualified name to the target
                val fullTargetId =
                        if (scope == null) listOf(".") + target
                        else scope.getFullyQualifiedId() + target

                //look for the fully qualified target among the states
                val found = machine.states.find { it.getFullyQualifiedId() == fullTargetId }
                if (found != null) return found

                //if scope is null then we have looked everywhere
                if (scope == null) throw RuntimeException("target $target not found")
                else scope = scope.parent
            }
        }
    }
}