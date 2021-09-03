package chapterTenSearchingSorting

import kotlin.experimental.and
import kotlin.experimental.or

fun missingInt(list: List<Int>) {
    val numberOfInts = Int.MAX_VALUE
    val byteArray = ByteArray(numberOfInts / 8)
    for (item in list) {
        byteArray[item / 8] = byteArray[item / 8] or ((1 shl (item % 8)).toByte())
    }

    for (i in byteArray.indices) {
        for (j in 0 until 8) {
            if ((byteArray[i] and ((1 shl j).toByte())).toInt() == 0) {
                println(i * 8 + j)
                return
            }
        }
    }
}

/**
 * the idea for the second one is
 * [block, block, block] => of lenght arraySize,
 * then we can just bin them into blocks, find the first block that is not full and use the bit vector to find the first 0
 */

/**
 * my method, instead of range, use modulus
 */
fun missingFollowUp(list: List<Int>): Int {
    lateinit var cache: Map.Entry<Int, List<Int>>;
    list.groupBy { it % 5 }.filterValues { value -> value.size < 2 }.forEach { cache = it }

    var first = cache.key
    for (item in cache.value) {
        if (item != first) {
            return first
        }
        first += 5
    }

    return first
}

fun main() {
    missingInt(listOf(0, 1, 2, 4))
    println(missingFollowUp(listOf(0, 1, 2, 3, 4, 5, 6, 7, 9)))
}