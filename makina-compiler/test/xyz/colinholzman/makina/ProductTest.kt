package xyz.colinholzman.makina

import org.junit.jupiter.api.Test
import xyz.colinholzman.makina.Product.Companion.product
import kotlin.test.assertEquals

class ProductTest {
    @Test
    fun product() {
        run {
            val actual = listOf(listOf("a"), listOf("b")).product()
            val expected = setOf(
                    listOf("a", "b"),
            )
            assertEquals(expected, actual)
        }
        run {
            val actual = listOf(listOf("a", "b"), listOf("c", "d")).product()
            val expected = setOf(
                    listOf("a", "c"),
                    listOf("a", "d"),
                    listOf("b", "c"),
                    listOf("b", "d")
            )
            assertEquals(expected, actual)
        }
        run {
            val actual = listOf(listOf("a", "b"), listOf("c", "d"), listOf("e")).product()
            val expected = setOf(
                    listOf("a", "c", "e"),
                    listOf("a", "d", "e"),
                    listOf("b", "c", "e"),
                    listOf("b", "d", "e"),
            )
            assertEquals(expected, actual)
        }
    }
}