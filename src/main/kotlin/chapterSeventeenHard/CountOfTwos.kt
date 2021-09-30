package chapterSeventeenHard

fun countOfTwos(n: Int): Int {
    if (n < 2) return 0
    var ans = 0

    var divider = 10
    var number = n
    while (divider < n) {
        val bonus = number % 10 != 1 && number % 10 != 0
        var baseNumber = n / divider
        baseNumber += if (bonus) 1 else 0

        ans += baseNumber
        divider *= 10
        number /= 10
    }

    return ans + if (number >= 2) 1 else 0
}

fun main() {
    for (i in 1..50) {
        println("$i ${countOfTwos(i)}")
    }
}