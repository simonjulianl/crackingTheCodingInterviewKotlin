package chapterEightDPRecursion

fun robotInAGrid(
    x: Int,
    y: Int,
    grid: List<List<Int>>,
    pathTable: Array<Array<Pair<Boolean, Pair<Int, Int>>>>
) {
    if (x == 0 && y == 0) {
        pathTable[0][0] = Pair(true, Pair(0, 0))
        return
    }

    if (grid[y][x] == 0) {
        return
    }

    // left and up (y, x)
    val direction = listOf(Pair(0, -1), Pair(-1, 0))
    var prev: Pair<Int, Int> = Pair(-1, -1)
    for (dir in direction) {
        val newY = y + dir.first
        val newX = x + dir.second

        if (newY < 0) continue
        if (newX < 0) continue

        var memo = pathTable[newY][newX]
        if (!memo.first) {
            // not visited
            robotInAGrid(newX, newY, grid, pathTable)
        }

        memo = pathTable[newY][newX]

        if (memo.second.first != -1) {
            // valid path
            prev = Pair(y + dir.first, x + dir.second)
            break
        }
    }

    pathTable[y][x] = Pair(true, prev)
}

fun main() {
    // 1 mean can, 0 mean cannot
    val grid = listOf(
        listOf(1, 1, 1, 1),
        listOf(0, 1, 0, 1),
        listOf(0, 1, 1, 0),
        listOf(1, 1, 1, 1),
    )

    val path = Array(4) {
        Array(4) {
            // visited, pair
            Pair(false, Pair(-1, -1))
        }
    }

    robotInAGrid(3, 3, grid, path)
    for (row in path) {
        for (col in row) {
            print(col.second)
        }
        println()
    }
}