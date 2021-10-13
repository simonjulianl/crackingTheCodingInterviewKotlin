package chapterSeventeenHard

import java.util.*

val minPq = PriorityQueue<Int>()
val maxPq = PriorityQueue<Int> { a, b -> b - a }

fun getMedian(): Double {
    if (minPq.isEmpty() && maxPq.isEmpty()) {
        return 0.0
    } else if (minPq.isEmpty()) {
        return maxPq.peek().toDouble()
    } else if (maxPq.isEmpty()) {
        return minPq.peek().toDouble()
    }

    return if (minPq.size == maxPq.size) {
        (minPq.peek() + maxPq.peek()) / 2.0
    } else if (minPq.size > maxPq.size) {
        minPq.peek().toDouble()
    } else {
        maxPq.peek().toDouble()
    }
}

fun addItem(item: Int) {
    val currentMedian = getMedian()
    if (item > currentMedian) {
        minPq.add(item)
    } else {
        maxPq.add(item)
    }

    if (maxPq.size > minPq.size + 1) {
        minPq.add(maxPq.poll())
    } else if (minPq.size > maxPq.size + 1) {
        maxPq.add(minPq.poll())
    }
}

fun main() {
    addItem(10)
    addItem(20)
    addItem(30)
    addItem(40)
    println(maxPq)
    println(minPq)
    println(getMedian())
}
