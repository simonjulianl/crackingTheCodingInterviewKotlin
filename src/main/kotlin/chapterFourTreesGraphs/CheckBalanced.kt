package chapterFourTreesGraphs

import kotlin.math.abs
import kotlin.math.max

val heightMap = HashMap<Node, Int>()

fun checkBalanced(node: Node?): Boolean {
    if (node == null) return true

    return checkBalanced(node.leftChild)
            && checkBalanced(node.rightChild)
            && (abs(height(node.leftChild) - height(node.rightChild)) <= 1)
}

fun height(node: Node?): Int {
    if (node == null) return 0
    return heightMap.getOrElse(node) {
        val height = max(height(node.leftChild), height(node.rightChild)) + 1
        heightMap[node] = height
        height
    }
}

fun main() {
    val array = arrayListOf(1, 2, 3, 4, 5)
    println(checkBalanced(minimalTree(array)))
}