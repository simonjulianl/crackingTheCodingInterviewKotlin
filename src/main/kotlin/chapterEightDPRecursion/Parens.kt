package chapterEightDPRecursion

fun parens(arr: ArrayList<String>, left: Int, right: Int, index: Int, str: CharArray) {
    if (left < 0 || right < left) return

    if (left == 0 && right == 0) {
        arr.add(str.joinToString(separator = ""))
    } else {
        str[index] = '('
        parens(arr, left - 1, right, index + 1, str)

        str[index] = ')'
        parens(arr, left, right - 1, index + 1, str)
    }
}

fun main() {
    val list = arrayListOf<String>()
    parens(list, 3, 3, 0, CharArray(3 * 2))
    println(list)
}
