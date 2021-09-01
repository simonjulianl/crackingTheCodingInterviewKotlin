package chapterEightDPRecursion

fun naiveMultiply(n: Int, multiplier: Int): Int {
    if (multiplier == 0) return 0
    if (multiplier == 1) return n

    return if (multiplier % 2 == 1) {
        val x = naiveMultiply(n, (multiplier - 1) / 2)
        (x shl 1) + n
    } else {
        val x = naiveMultiply(n, multiplier / 2)
        (x shl 1)
    }
}

fun main() {
    println(naiveMultiply(5, 30))
}