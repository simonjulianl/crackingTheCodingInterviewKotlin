package chapterSixteenMedium

fun trailingZero(n: Int): Int {
    var num5 = 0
    var num2 = 0

    for (i in (1..n)) {
        var new = i
        while (new % 5 == 0) {
            num5++
            new /= 5
        }

        new = i
        while (num2 % 2 == 0) {
            num2++
            new /= 2
        }
    }

    return num2.coerceAtMost(num5)
}

fun main() {
    println(trailingZero(5))
}