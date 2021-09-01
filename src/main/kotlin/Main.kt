import chapterOneArrayString.*
import java.io.File
import java.io.FileInputStream
import java.time.LocalDateTime
import java.util.*

private fun readLn() = readLine()!!
private fun readInt() = readLn().toInt()
private fun readStrings() = readLn().split(" ")
private fun readInts() = readStrings().map { it.toInt() }

class Node<T>(var value: T) {
    var next: Node<T>? = null
}

fun main(args: Array<String>) {
    val date = LocalDateTime.now()
    println(date.plusDays(5).toLocalTime())

    val inputStream = FileInputStream(File(args[0]))
    System.setIn(inputStream)
    println("is unique : ${isUniqueAlt("test")}")
    println("check permutation : ${checkPermutation("test", "ttes")}")
    println("urlify: ${URLify("test test")}")
    println("palindrome permutation: ${palindromePermutation("test")}")
    println("one edit away : ${oneAway("test", "tst")}")
    println("string compression : ${stringCompression("aabcccccaaa")}")
    val newMatrix = rotateMatrix(
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
    )

    newMatrix.forEach { row ->
        row.forEach { print(it) }
        println("")
    }

    println(
        "rotate matrix : ${
            rotateMatrix(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9)
                )
            )
        }"
    )
}