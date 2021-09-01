package chapterOneArrayString

import java.io.File
import java.io.FileInputStream

// given a method called isSubstring
fun stringRotation(str1: String, str2: String): Boolean {
    val newString = str1 + str1
    return newString.contains(str2)
    // from qn, given isSubstring
    // return isSubstring(str2, newString)
}

fun main(args: Array<String>) {
    val inputStream = FileInputStream(File(args[0]))
    System.setIn(inputStream)
}