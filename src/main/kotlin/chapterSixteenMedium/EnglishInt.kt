package chapterSixteenMedium

import java.util.*

val ones = listOf(
    "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
    "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
    "Sixteen", "Seventeen", "Eighteen", "Nineteen"
)

val tens = listOf(
    "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
    "Eighty", "Ninety"
)

val bigs = listOf("", "Thousand", "Million", "Billion")

fun convertHundred(number: Int): String {
    var num = number
    val parts = mutableListOf<String>()

    if (num >= 100) {
        parts.add(ones[number / 100]);
        parts.add("Hundred")
        num %= 100
    }


    if (num in 10..19) {
        parts.add(ones[num])
    } else if (num >= 20) {
        parts.add(tens[num / 10])
        num %= 10
    }

    if (num in 1..9) {
        parts.add(ones[num])
    }

    return parts.joinToString(separator = " ")
}

fun printInteger(x: Int): String {
    if (x < 0) {
        return "Negative " + printInteger(-x)
    }

    val parts = mutableListOf<String>()

    var num = x
    var counter = 0
    while (num > 0) {
        if (num % 1000 != 0) {
            val chunk = convertHundred(num % 1000) + " " + bigs[counter]
            parts.add(chunk)
            counter++
        }
        num /= 1000
    }

    return parts.joinToString (" "){ it.lowercase() }
}

fun main() {
    println(printInteger(120))
}