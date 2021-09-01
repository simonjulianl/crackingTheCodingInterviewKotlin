package chapterEightDPRecursion

import java.lang.Integer.max
import java.lang.Integer.min


fun magicIndex(arr: IntArray, start: Int, end: Int): Int {
    if (end < start) return -1
    val mid = (start + end) / 2
    return if (arr[mid] == mid) {
        mid
    } else if (arr[mid] > mid) {
        magicIndex(arr, start, mid - 1)
    } else {
        magicIndex(arr, mid + 1, start)
    }
}

fun magicIndexDuplicate(arr: IntArray, start: Int, end: Int): Int {
    if (end < start) return -1
    val mid = (start + end) / 2
    return if (arr[mid] == mid) {
        mid
    } else if (arr[mid] > mid) {
        magicIndex(arr, max(arr[mid], mid + 1), end)
    } else {
        magicIndex(arr, start, min(arr[mid], mid - 1))
    }
}