package chapterTenSearchingSorting

// just don't use size method
class Listy(vararg items: Int) {
    private val list = items.toList()

    fun elementAt(i: Int): Int {
        return if (i >= list.size) -1 else list[i]
    }
}

fun sortedSearch(listy: Listy, item: Int) {
    var high = Int.MAX_VALUE
    var low = 0

    while (low < high) {
        val mid = low + (high - low) / 2
        if (listy.elementAt(mid) == -1) {
            high = mid - 1
        } else {
            low = mid
        }
    }

    val length = low

    // can binary search as per normal
    high = length
    low = 0

    while (low < high) {
        val mid = low + (high - low) / 2
        if (listy.elementAt(mid) <= mid) {
            high = mid
        } else {
            low = mid + 1
        }
    }

    println(listy.elementAt(low))
}

fun main() {
    sortedSearch(Listy(1, 2, 3, 4, 5, 5, 5, 5), 5)
}