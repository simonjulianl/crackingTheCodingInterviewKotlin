package chapterSixMathLogic

import kotlin.math.log2

fun findPoisonedBottle(nBottle: Int, nStrip: Int) {
    // not possible to use this method
    if (nStrip < log2(nBottle.toDouble())) return

    val stripList = Array(nStrip) {
        ArrayList<Int>()
    }

    (1..nBottle).forEach { x ->
        val string = Integer.toBinaryString(x);
        string.forEachIndexed { index, c ->
            if (c == '1') {
                stripList[index].add(x)
            }
        }
    }
    // val result = stripList.forEach { test(it) }
    val result = BooleanArray(nStrip) { true }
    val binaryString = result.map { if (it) '1' else '0' }.joinToString(separator = "")
    println(Integer.parseInt(binaryString, 2))

}

fun main() {
    findPoisonedBottle(1000, 10)
}