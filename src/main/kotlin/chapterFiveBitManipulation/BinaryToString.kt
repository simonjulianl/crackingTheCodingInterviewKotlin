package chapterFiveBitManipulation

fun binaryToString(number: Double): String {
    val string = StringBuilder().apply {
        this.append(0)
            .append('.')
    }
    var current = number
    var iteration = 0
    while (current != 0.0 && iteration < 33) {
        current *= 2
        if (current >= 1) {
            current -= 1.0
            string.append(1)
        } else {
            string.append(0)
        }
        iteration++
    }

    return if (iteration == 32) "ERROR" else string.toString()
}

fun main() {
    println(binaryToString(0.5))
}