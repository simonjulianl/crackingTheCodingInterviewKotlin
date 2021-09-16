package chapterSixteenMedium

import kotlin.math.absoluteValue

fun smallestDifference(array: Array<Int>, array2: Array<Int>) {
    array.sort()
    array2.sort()

    var i = 0
    var j = 0

    var ans = Int.MAX_VALUE
    var ansPair = Pair(i, j)
    while (i < array.size && j < array2.size) {
        val item1 = array[i]
        val item2 = array2[j]

        val diff = (item1 - item2).absoluteValue
        if (diff < ans) {
            ans = diff
            ansPair = Pair(item1, item2)
        }

        if (item1 < item2) {
            i++
        } else {
            j++
        }

    }

    println(ans)
    println(ansPair)
}

fun main() {
    smallestDifference(arrayOf(1, 3, 15, 11, 2), arrayOf(23, 127, 235, 19, 8))
}