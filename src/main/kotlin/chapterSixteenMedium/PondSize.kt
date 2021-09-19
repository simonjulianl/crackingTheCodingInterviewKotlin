package chapterSixteenMedium


fun pondSize(list: Array<IntArray>) {
    for (y in list.indices) {
        for (x in list[0].indices) {
            if (list[y][x] == 0) {
                println(dfs(list, x, y))
            }
        }
    }
}

fun dfs(list: Array<IntArray>, x: Int, y: Int): Int {
    if (list[y][x] != 0) return 0

    val maxX = list[0].size
    val maxY = list.size

    // mark the list
    list[y][x] = 1

    var counter = 1
    for (i in -1..1) {
        for (j in -1..1) {
            if (i == 0 && j == 0) continue

            val newCoord = Pair(x + i, y + j)
            if (newCoord.first < 0 || newCoord.first >= maxX || newCoord.second < 0 || newCoord.second >= maxY) continue

            if (list[newCoord.second][newCoord.first] == 0) {
                counter += dfs(list, newCoord.first, newCoord.second)
            }
        }
    }

    return counter
}

fun main() {
    val pond = arrayOf(intArrayOf(0, 2, 1, 0), intArrayOf(0, 1, 0, 1), intArrayOf(1, 1, 0, 1), intArrayOf(0, 1, 0, 1))
    pondSize(pond)
}