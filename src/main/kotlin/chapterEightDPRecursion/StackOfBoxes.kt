package chapterEightDPRecursion

import kotlin.math.max

data class Box(val width: Int, val height: Int, val depth: Int)

operator fun Box.compareTo(b: Box) =
    if (this.width > b.width && this.height > b.height && this.depth > b.depth) 1 else -1

fun createStack(boxes: ArrayList<Box>, bottom: Box?, offset: Int, stackMap: IntArray): Int {
    if (offset >= boxes.size) return 0
    val newBottom = boxes[offset]
    var heightWithBottom = 0

    if ((bottom == null) || (bottom > newBottom)) {
        if (stackMap[offset] == 0) {
            stackMap[offset] = createStack(boxes, newBottom, offset + 1, stackMap)
            stackMap[offset] += newBottom.height
        }
        heightWithBottom = stackMap[offset]
    }

    val heightWithoutBottom = createStack(boxes, bottom, offset + 1, stackMap)

    return max(heightWithBottom, heightWithoutBottom)
}

fun main() {
    val box = Box(5, 5, 5)
    val boxc = Box(5, 10, 5)
    val aBox = Box(2, 3, 4)
    val boxes = arrayListOf(box, aBox, boxc)
    boxes.sortByDescending { it.height }
    println(boxes[0])
    println(createStack(boxes, null, 0, IntArray(boxes.size)))
}