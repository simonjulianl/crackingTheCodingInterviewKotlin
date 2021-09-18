package chapterSixteenMedium

fun isMatching(pattern: String, string: String): Boolean {
    val aCount = pattern.count { it == 'a' }
    val bCount = pattern.count { it == 'b' }
    val c = string.length

    for (aLength in 1..c) {
        val bLength = (c - aCount * aLength).toDouble() / bCount
        if (bLength - bLength.toInt() == 0.0) {
            var currentLength = 0
            var patternB: String? = null
            var patternA: String? = null
            var isTrue = true
            pattern.forEach { char ->
                if (char == 'a') {
                    if (patternA == null) {
                        patternA = string.substring(currentLength, currentLength + aLength)
                    } else {
                        if (string.substring(currentLength, currentLength + aLength) != patternA) {
                            isTrue = false
                        }
                    }
                    currentLength += aLength
                } else {
                    if (patternB == null) {
                        patternB = string.substring(currentLength, currentLength + bLength.toInt())
                    } else {
                        if (string.substring(currentLength, currentLength + bLength.toInt()) != patternB) {
                            isTrue = false
                        }
                    }
                    currentLength += bLength.toInt()
                }
            }
            if (isTrue) return true
        }
    }

    return false
}

fun main() {
    println(isMatching("aabb", "googootaktak"))
}