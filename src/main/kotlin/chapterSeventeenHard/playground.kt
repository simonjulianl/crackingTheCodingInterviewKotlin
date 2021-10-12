package chapterSeventeenHard

import java.util.*

//fun findIdealNumber(lower: Long, high: Long) : Int {
//    val threeQ: Queue<Long> = LinkedList()
//    val fiveQ: Queue<Long> = LinkedList()
//
//    threeQ.add(1)
//    var ans = 0
//    while (true) {
//        val v3 = if (threeQ.size > 0 && threeQ.peek() >= 0)  threeQ.peek() else Long.MAX_VALUE
//        val v5 = if (fiveQ.size > 0 && fiveQ.peek() >= 0)  fiveQ.peek() else Long.MAX_VALUE
//
//        val min = if (v3 < v5) v3 else v5
//        println("$min ${Long.MAX_VALUE } $v3 $v5")
//        if (min > high || min == Long.MAX_VALUE) break;
//
//        if (v3 == min) {
//            val value = threeQ.poll()
//            if (value in lower..high) ans++
//            threeQ.add(3 * value)
//            fiveQ.add(5 * value)
//        } else {
//            val value = fiveQ.poll()
//            if (value in lower..high) ans++
//            fiveQ.add(5 * value)
//        }
//    }
//
//    return ans
//}

//fun textSearching(text: String, word: String): Int {
//    var ans = 0
//    for(i in 0 until text.length - word.length + 1) {
//        val string = text.substring(i, i + word.length)
//        if (string == word) {
//            ans++
//        }
//    }
//
//    return ans
//}

fun cardShufflingReferences(n: Int, k: Int): Int {
    val list = Array(n) { it + 1 }.toMutableList()
    while (list.size > 1) {
        for (i in 1 until k) {
            val top = list.removeFirst()
            list.add(top)
        }
        list.removeFirst()
//        println(list)
    }

    return list.removeFirst()
}

//fun cardShuffling(n: Int, k: Int): Int {
//    var list = Array(n) { it + 1 }.toList()
//    if (k == 1) return list.last()
//    while (list.size > 1) {
//        if (list.size > k) {
//            val firstList = arrayListOf<Int>()
//            val secondList = arrayListOf<Int>()
//
//            for (i in 0 until list.size - list.size % k) {
//                if ((i + 1) % k != 0) {
//                    firstList.add(list[i])
//                }
//            }
//
//            for (i in list.size - (list.size % k) until list.size) {
//                secondList.add(list[i])
//            }
//
//            secondList.addAll(firstList)
//            list = secondList
//        } else {
//            // find the split
//            val split = (k - 1) % list.size
//            val firstPart = list.slice(0 until split)
//            val secondPart = list.slice(split + 1 until list.size).toMutableList()
//            secondPart.addAll(firstPart)
//            list = secondPart
//            // from index split to end rotate the first, from index first to split - 1 (second part)
//        }
//        println(list)
//
//    }
//
//
//    return list[0]
//}

fun cardShuffling(n: Int, k: Int): Int {
    if (k == 1) return n
    val list: Queue<Int> = LinkedList()

    for (i in 1..n) {
        list.add(i)
    }

    var counter = 1
    while (list.size > 1) {
        val top = list.poll()
        if (counter != k) {
            list.add(top)
            counter++
        } else {
            counter = 1
        }
    }

    return list.poll()
}

fun main() {
//    for (n in 1 until 100) {
//        for (k in 1 until n) {
//            println("n:$n k:$k")
//            println(cardShuffling(n, k) == cardShufflingReferences(n, k))
//        }
//    }
//    println(cardShufflingReferences(10000, 10000))
    for (i in 2..100) {
        println(cardShuffling(i, 4))

    }
}
