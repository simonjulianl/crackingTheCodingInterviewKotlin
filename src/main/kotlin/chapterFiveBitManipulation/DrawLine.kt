package chapterFiveBitManipulation

import kotlin.experimental.or
import kotlin.math.pow

/**
 * draw a horizontal line form (x1, y) to (x2, y)
 * x and y coordinate is 0-indexed 
 */
fun drawLine(screen: List<Byte>, width: Int, x1: Int, x2: Int, y: Int): List<Byte> {
    val startOffset = x1 % 8
    var firstFullByte = x1 / 8
    val screenCopy = screen.toMutableList()
    if (startOffset != 0) {
        firstFullByte++
    }

    val endOffset = x2 % 8
    var lastFullByte = x2 / 8
    if (endOffset != 7) {
        lastFullByte--
    }

    for (i in (firstFullByte..lastFullByte)) {
        screenCopy[(width / 8) * y + i] = 0xFF.toByte()
    }

    val startMask = 0xFF shr startOffset
    val endMask = (0xFF shr endOffset + 1).inv()
    if ((x1 / 8) == (x2 / 8)) {
        val mask = startMask and endMask
        screenCopy[(width / 8) * y + (x1 / 8)] = screenCopy[(width / 8) * y + (x1 / 8)] or mask.toByte()
    } else {
        // x1 and x2 are different
        if (startOffset != 0) {
            val byteNumber = (width / 8) * y + firstFullByte - 1
            screenCopy[byteNumber] = screenCopy[byteNumber] or startMask.toByte()
        }

        if (endOffset != 7) {
            val byteNumber = (width / 8) * y + lastFullByte + 1
            screenCopy[byteNumber] = screenCopy[byteNumber] or endMask.toByte()
        }
    }

    return screenCopy
}

fun main() {
    println(Byte.MAX_VALUE)
    println(2.0.pow(7) - 1)
    println(drawLine(listOf(0,0,0,0,0), 5, 1, 3, 0))
}