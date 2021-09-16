package chapterSixteenMedium

fun flip(bit: Int): Int {
    return bit xor 1
}

fun sign(number: Int): Int {
    return flip((number shr 31) and 0x1)
}

fun max(a: Int, b: Int): Int {
    val c = a - b
    val sa = sign(a)
    val sb = sign(b)
    val sc = sign(c)

    // if a and b are of different sign, we just use sign of a
    // sign k = 1 if a > 0 k = 0 if a < 0
    val useSignA = sa xor sb

    // if a and b have the same sign, use k = sign(a-b)
    val useSignC = flip(useSignA)

    val k = useSignA * sa + useSignC * sc
    val q = flip(k)
    return a * k + b * q
}

fun main() {
    println(max(100,1120))
}