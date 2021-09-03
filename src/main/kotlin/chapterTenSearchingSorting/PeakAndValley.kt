package chapterTenSearchingSorting

fun peakAndValley(list: List<Int>): List<Int> {
    if (list.isEmpty() || list.size == 1) return list
    val rest = peakAndValley(list.slice(1 until list.size))
    val current = list.first()
    val restHead = rest.first()

    return if (rest.size % 2 == 0) {
        // PVPV.. form
        if (current <= restHead) {
            listOf(current, *rest.toTypedArray())
        } else {
            listOf(restHead, current, *rest.slice(1 until rest.size).toTypedArray())
        }
    } else {
        // VPV.. form
        if (current >= restHead) {
            listOf(current, *rest.toTypedArray())
        } else {
            listOf(restHead, current, *rest.slice(1 until rest.size).toTypedArray())
        }
    }
}

fun main() {
    // if odd, V starts first, if even P starts first
    println(peakAndValley(listOf(5, 3, 1, 2, 3)))
}