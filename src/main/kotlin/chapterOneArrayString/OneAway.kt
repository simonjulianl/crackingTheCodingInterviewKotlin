package chapterOneArrayString

import java.util.*
import kotlin.math.absoluteValue

fun oneAway(str1: String, str2: String): Boolean {
    if ((str1.length - str2.length).absoluteValue > 1) return false

    val shorter = if (str1.length > str2.length) str2 else str1
    val longer = if (shorter == str1) str2 else str1

    var pointerLong = 0
    var pointerShort = 0
    var foundDifference = false

    while (pointerShort < shorter.length && pointerLong < longer.length) {
        if (longer[pointerLong] != shorter[pointerShort]) {
            if (foundDifference) return false // two differences
            foundDifference = true

            if (longer.length == shorter.length) pointerShort++
        } else {
            pointerShort++
        }
        pointerLong++
    }
    return true

}