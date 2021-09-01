package chapterOneArrayString

/**
 * check that all char in string is unique
 */
fun isUnique(str: String): Boolean = str.toSet().size == str.length

fun isUniqueAlt(str: String): Boolean {
    for (i in str) {
        if (str.count { it == i } > 1) return false
    }
    return true
}