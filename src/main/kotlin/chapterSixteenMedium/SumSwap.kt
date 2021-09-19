package chapterSixteenMedium

fun sumSwap(first: IntArray, second: IntArray): Pair<Int, Int>? {
    first.sort()
    second.sort()

    val firstSum = first.sum()
    val secondSum = second.sum()

    val target = (firstSum - secondSum) / 2
    if (target * 2 != (firstSum - secondSum)) return null

    return findDifference(first, second, target)
}

fun findDifference(first: IntArray, second: IntArray, target: Int): Pair<Int, Int>? {
    var a = 0
    var b = 0

    while (a < first.size && b < second.size) {
        val difference = first[a] - second[b]

        if (difference == target) {
            return Pair(first[a], second[b])
        } else if (difference < target) {
            a++ // increase difference
        } else {
            b++ // decrease difference
        }
    }

    return null
}

fun main() {
    println(sumSwap(intArrayOf(4, 1, 2, 1, 1, 2), intArrayOf(3, 6, 3, 3)))
}