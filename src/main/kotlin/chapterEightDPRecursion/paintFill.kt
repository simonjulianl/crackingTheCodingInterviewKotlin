package chapterEightDPRecursion

fun paintFill(
    picture: List<MutableList<Int>>,
    visited: Array<BooleanArray>,
    x: Int,
    y: Int,
    oriColor: Int,
    newColor: Int
) {
    if (visited[y][x] || picture[y][x] != oriColor) return
    visited[y][x] = true
    picture[y][x] = newColor

    val direction = listOf(Pair(0, 1), Pair(-1, 0), Pair(1, 0), Pair(1, 0))
    for (dir in direction) {
        val newX = x + dir.first
        val newY = y + dir.second
        if (!(newX < 0 || newY < 0 || newX > 2 || newY > 2) && !visited[newY][newX]) {
            paintFill(picture, visited, newX, newY, oriColor, newColor)
        }
    }
}

fun main() {
    val picture = listOf(
        mutableListOf(1, 2, 3),
        mutableListOf(1, 1, 3),
        mutableListOf(1, 1, 1)
    )

    val visited = Array(picture.size) {
        BooleanArray(picture[0].size) { false }
    }

    paintFill(picture, visited, 0, 0, picture[0][0], 2)
    println(picture)
}