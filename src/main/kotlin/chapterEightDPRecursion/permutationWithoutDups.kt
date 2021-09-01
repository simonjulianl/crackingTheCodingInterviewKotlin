package chapterEightDPRecursion

// heap algo
fun permuteString(s: CharArray, n: Int) {
    if (n == 1) {
        println(s.joinToString(separator = ""))
        return
    }

    for (i in 0 until n) {
        permuteString(s, n - 1)
        if (n % 2 == 1) {
            val temp: Char = s[0]
            s[0] = s[n - 1]
            s[n - 1] = temp
        } else {
            val temp = s[n - 1]
            s[n - 1] = s[i]
            s[i] = temp
        }
    }
}

fun main() {
    permuteString("123".toCharArray(), 3)
}