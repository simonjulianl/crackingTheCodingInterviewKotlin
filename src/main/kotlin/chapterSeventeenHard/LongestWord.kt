package chapterSeventeenHard

import java.util.*
import kotlin.collections.HashMap

fun printLongestWord(list: List<String>) {
    val map = hashMapOf<String, Boolean>()
    list.forEach { map[it] = true }

    val newList = list.sortedBy { it.length }

    newList.forEach {
        val result = canBuildWord(it, true, map)
        if (result) {
            println(it)
        }
    }
}

fun canBuildWord(str: String, isOriginalWord: Boolean, map: HashMap<String, Boolean>): Boolean {
    if (map.containsKey(str) && !isOriginalWord) {
        return map[str]!!
    }

    for (i in 1 until str.length) {
        val firstString = str.substring(0, i)
        val secondString = str.substring(i)
        val result = canBuildWord(firstString, false, map) && canBuildWord(secondString, false, map)
        if (result) {
            map[str] = result
            return true
        }
    }

    if (!isOriginalWord) {
        map[str] = false
    }

    return false
}

fun main() {
    printLongestWord(listOf("testing", "test", "ing"))
    val pq = PriorityQueue<Int>()
    val compareByLength: Comparator<String> = compareBy { it.length }

}
