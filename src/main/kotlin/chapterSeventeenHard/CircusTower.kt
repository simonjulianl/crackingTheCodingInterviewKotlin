package chapterSeventeenHard

data class Person(val weight: Int, val height: Int)

fun circusTower(weight: List<Int>, height: List<Int>): Int {
    val people = weight.mapIndexed { index, i ->
        Person(i, height[index])
    }
    val sortedWeight = people.sortedBy { it.weight }
    val sortedHeight = sortedWeight.map { it.height }
    // find LIS in sorted height
    return longestIncreasingSubsequence(height)
}

fun longestIncreasingSubsequence(list: List<Int>): Int {
    val table = Array(10) { 0 }
    for (i in list.indices) {
        var max = 0
        for (j in 0 until i) {
            if (table[j] > max && list[i] > list[j]) {
                max = table[j]
            }
        }
        table[i] = max + 1
    }

    return table.maxOrNull()!!
}

fun main() {
    val weight = listOf(1, 2, 3, 4)
    val height = listOf(9, 10, 5, 3)
    println(circusTower(weight, height))
}