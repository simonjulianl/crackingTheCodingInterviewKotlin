package chapterEightDPRecursion

import kotlin.math.abs

const val GRID_SIZE = 8

fun placeQueens(row: Int, columns: IntArray, result: ArrayList<IntArray>) {
    if (row == GRID_SIZE) {
        result.add(columns.clone())
    } else {
        for (i in 0 until GRID_SIZE) {
            if (checkValid(columns, row, i)) {
                columns[row] = i
                placeQueens(row + 1, columns, result)
                columns[row] = 0
            }
        }
    }
}

fun checkValid(columns: IntArray, row1: Int, col1: Int): Boolean {
    for (i in 0 until row1) {
        val col2 = columns[i]
        if (col2 == col1) return false

        val colDistance = abs(col2 - col1)
        val rowDistance = abs(i - row1)
        if (colDistance == rowDistance) return false
    }

    return true
}

fun main() {
    val result = arrayListOf<IntArray>()
    placeQueens(0, IntArray(GRID_SIZE), result)
    println(result[0].toList())
}