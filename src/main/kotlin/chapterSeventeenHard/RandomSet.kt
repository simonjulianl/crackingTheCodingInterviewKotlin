package chapterSeventeenHard

import kotlin.random.Random

fun randomSet(list: ArrayList<Int>, m: Int): ArrayList<Int> {
    val result = arrayListOf<Int>()
    for (i in 0 until m) {
        result.add(list[i])
    }

    for (i in m until list.size) {
        val number = Random.nextInt(i)
        if (number < m) {
            result[number] = list[m]
        }
    }

    return result
}

fun main() {
    println(randomSet(arrayListOf(1,2,3,4,5),2))
}