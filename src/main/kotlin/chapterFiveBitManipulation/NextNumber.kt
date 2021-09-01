package chapterFiveBitManipulation

fun getNext(n: Int): Int {
    var c = n
    var c0 = 0
    var c1 = 0

    while (((c and 1) == 0 && (c != 0))) {
        c0++
        c = c shr 1
    }

    while ((c and 1) == 1) {
        c1++
        c = c shr 1
    }

    if (c0 + c1 == 31 || c0 + c1 == 0) {
        return -1
    }

    val p = c0 + c1

    var number = n
    number = number or (1 shl p)
    number = number and ((1 shl p) - 1).inv()
    number = number or (1 shl (c1 - 1) - 1)

    return number
}

fun getPrev(n : Int) : Int {
    var c = n
    var c0 = 0
    var c1 = 0


    while ((c and 1) == 1) {
        c1++
        c = c shr 1
    }

    if (c == 0) return -1

    while (((c and 1) == 0 && (c != 0))) {
        c0++
        c = c shr 1
    }

    val p = c0 + c1
    var number = n
    number = number and (0.inv() shl (p + 1))

    val mask = (1 shl (c1 + 1)) - 1
    number = number or (mask shl (c0 - 1))

    return number
}

fun main() {
    val number = getNext(1775)
    println(number)
}