package xyz.colinholzman.makina

fun List<String>.isRoot(): Boolean {
    return equals(listOf("."))
}

fun List<String>.isNotRoot(): Boolean {
    return !isRoot()
}
