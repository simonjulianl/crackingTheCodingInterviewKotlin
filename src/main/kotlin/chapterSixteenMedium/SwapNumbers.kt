package chapterSixteenMedium

fun swap(a: Int, b: Int): Pair<Int, Int> {
    var num1 = a
    var num2 = b
    num1 = num1 xor num2 // a ^ b
    num2 = num1 xor num2 // a ^ b ^ b = a
    num1 = num1 xor num2 // a ^ b ^ a = b

    return Pair(num1, num2)
}

fun main() {
    println(swap(5, 10))
}