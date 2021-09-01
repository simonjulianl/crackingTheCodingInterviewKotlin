package chapterEightDPRecursion

fun tripleStep(n: Int, memo: IntArray): Int {
    if (memo[n] != -1) {
        return memo[n]
    }

    when (n) {
        0 -> {
            memo[n] = 1
            return 1
        }
        1 -> {
            memo[n] = 1
            return 1
        }
        2 -> {
            memo[n] = 2
            return 2
        }
    }

    val answer = tripleStep(n - 1, memo) + tripleStep(n - 2, memo) + tripleStep(n - 3, memo)
    memo[n] = answer
    return answer
}

fun main() {
    println(tripleStep(5, IntArray(11) { -1 }))
}
