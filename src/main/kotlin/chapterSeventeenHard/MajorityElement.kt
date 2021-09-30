package chapterSeventeenHard

fun majorityElement(list: List<Int>): Int {
    var majority = -1
    var count = 0
    list.forEach {
        if (count == 0) {
            majority = it
            count++
        } else {
            if (majority == it) {
                count++
            } else {
                count--
            }
        }
    }

    return majority
}

fun main() {
    println(majorityElement(listOf(1, 2, 5, 9, 5, 9, 5, 5, 5)))
}