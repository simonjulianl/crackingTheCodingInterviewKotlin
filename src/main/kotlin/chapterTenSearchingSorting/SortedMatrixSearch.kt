package chapterTenSearchingSorting

import java.lang.Integer.min

class Coordinate(var row: Int, var col: Int) : Cloneable {
    fun inbounds(matrix: Array<IntArray>): Boolean {
        return row >= 0 && col >= 0 && row < matrix.size && col < matrix[0].size
    }

    public override fun clone(): Any {
        return Coordinate(row, col)
    }

    fun isBefore(p: Coordinate): Boolean {
        return row <= p.row && col <= p.col
    }

    fun setToAverage(min: Coordinate, max: Coordinate) {
        row = (min.row + max.row) / 2
        col = (min.col + max.col) / 2
    }
}

fun findElement(matrix: Array<IntArray>, item: Int): Coordinate? {
    val origin = Coordinate(0, 0)
    val bottomright = Coordinate(matrix.size - 1, matrix[0].size - 1)
    return findElement(matrix, origin, bottomright, item)
}

fun findElement(matrix: Array<IntArray>, origin: Coordinate, dest: Coordinate, item: Int): Coordinate? {
    if (!origin.inbounds(matrix) || !dest.inbounds(matrix)) return null
    if (matrix[origin.row][origin.col] == item) {
        return origin
    } else if (!origin.isBefore(dest)) {
        return null
    }

    val start = origin.clone() as Coordinate
    val diagDist = min(dest.row - origin.row, dest.col - origin.col)
    val end = Coordinate(start.row + diagDist, start.col + diagDist)

    val p = Coordinate(0, 0);
    while (start.isBefore(end)) {
        p.setToAverage(start, end)
        if (item > matrix[p.row][p.col]) {
            start.row = p.row + 1
            start.col = p.col + 1
        } else {
            start.row = p.row - 1
            start.col = p.row - 1
        }
    }

    return partitionAndSearch(matrix, origin, dest, start, item)
}

fun partitionAndSearch(
    matrix: Array<IntArray>,
    origin: Coordinate,
    dest: Coordinate,
    pivot: Coordinate,
    item: Int
): Coordinate? {
    val lowerLeftOrigin = Coordinate(pivot.row, origin.col)
    val lowerLeftDest = Coordinate(origin.row, pivot.col - 1)
    val upperRightOrigin = Coordinate(origin.row, pivot.col)
    val upperRightDest = Coordinate(pivot.row - 1, dest.col)

    return findElement(matrix, lowerLeftOrigin, lowerLeftDest, item)
        ?: findElement(matrix, upperRightOrigin, upperRightDest, item)
}

fun main() {
    val coord = Coordinate(1, 2)
    coord.clone()
}