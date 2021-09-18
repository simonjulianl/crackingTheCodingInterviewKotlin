package chapterSixteenMedium

fun contiguousSequence(list: List<Int>): Int {
    var max = 0
    var current = 0
    list.forEach {
        current += it
        if (current > max) max = current
        if (current <= 0) current = 0
    }

    return max
}

fun main() {
    println(contiguousSequence(listOf(2, -8, 3, -2, 4, -10)))
}