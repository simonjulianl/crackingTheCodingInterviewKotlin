package chapterSeventeenHard

fun add(a: Int, b: Int): Int {
    if (b == 0) return a
    val sum = a xor b
    val carry = (a and b) shl 1
    return add(sum, carry)
}

fun main() {
    println(add(5, 10))
}