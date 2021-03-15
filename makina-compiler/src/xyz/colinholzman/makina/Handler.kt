package xyz.colinholzman.makina

sealed class Handler: Node() {
    data class Entry(val action: String): Handler()
    data class Exit(val action: String): Handler()
    data class Event(val id: String, val guard: String? = null, val action: String? = null, val target: String? = null): Handler()
}