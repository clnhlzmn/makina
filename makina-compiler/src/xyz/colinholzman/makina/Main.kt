package xyz.colinholzman.makina

import java.io.File

fun main(args: Array<String>) {
    for (arg in args) {
        println(arg)
        File(arg).useLines { lines ->
            for (line in lines) {
                println(line)
            }
        }
    }
}
