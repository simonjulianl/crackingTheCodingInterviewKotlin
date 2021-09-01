package chapterSixMathLogic

const val ANS = 30
var countDrop = 0

fun drop(floor: Int): Boolean {
    countDrop++
    return floor >= ANS
}

fun main() {
    var interval = 14
    var prevFloor = 0

    var egg1 = interval
    while (!drop(egg1) && egg1 <= 100) {
        interval -= 1
        prevFloor = egg1
        egg1 += interval
    }

    var egg2 = prevFloor + 1
    while (egg2 < egg1 && egg2 <= 100 && !drop(egg2)) {
        egg2 += 1
    }

    println(if (egg2 > ANS) -1 else egg2);
}