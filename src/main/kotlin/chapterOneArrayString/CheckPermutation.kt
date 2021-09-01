package chapterOneArrayString

/**
 * Given two strings, write a method to decide if one is a permutation of the
other.
 */
fun checkPermutation(str1: String, str2: String): Boolean {
    fun populateHashMap(str: String): HashMap<Char, Int> {
        val charHashMap = hashMapOf<Char, Int>()
        for (i in str) {
            charHashMap[i] = charHashMap.getOrDefault(i, 0) + 1
        }
        return charHashMap
    }

    return populateHashMap(str1) == populateHashMap(str2)
}
