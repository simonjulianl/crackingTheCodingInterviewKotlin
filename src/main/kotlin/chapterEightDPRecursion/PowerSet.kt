package chapterEightDPRecursion

fun powerSet(set: List<Int>): List<List<Int>> {
    if (set.isEmpty()) return listOf(ArrayList())
    val first = set[0]
    val rest = powerSet(set.slice(1 until set.size))

    val newList: ArrayList<List<Int>> = ArrayList(rest)

    for (set in rest) {
        val copy = ArrayList(set)
        copy.add(0, first)
        newList.add(copy)
    }

    return newList
}

fun main() {
    println(powerSet(listOf(4, 5, 6)).sortedWith(compareBy({ it.size }, { it.first() })))
}
