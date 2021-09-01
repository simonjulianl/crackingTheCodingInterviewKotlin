package chapterTenSearchingSorting

import kotlin.math.floor
import kotlin.math.log10

fun quickSort(list: List<Int>): List<Int> {
    if (list.isEmpty() || list.size == 1) return list
    val pivot = list[0]

    val newList = list.toMutableList()
    newList.removeFirst()

    val (lower, higher) = newList.partition { it < pivot }
    val sortedLow = quickSort(lower)
    val sortedHigh = quickSort(higher)

    val answer = mutableListOf<Int>()
    answer.addAll(sortedLow)
    answer.add(pivot)
    answer.addAll(sortedHigh)

    return answer
}

fun selectionSort(list: ArrayList<Int>): ArrayList<Int> {
    if (list.isEmpty()) return list
    val first = list[0]
    val rest = selectionSort(ArrayList(list.slice(1 until list.size)))
    val position = rest.binarySearch(first)

    if (position < 0) {
        val actual = -(position + 1)
        rest.add(actual, first)
    } else {
        rest.add(position + 1, first)
    }

    return rest
}

fun bubbleSort(list: List<Int>): List<Int> {
    val newList = list.toIntArray()

    for (i in newList.indices) {
        for (j in 0 until newList.size - i - 1) {
            if (newList[j] > newList[j + 1]) {
                val temp = newList[j]
                newList[j] = newList[j + 1]
                newList[j + 1] = temp
            }
        }
    }

    return newList.toList()
}

fun mergeSort(list: List<Int>): List<Int> {
    if (list.isEmpty() || list.size == 1) return list
    val mid = list.size / 2
    val firstHalf = list.slice(0 until mid)
    val secondHalf = list.slice(mid until list.size)

    val lower = mergeSort(firstHalf).toMutableList()
    val higher = mergeSort(secondHalf).toMutableList()

    val newList = ArrayList<Int>()

    while (lower.isNotEmpty() && higher.isNotEmpty()) {
        val first = lower.first()
        val second = higher.first()
        if (first > second) {
            newList.add(second)
            higher.removeFirst()
        } else {
            newList.add(first)
            lower.removeFirst()
        }
    }

    if (lower.isNotEmpty()) {
        newList.addAll(lower)
    } else {
        newList.addAll(higher)
    }

    return newList
}

fun radixSort(list: List<Int>): List<Int> {
    val longest = list.map { floor(log10(it.toDouble())) + 1 }.maxOrNull() ?: 0
    var temp = list.toMutableList()
    var exponent = 1

    for (i in 0 until longest.toInt()) {
        val array = Array(10) {
            ArrayList<Int>()
        }

        for (item in temp) {
            val digit = item / exponent % 10
            array[digit].add(item)
        }

        temp = array.reduce { acc, it ->
            acc.addAll(it)
            acc
        }

        exponent *= 10
    }

    return temp
}

fun main() {
    val list = listOf(1, 4, 3, 2, 7, 9, 0)
    println("quicksort ${quickSort(list)}")
    println("selection sort ${selectionSort(ArrayList(list))}")
    println("bubble sort ${bubbleSort(list)}")
    println("merge sort ${mergeSort(list)}")
    println("radix sort with counting sort ${radixSort(list)}")
}