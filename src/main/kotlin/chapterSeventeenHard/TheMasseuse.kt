package chapterSeventeenHard

import kotlin.math.max

val map = hashMapOf<Int, Int>()

fun theMasseuse(list: List<Int>): Int {
    if (list.isEmpty()) return 0
    if (list.size == 1) return list.first()
    if (map.containsKey(list.size)) {
        return map[list.size]!!
    }
    // naive
    val ignoreCurrent = theMasseuse(list.subList(1, list.size))
    val chooseCurrent = list.first() + theMasseuse(list.subList(2, list.size))
    val result = max(ignoreCurrent, chooseCurrent)
    map[list.size] = result
    return result
}

// the iterative version is just two stores extra two variables behind
// you just look the best solution one away and two away

fun main() {
    println(theMasseuse(listOf(30, 15, 60, 75, 45, 15, 15, 45)))
}
