package chapterSeventeenHard

data class SquareCell(var zerosRight: Int = 0, var zerosBelow: Int = 0)

fun findSquare(matrix: Array<IntArray>): Int {
    val processed = processSquare(matrix)
    for (i in matrix.size - 1 downTo 1) {
        val result = findSquareWithSize(processed, i)
        if (result != -1) return result
    }

    return -1
}

fun processSquare(matrix: Array<IntArray>): Array<Array<SquareCell>> {
    val processed = Array(matrix.size) { Array(10) { SquareCell() } }
    for (r in matrix.size - 1 downTo 0) {
        for (c in matrix.size - 1 downTo 0) {
            var rightZeros = 0
            var belowZeros = 0
            if (matrix[r][c] == 0) {
                rightZeros++
                belowZeros++

                if (c + 1 < matrix.size) {
                    val prev = processed[r][c + 1]
                    rightZeros += prev.zerosRight
                }
                if (r + 1 < matrix.size) {
                    val prev = processed[r + 1][c]
                    belowZeros += prev.zerosBelow
                }
            }
            processed[r][c] = SquareCell(rightZeros, belowZeros)
        }
    }

    return processed
}

fun findSquareWithSize(matrix: Array<Array<SquareCell>>, squareSize: Int): Int {
    val count = matrix.size - squareSize + 1
    for (row in 0 until count) {
        for (col in 0 until count) {
            if (isSquare(matrix, row, col, squareSize)) {
                return squareSize // answer here
            }
        }
    }

    return -1
}

fun isSquare(matrix: Array<Array<SquareCell>>, row: Int, col: Int, sz: Int): Boolean {
    val topLeft = matrix[row][col]
    val topRight = matrix[row][col + sz - 1]
    val bottomLeft = matrix[row + sz - 1][col]

    if (topLeft.zerosRight < sz ||
        topLeft.zerosBelow < sz ||
        bottomLeft.zerosRight < sz ||
        topRight.zerosBelow < sz
    ) return false

    return true
}

fun main() {
    val square = arrayOf(intArrayOf(1, 0, 1), intArrayOf(0, 0, 1), intArrayOf(0, 0, 1))
    println(findSquare(square))
}