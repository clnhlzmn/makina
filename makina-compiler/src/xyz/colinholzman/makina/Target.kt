package xyz.colinholzman.makina

data class Target(val id: List<String> = emptyList(), val kind: Kind = Kind.EXTERNAL) {
    enum class Kind {
        EXTERNAL,
        LOCAL
    }
}