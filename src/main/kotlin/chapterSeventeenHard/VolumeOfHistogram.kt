package chapterSeventeenHard

fun volumeOfHistogram(hist: Array<Int>) {
    var ans = sweep(hist) // left sweep from max
    ans += sweep(hist.reversed().toTypedArray())
    println(ans)
}

private fun sweep(hist: Array<Int>): Int {
    val highestIndex = Array(hist.size) { 0 }
    var highestPrevIndex = 0
    for (i in hist.indices) {
        val currentItem = hist[i]
        if (currentItem > hist[highestPrevIndex]) {
            highestPrevIndex = i
        }
        highestIndex[i] = highestPrevIndex
    }

    var prev = highestIndex.last()
    var volume = 0
    while (prev != 0) {
        if (prev == 0 || highestIndex[prev - 1] == 0) {
            break
        }

        val prevIndex = highestIndex[prev - 1]
        val length = prev - prevIndex - 1
        for (j in prevIndex + 1 until prev) {
            volume -= hist[j]
        }
        volume += length * hist[prevIndex]

        prev = prevIndex
    }

    return volume
}

fun main() {
    val hist = arrayOf(0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 5, 0, 1, 0, 0, 0)
    volumeOfHistogram(hist)
}