package chapterSeventeenHard

import java.util.*
import kotlin.math.max

fun shortestSuperSequence(array: Array<Int>, elements: Array<Int>) {
    // assume elements is small enough, so we can use index of instead of creating a hashmap
    val locations = arrayListOf<Queue<Int>>()
    elements.sort()
    for (item in elements) {
        locations.add(LinkedList())
    }

    for (i in array.indices) {
        if (array[i] in elements) {
            locations[elements.indexOf(array[i])].add(i)
        }
    }

    // first is location, second
    val pq = PriorityQueue<Pair<Int, Int>> { a, b ->
        a.second - b.second
    }

    var curMin = Int.MAX_VALUE
    var curMax = Int.MIN_VALUE

    locations.forEachIndexed { index, queue ->
        println(queue)
        val value = queue.poll()
        pq.add(Pair(index, value))
        if (value > curMax) curMax = value
        if (value < curMin) curMin = value
    }


    var bestRange = Pair(curMin, curMax)

    while (pq.isNotEmpty()) {
        val (index, value) = pq.poll()

        val tempRange = (curMax - value)
        val bestRangeValue = bestRange.second - bestRange.first
        if (tempRange < bestRangeValue && tempRange >= elements.size - 1) {
            bestRange = Pair(value, curMax)
        }

        if (locations[index].isNotEmpty()) {
            val newValue = locations[index].poll()
            curMax = max(curMax, newValue)
            pq.add(Pair(index, newValue))
        }
    }

    println(bestRange)
}

fun main() {
    shortestSuperSequence(arrayOf(7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 5, 8, 8, 9, 7), arrayOf(1, 5, 9))
}