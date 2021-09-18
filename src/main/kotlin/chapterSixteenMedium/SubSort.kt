package chapterSixteenMedium

fun leftStart(list: List<Int>): Int {
    var counter = 0
    while (counter < list.size && list[counter] <= list[counter + 1]) {
        counter++
    }

    return counter
}

fun rightStart(list: List<Int>): Int {
    var counter = list.size - 1
    while (counter >= 0 && list[counter] >= list[counter - 1]) {
        counter--
    }

    return counter
}

fun subSort(min: Int, max: Int, leftList: List<Int>, rightList: List<Int>, start: Int, end: Int): Pair<Int, Int> {
    var startIndex = start
    var endIndex = end
    var rightCounter = 0
    while (rightCounter < rightList.size) {
        if (rightList[rightCounter] < max) {
            println(rightList[rightCounter])
            rightCounter++
            endIndex++
        } else {
            break
        }
    }

    var leftCounter = leftList.size - 1
    while (leftCounter > 0) {
        if (leftList[leftCounter] > min) {
            println(leftList)
            leftCounter--
            startIndex--
        } else {
            break
        }
    }

    return Pair(startIndex, endIndex - 1)
}

fun main() {
    val ex = listOf(1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19)
    val left = leftStart(ex)
    val right: Int = rightStart(ex)
    val middle = ex.slice(left + 1 until right)
    val leftList = ex.slice(0 until left + 1)
    val rightList = ex.slice(right until ex.size)

    print(subSort(middle.minOrNull()!!, middle.maxOrNull()!!, leftList, rightList, left, right))
}