package chapterOneArrayString

fun stringCompression(str: String): String {
    var currentChar: Char? = null
    var occurrence = 0
    var newString = StringBuilder()
    for (i in str) {
        when {
            currentChar == null -> {
                currentChar = i
                occurrence = 1
            }
            i != currentChar -> {
                newString.append(currentChar + occurrence.toString())
                currentChar = i
                occurrence = 1
            }
            else -> {
                occurrence++
            }
        }
    }
    newString.append(currentChar?.plus(occurrence.toString()))
    return if (newString.length > str.length) str else newString.toString()
}