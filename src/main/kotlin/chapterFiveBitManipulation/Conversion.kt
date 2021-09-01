package chapterFiveBitManipulation

fun conversion(n1 : Int, n2: Int): Int {
    val mask = n1 xor n2
    return mask.countOneBits()
}

fun main() {
    val number = 241
    println(Integer.toBinaryString(number))
    println(number.countTrailingZeroBits())
    println(Integer.rotateLeft(number, 1))
    println(number shl 1)
    println(conversion(29, 15))
}