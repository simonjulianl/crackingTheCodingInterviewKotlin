package util

import java.util.*

fun smallestK(list: List<Int>, k: Int): List<Int> {
    if (list.size <= k) return list
    val newpq = PriorityQueue<Int>(k, Collections.reverseOrder())

    list.forEach {
        if (newpq.size < k) {
            newpq.add(it)
        } else {
            if (newpq.peek() > it) {
                newpq.poll()
                newpq.add(it)
            }
        }
    }

    return newpq.toList()
}

fun main() {
    println(smallestK(listOf(5,4,3,2,1), 2))
}