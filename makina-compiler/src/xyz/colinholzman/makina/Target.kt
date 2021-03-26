package xyz.colinholzman.makina

data class Target(val id: List<String> = emptyList(), val kind: Kind = Kind.DEFAULT) {
    enum class Kind {
        DEFAULT,
        EXTERNAL
    }
}