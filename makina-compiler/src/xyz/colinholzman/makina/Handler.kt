package xyz.colinholzman.makina

sealed class Handler(location: SourceLocation): Node(location) {
    class Entry(val action: String,
                location: SourceLocation = SourceLocation.none) : Handler(location) {

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Entry

            if (action != other.action) return false

            return true
        }

        override fun hashCode(): Int {
            return action.hashCode()
        }
    }
    class Exit(val action: String,
               location: SourceLocation = SourceLocation.none): Handler(location) {

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Exit

            if (action != other.action) return false

            return true
        }

        override fun hashCode(): Int {
            return action.hashCode()
        }

    }
    class Event(val id: String, val guard: String? = null,
                     val action: String? = null, val target: Target? = null,
                     location: SourceLocation = SourceLocation.none): Handler(location) {

        fun getTargetState(source: State, machine: Machine): State {
            if (target == null) throw RuntimeException("handler doesn't define a transition")

            //first look in the top level if the target is so specified
            if (target.id.first() == ".")
                return machine.states.find { it.getFullyQualifiedId() == target.id } ?:
                    throw RuntimeException("target $target not found at $location")

            //then look for the target among the children of the source state,
            //then among the siblings of the source state and the source state itself,
            //then among the parent and siblings of the parent of the source state, etc...
            var scope: State? = source
            while (true) {
                //append the scope's fully qualified name to the target
                val fullTargetId =
                        if (scope == null) listOf(".") + target.id
                        else scope.getFullyQualifiedId() + target.id

                //look for the fully qualified target among the states
                val found = machine.states.find { it.getFullyQualifiedId() == fullTargetId }
                if (found != null) return found

                //if scope is null then we have looked everywhere
                if (scope == null) throw RuntimeException("target ${target.id} not found at $location")
                else scope = scope.parent
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Event

            if (id != other.id) return false
            if (guard != other.guard) return false
            if (action != other.action) return false
            if (target != other.target) return false

            return true
        }

        override fun hashCode(): Int {
            var result = id.hashCode()
            result = 31 * result + (guard?.hashCode() ?: 0)
            result = 31 * result + (action?.hashCode() ?: 0)
            result = 31 * result + target.hashCode()
            return result
        }
    }

    companion object {
        val entryOrder = Comparator<Pair<State, Handler>> { o1, o2 ->
            val stateComparison = State.entryOrder.compare(o1.first, o2.first)
            if (stateComparison != 0) stateComparison
            else o1.second.location.compareTo(o2.second.location)
        }

        val exitOrder = Comparator<Pair<State, Handler>> { o1, o2 ->
            val stateComparison = State.entryOrder.compare(o2.first, o1.first)
            if (stateComparison != 0) stateComparison
            else o2.second.location.compareTo(o1.second.location)
        }
    }
}