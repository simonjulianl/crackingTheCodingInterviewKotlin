package chapterTwelveC

const val K = 10;
fun printLastKLines() {
    val array = IntArray(K)
    var result = readLine()?.toInt()
    if (result != null) {
        array[0] = result
    }
    var counter = 1
    while (result != null && result != 0) {
        result = readLine()?.toInt()
        if (result != null && result != 0) {
            array[counter % K] = result
            counter++
        }
    }

    val start = if (counter >= K) 0 else counter % K + 1
    for (i in 0 until K) {
        println(array[(start + i) % K])
    }
}

fun main() {
    printLastKLines()
}