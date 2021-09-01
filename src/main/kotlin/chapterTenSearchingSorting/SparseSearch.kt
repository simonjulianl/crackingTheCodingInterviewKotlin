package chapterTenSearchingSorting

fun sparseSearch(strings: Array<String>, first: Int, last: Int, str: String): Int {
    if (first > last) return -1

    var mid = first + (last - first) / 2

    if (strings[mid].isEmpty()) {
        var left = mid - 1
        var right = mid + 1

        while (true) {
            if (left < first && right > last) {
                return -1
            } else if (right <= last && strings[right].isNotEmpty()) {
                mid = right
                break
            } else if (left >= first && strings[left].isNotEmpty()) {
                mid = left
                break
            }
            right++
            left--
        }
    }

    return if (str == strings[mid]) {
        mid
    } else {
        if (strings[mid] < str) {
            // search right
            sparseSearch(strings, mid + 1, last, str)
        } else {
            sparseSearch(strings, first, mid - 1, str)
        }
    }
}

fun main() {
    println(sparseSearch(arrayOf("", "", "", "test"), 0, 3, "test"))
}