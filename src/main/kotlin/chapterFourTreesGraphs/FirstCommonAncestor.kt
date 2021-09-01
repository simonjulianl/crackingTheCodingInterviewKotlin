package chapterFourTreesGraphs

import java.util.*
import kotlin.math.abs

// assume node doesnt have parent Pointer
fun firstCommonAncestor(root: Node, nodeA: Node, nodeB: Node): Node? {
    val pathA = findPath(root, nodeA, Stack())
    val pathB = findPath(root, nodeB, Stack())

    // if depth A > depth B
    val diff = abs(pathA.size - pathB.size)

    for (i in 0 until diff) {
        if (pathA.size > pathB.size) {
            pathA.pop()
        } else {
            pathB.pop()
        }
    }

    while (pathA.isNotEmpty() && pathB.isNotEmpty()) {
        val nodeA = pathA.pop()
        val nodeB = pathB.pop()
        if (nodeA === nodeB) {
            return nodeA
        }
    }

    return null
}

fun findPath(node: Node, nodeTBF: Node, stack: Stack<Node>): Stack<Node> {
    if (node === nodeTBF) {
        stack.push(node)
        return stack
    }
    stack.push(node)
    for (children in listOf(node.leftChild, node.rightChild)) {
        // traverse left then right
        if (children != null) {
            val newStack = findPath(children, nodeTBF, stack)
            if (newStack.contains(nodeTBF)) {
                return newStack
            }
        }
    }
    stack.pop()

    return stack
}

fun main() {
    val root = Node(5)
    val left = Node(1)
    val right = Node(3)

    val leftleft = Node(10)
    val leftright = Node(17)

    val rightright = Node(30)

    root.leftChild = left
    root.rightChild = right

    left.leftChild = leftleft
    left.rightChild = leftright

    right.rightChild = rightright

    val stack = findPath(root, right, Stack())
    println(firstCommonAncestor(root, leftleft, right)?.value)
}