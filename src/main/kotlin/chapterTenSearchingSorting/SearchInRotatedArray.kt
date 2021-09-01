package chapterTenSearchingSorting

// this is dumber (log n)^2 solution
fun searchRotated(list: List<Int>, item: Int): Int {
    val low = 0
    val high = list.size - 1
    if (low > high) return -1
    // originally list is increasing
    val mid = low + (high - low) / 2

    val isRotated = list[low] >= list[high]
    if (!isRotated) {
        val index = list.subList(low, high).binarySearch(item)
        return if (index >= 0) {
            index
        } else {
            -1
        }
    } else {
        // rotated
        val first = searchRotated(list.subList(0, mid), item)
        val second = searchRotated(list.subList(mid, list.size), item)

        return if (first != -1) {
            first
        } else {
            mid + second
        }
    }
}

fun searchRotatedSmarter(arr: IntArray, low: Int, high: Int, item: Int): Int {
    val mid = (low + high) / 2
    if (item == arr[mid]) return mid
    if (low > high) return -1

    if (arr[low] < arr[mid]) {
        // left is normal
        return if (item >= arr[low] && item < arr[mid]) {
            searchRotatedSmarter(arr, low, mid - 1, item)
        } else {
            searchRotatedSmarter(arr, mid + 1, high, item)
        }
    } else if (arr[mid] < arr[low]) {
        // symmetric case where right is normal
        return if (item > arr[mid] && item <= arr[high]) {
            searchRotatedSmarter(arr, mid + 1, high, item)
        } else {
            searchRotatedSmarter(arr, low, mid, item)
        }
    } else if (arr[low] == arr[mid]) {
        return if (arr[mid] != arr[high]) {
            searchRotatedSmarter(arr, mid + 1, high, item)
        } else {
            val result = searchRotatedSmarter(arr, low, mid - 1, item)
            if (result != -1) result else searchRotatedSmarter(arr, mid + 1, high, item)
        }
    }

    return -1
}

fun main() {
    val array = listOf(15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14)
    println(searchRotated(array, 25))
    println(searchRotated(array, 1))
    println(searchRotated(array, 3))
    println(searchRotated(array, 4))
    println(searchRotated(array, 5))
}