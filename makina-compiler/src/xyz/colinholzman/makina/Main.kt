package xyz.colinholzman.makina

import java.io.File

fun main(args: Array<String>) {
    for (arg in args) {
        println(arg)
        val machine = Parse.file(arg)
        println(machine)
    }
}
