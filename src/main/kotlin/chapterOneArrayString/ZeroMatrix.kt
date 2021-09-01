package chapterOneArrayString

val newMatrix = arrayOf(
    intArrayOf(1, 0, 3),
    intArrayOf(0, 5, 6),
    intArrayOf(7, 8, 9)
)


fun markZero(matrix: Array<IntArray>) {
    var rowHasZero = false
    var colHasZero = false

    // check each
    matrix[0].forEach { if (it == 0) rowHasZero = true }
    for (i in matrix.indices) {
        if (matrix[i][0] == 0) colHasZero = true
    }

    val nullifyRow = { row: Int ->
        for (i in 0 until matrix[row].size) {
            matrix[row][i] = 0
        }
    }

    val nullifyCol = { col: Int ->
        for (i in matrix.indices) {
            matrix[i][col] = 0
        }
    }

    for (i in matrix.indices) {
        for (j in 0 until matrix[0].size) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0
                matrix[0][j] = 0
            }
        }
    }

    for (row in 1 until matrix.size) {
        if (matrix[row][0] == 0) {
            nullifyRow(row)
        }
    }

    for (col in 1 until matrix[0].size) {
        if (matrix[0][col] == 0) {
            nullifyCol(col)
        }
    }

    if (rowHasZero) nullifyRow(0)
    if (colHasZero) nullifyCol(0)
}

fun main() {
    markZero(newMatrix)
    newMatrix.forEach { row ->
        row.forEach { print(it) }
        println("")
    }
}
