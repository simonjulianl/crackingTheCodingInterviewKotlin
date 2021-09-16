package chapterSixteenMedium

fun negate(a: Int): Int {
    var num = a
    var neg = 0
    val newSign = if (a < 0) 1 else -1
    var delta = newSign

    while (num != 0) {
        val differentSign: Boolean = (num + delta > 0) != (num > 0)
        if (num + delta != 0 && differentSign) {
            delta = newSign
        }

        num += delta
        neg += delta
        delta += delta
    }

    return neg
}

fun minus(a: Int, b: Int): Int {
    return a + negate(b)
}

fun multiplication(a: Int, b: Int): Int {
    // a is always the bigger number
    if (a < 0 && b < 0) {
        return multiplication(negate(a), negate(b))
    } else if (b < 0) {
        return negate(multiplication(a, negate(b)))
    }

    if (a < b) return multiplication(b, a)

    var ans = 0
    for (i in 0 until b) {
        ans += a
    }

    return ans
}

fun division(a: Int, b: Int): Int {
    if (a < 0 && b < 0) {
        return division(negate(a), negate(b))
    } else if (a < 0 && b > 0) {
        return negate(division(negate(a), b))
    } else if (a > 0 && b < 0) {
        return negate(division(a, negate(b)))
    }

    if (b == 0) throw ArithmeticException("GG bois")

    var num = a
    var counter = 0
    while (num > 0) {
        if (num - b >= 0) {
            counter++
        }

        num -= b
    }

    return counter
}

fun main() {
    println(negate(10))
    println(multiplication(5, -10))
    println(division(8, 2))
}