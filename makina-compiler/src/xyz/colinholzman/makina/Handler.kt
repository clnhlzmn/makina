package xyz.colinholzman.makina

sealed class Handler: Node() {
    data class Entry(val action: String): Handler()
    data class Exit(val action: String): Handler()
    data class Event(val id: String, val guard: String?, val action: String?, val target: String?): Handler()
}