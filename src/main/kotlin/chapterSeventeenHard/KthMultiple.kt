package chapterSeventeenHard

import java.util.*
import kotlin.math.min

fun getKthMagicNumber(k: Int): Int {
    val threeQ: Queue<Int> = LinkedList()
    val fiveQ: Queue<Int> = LinkedList()
    val sevenQ: Queue<Int> = LinkedList()

    threeQ.add(1)
    var ans = 0
    for (i in 0 until k) {
        val v3 = if (threeQ.size > 0)  threeQ.peek() else Int.MAX_VALUE
        val v5 = if (fiveQ.size > 0)  fiveQ.peek() else Int.MAX_VALUE
        val v7 = if (sevenQ.size > 0)  sevenQ.peek() else Int.MAX_VALUE

        val min = min(v7, min(v3, v5))
        ans = min
        when (min) {
            v3 -> {
                threeQ.remove()
                threeQ.add(3 * min)
                fiveQ.add(5 * min)
            }
            v5 -> {
                fiveQ.remove()
                fiveQ.add(5 * min)
            }
            else -> {
                sevenQ.remove()
            }
        }
        sevenQ.add(7 * min)
    }

    return ans
}

fun main() {
    println(getKthMagicNumber(10))
}