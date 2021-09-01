package chapterFiveBitManipulation

fun getBit(num: Int, i: Int): Boolean {
    return ((num and (1 shl i)) != 0)
}

fun setBit(num: Int, i: Int): Int {
    return num or (1 shl i)
}

fun clearBit(num: Int, i: Int): Int {
    return num and (1 shl i).inv()
}

fun clearBitsMSBThroughI(num: Int, i: Int): Int {
    val mask = (1 shl i) - 1
    return num and mask
}

fun clearBitsIThrough0(num: Int, i : Int) : Int {
    val mask = (-1 shl i)
    return num and mask
}

fun updateBit(num : Int, i: Int, bitValue: Boolean): Int {
    val value = if (bitValue) 1 else 0
    val mask = (1 shl i).inv()
    return (num and mask) or (value shl i)
}

fun main() {

}