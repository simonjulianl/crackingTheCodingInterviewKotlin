package chapterSeventeenHard

import kotlin.math.sqrt

// every item in array is from 1 to N and appears exactly once
fun missingOne(array: Array<Int>): Int {
    // O(1) space, O(N) time due to sum
    val properSize = array.size + 1
    val properSum = properSize * (properSize + 1) / 2
    return properSum - array.sum()
}

fun missingTwo(array: Array<Int>) {
    array.sort()
    val properSize = array.size + 2
    val properSum = properSize * (properSize + 1) / 2
    val sumTwoMissing = properSum - array.sum()

    val squared = array.map { it * it }.toTypedArray()
    val properSumSquare = properSize * (properSize + 1) * (2 * properSize + 1) / 6
    val sumTwoSquaredMissing = properSumSquare - squared.sum()

    val a = 2
    val b = -2 * sumTwoMissing
    val c = sumTwoMissing * sumTwoMissing - sumTwoSquaredMissing

    val x = (-b + sqrt((b * b - 4 * a * c).toDouble())) / (2 * a)
    println("x : $x, y : ${sumTwoMissing - x}")
}

fun main() {
    println(missingOne(arrayOf(1, 2, 3, 4, 5, 7)))
    missingTwo(arrayOf(1, 2, 3, 5, 7))
}