package chapterTenSearchingSorting

fun sort(A: IntArray, B: IntArray, lastA: Int, lastB: Int): IntArray {
    // A >> B, A and B sorted
    var lastAIndex = lastA
    var lastBIndex = lastB
    var lastIndexArray = lastA + lastB + 1

    while (lastAIndex >= 0 && lastBIndex >= 0) {
        val a = A[lastAIndex]
        val b = B[lastBIndex]
        val smaller = if (a > b) {
            lastAIndex--
            a
        } else {
            lastBIndex--
            b
        }

        A[lastIndexArray] = smaller
        lastIndexArray--
    }

    while (lastBIndex >= 0) {
        A[lastIndexArray] = B[lastBIndex]
        lastBIndex--
    }

    return A
}

fun main() {
    val A = IntArray(5) { 0 }
    A[0] = 1
    A[1] = 4
    A[2] = 5

    val B = intArrayOf(2, 3)
    println(sort(A, B, 2, 1).toList())
}