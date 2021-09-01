package chapterSixPuzzleMath

import kotlin.math.sqrt

fun sieveOfEratosthenes(size: Int): List<Int> {
    if (size <= 1) return listOf()
    val primeFlags = BooleanArray(size) { true }.apply {
        this[0] = false
        this[1] = false
    }

    val primes = mutableListOf<Int>()
    var current = 2

    while (current <= sqrt(size.toDouble())) {
        primes.add(current)
        for (i in current * current until primeFlags.size step current) {
            primeFlags[i] = false
        }

        current++
        while (current <= sqrt(size.toDouble()) && !primeFlags[current]) {
            current++
        }
    }

    return primes
}

fun main() {
    println(sieveOfEratosthenes(100))
}