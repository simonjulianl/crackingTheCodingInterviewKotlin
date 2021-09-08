package chapterTwelveC

fun reverseString(sth: String): String {
    return sth.reversed()
}

fun main() {
    val string = "test"
    println(reverseString(string))
}