package chapterSixteenMedium

class Result {
    var hits = 0
    var pseudoHits = 0
}

fun code(c: Char): Int {
    return when (c) {
        'B' -> 0
        'G' -> 1
        'R' -> 2
        'Y' -> 3
        else -> -1
    }
}

fun estimate(guess: String, solution: String): Result {
    val result = Result()
    if (guess.length != solution.length) return result

    val freq = Array(4) { 0 }

    for (i in guess.indices) {
        if (guess[i] == solution[i]) {
            result.hits++
        } else {
            val code = code(solution[i])
            freq[code]++
        }
    }

    for (i in solution.indices) {
        val code = code(guess[i])
        if (code >= 0 && freq[code] > 0 && guess[i] != solution[i]) {
            result.pseudoHits++
            freq[code]--
        }
    }

    return result
}

fun main() {
    println(estimate("RRRR", "BBBB"))
}