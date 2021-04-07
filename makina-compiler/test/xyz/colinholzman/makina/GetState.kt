package xyz.colinholzman.makina

class GetState {
    companion object {
        fun Machine.getState(idStr: String): State {
            val id = Parse.id(idStr)
            return states.find { it.id == id.last() && it.parentId == id.dropLast(1) }!!
        }
    }
}