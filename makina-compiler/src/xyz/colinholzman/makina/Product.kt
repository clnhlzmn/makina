package xyz.colinholzman.makina

class Product {
    companion object {

        fun <T> Collection<Iterable<T>>.product(): Set<List<T>> =
            if (isEmpty()) emptySet()
            else drop(1).fold(first().map(::listOf)) { acc, iterable ->
                acc.flatMap { list -> iterable.map(list::plus) }
            }.toSet()

    }
}