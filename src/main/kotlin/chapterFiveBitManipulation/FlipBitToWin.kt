package chapterFiveBitManipulation

import kotlin.math.max

fun flipBitToWin(n: Int): Int {
    val binary = Integer.toBinaryString(n)
    var counter = 0
    var group = 1
    val hashMap = hashMapOf<Int, Int>()
    val newString = StringBuilder()
    var current: Char? = null

    for (bit in binary) {
        if (bit == '0') {
            if (current == '1') {
                hashMap[group] = counter
                newString.append(group)
                group++
                counter = 0
            }
            current = bit
            newString.append(0)
        } else {
            counter++
            current = bit
        }
    }

    if (current == '1') {
        hashMap[group] = counter
        newString.append(group)
        group++
    }

    println(newString.toString())

    var maxi = 0
    var string = newString.toString()
    for (i in string.indices) {
        if (string[i] == '0') {
            val len = 1 + hashMap.getOrDefault(
                string.getOrNull(i + 1)?.digitToInt(),
                0
            ) + hashMap.getOrDefault(string.getOrNull(i - 1)?.digitToInt(), 0)
            maxi = max(len, maxi)
        }
    }

    return maxi
}

fun main() {
    println(flipBitToWin(1775))
}