package chapterSeventeenHard

const val COL = 3;

class BitInteger(val value: Int) {
    private val valueString: String
        get() = Integer.toBinaryString(value).padStart(COL, '0')

    fun getValue(): String {
        return valueString
    }

    fun fetch(col: Int): Char {
        return valueString[col]
    }
}

/**
 * pretty hard, the idea is to recursively check and eliminate n/2, n/4, n/8... by checking what's the bit is supposed to be
 */
fun findMissing(input: List<BitInteger>, col: Int): String {
    if (col >= COL) return ""
    val (zeroBits, oneBits) = input.partition { it.fetch(col) == '0' }
    return if (zeroBits.size <= oneBits.size) {
        findMissing(zeroBits, col + 1) + "0"
    } else {
        findMissing(oneBits, col + 1) + "1"
    }
}

fun main() {
    val list = List(5) { BitInteger(it) }
    list.toMutableList().removeAt(3)
    println(findMissing(list, 0))
}
