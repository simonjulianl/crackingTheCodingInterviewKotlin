package chapterEightDPRecursion

import java.lang.Exception

fun String.stringToBool(): Boolean {
    if (this == "1") return true
    return false
}

fun Int.factorial(): Int {
    var result = 1
    for (i in 1..this) {
        result *= i
    }
    return result
}

fun countEval(s: String, result: Boolean, memo: HashMap<String, Int>): Int {
    if (s.isEmpty()) return 0
    if (s.length == 1) return if (s.stringToBool() == result) 1 else 0

    if (memo.containsKey("$result`$s")) return memo["result`$s"]!!

    var ways = 0
    for (i in 1 until s.length step 2) {
        val c = s[i]
        val left = s.substring(0 until i)

        val right = try {
            s.substring(i + i until s.length)
        } catch (e: Exception) {
            ""
        }

        val leftTrue = countEval(left, true, memo)
        val rightTrue = countEval(right, true, memo)

        // catalan number optimisation
        val nLeft =  ((left.length - 1) / 2)
        val nRight = ((right.length - 1) / 2)
        val leftFalse = (2 * nLeft).factorial() / ((nLeft + 1).factorial() * (nLeft).factorial()) - leftTrue
        val rightFalse = (2 * nRight).factorial() / ((nRight + 1).factorial() * (nRight).factorial()) - rightTrue

        val total = (leftTrue + leftFalse) * (rightFalse + rightTrue)
        var totalTrue = 0
        when (c) {
            '^' -> {
                totalTrue = leftTrue * rightFalse + leftFalse * rightTrue
            }
            '&' -> {
                totalTrue = leftTrue * rightTrue
            }
            '|' -> {
                totalTrue = leftTrue * rightFalse + rightTrue * leftFalse + rightTrue * leftTrue
            }
        }


        val subWays = if (result) totalTrue else total - totalTrue
        ways += subWays
    }

    memo["result`$s"] = ways
    return ways
}

fun main() {
    println(countEval("1^0|0|1", true, hashMapOf()))
}