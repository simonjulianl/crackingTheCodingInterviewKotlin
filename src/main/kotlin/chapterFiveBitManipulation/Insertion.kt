package chapterFiveBitManipulation

fun insertion(N: Int, M: Int, i: Int, j: Int): Int {
    val len = 32
    val gap = Integer.toBinaryString(M).length
    val firstPartMask = ((-1) shl j + 1) or ((1 shl i) - 1)
    val clearedInt = N and firstPartMask
    val paddedM = M shl i
    return paddedM or clearedInt
}

fun main() {
    println(Integer.toBinaryString(insertion(0b10000000000, 0b10011, 2, 6)))
}