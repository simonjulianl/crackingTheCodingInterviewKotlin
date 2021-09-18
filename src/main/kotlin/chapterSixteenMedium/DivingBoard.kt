package chapterSixteenMedium

fun generateAllLengths(k: Int, shorter: Int, longer: Int) {
    val set = mutableSetOf<Int>()

    for (i in 0..k) {
        val rest = k - i
        val currentLength = shorter * i + longer * rest
        set.add(currentLength)
    }

    set.forEach { println(it) }
}

fun main() {
    generateAllLengths(10, 5, 7)
}