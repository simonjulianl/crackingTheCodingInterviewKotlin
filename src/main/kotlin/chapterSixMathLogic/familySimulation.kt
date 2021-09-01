package chapterSixMathLogic

import java.util.*

fun main() {
    val random = Random()
    var boys = 0
    var girls = 0
    repeat(10000) {
        while (true) {
            val value = random.nextFloat()
            if (value < 0.5) {
                boys++
            } else {
                girls++
                break
            }
        }
    }

    println(boys / girls.toFloat())
}