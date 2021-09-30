package chapterSeventeenHard

/**
 * theoretically, when you are trying to repeat this many times,
 * create a hashmap of words to list of locations of the two words
 * merge the two list => O(N), then do this algo => O(N)
 */

fun findDistance(list: List<Int>, first: Int, second: Int): Int {
    var last = Pair(-1, -1)
    var min = Int.MAX_VALUE
    list.forEachIndexed { index, it ->
        if (it == -1) {
            if (it == first) {
                last = Pair(it, index)
            } else if (it == second) {
                last = Pair(it, index)
            }
        } else {
            if (it == first) {
                if (last.first == second) {
                    val cur = index - last.second
                    if (cur < min) min = cur
                }
                last = Pair(it, index)
            } else if (it == second) {
                if (last.first == first) {
                    val cur = index - last.second
                    if (cur < min) min = cur
                }
                last = Pair(it, index)
            }
        }
    }

    return min
}

fun main() {
    println(findDistance(listOf(1, 2, 5, 5, 4, 3, 0, 5, 1, 3), 5, 3))
}