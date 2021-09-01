package chapterOneArrayString

fun palindromePermutation(str: String): Boolean {
//    val trimString = str.replace(" ", "") // or can use filter
//
//    // just check that it has either one or no odd
//    val charHashMap = hashMapOf<Char, Int>()
//    for (i in str) {
//        charHashMap[i] = charHashMap.getOrDefault(i, 0) + 1
//    }
//
//    return charHashMap.count { it.value % 2 == 1 } in listOf(0, 1)

    // alt using bitmap
    fun toggle(bitVector: Int, index: Int): Int {
        if (index < 0) return bitVector

        val mask = 1 shl index
        return if ((bitVector and mask) == 0) {
            bitVector or mask
        } else {
            bitVector xor mask
        }
    }

    fun checkExactlyOneBitSet(bitVector: Int): Boolean {
        return (bitVector and (bitVector - 1)) == 0
    }

    var bit = 0
    for (i in str) {
        bit = toggle(bit, i.code - 'a'.code)
    }

    return checkExactlyOneBitSet(bit) || bit == 0

}