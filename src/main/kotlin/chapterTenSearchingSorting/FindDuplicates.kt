package chapterTenSearchingSorting

import java.util.*

fun findDuplicates(list: List<Int>) {
    val boolArray = BooleanArray(32000) { false }

    for (i in list.indices) {
        if (boolArray[list[i]]) {
            println(list[i])
        } else {
            boolArray[list[i]] = true
        }
    }

    // can use bitset class btw
}

fun main() {
    findDuplicates(listOf(1, 1, 1, 2, 2, 2))
}
