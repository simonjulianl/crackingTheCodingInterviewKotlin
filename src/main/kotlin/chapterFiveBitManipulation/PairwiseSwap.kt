package chapterFiveBitManipulation

fun swapOddEvenBits(x : Int) : Int {
    // important
    val oddMask = (0xaaaaaaaa).toInt() // even to add
    val evenMask = 0x55555555 // odd to even

    val test = (x and evenMask) shl 1
    println(Integer.toBinaryString(test))
    return ((x and oddMask) ushr 1) or ((x and evenMask) shl 1)
}

fun main() {
    val number = 5
    println(Integer.toBinaryString(number))

    val result = swapOddEvenBits(number)
    println(Integer.toBinaryString(result))

}