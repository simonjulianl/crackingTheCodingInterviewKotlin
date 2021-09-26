package chapterSeventeenHard

import kotlin.random.Random

fun generateRan(low: Int, high: Int): Int {
    return Random.nextInt(low, high + 1)
}

fun shuffleArrayRecursively(card: ArrayList<Int>, i: Int) {
    if (i <= 0) return
    shuffleArrayRecursively(card, i - 1)
    val randNum = generateRan(0, i - 1)
    val temp = card[i]
    card[i] = card[randNum]
    card[randNum] = temp
}

fun main() {
    val card = arrayListOf(1,2,3,4)
    shuffleArrayRecursively(card, 3)
    println(card)
}