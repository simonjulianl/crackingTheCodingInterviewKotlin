package chapterTwoLInkedList

import kotlin.math.abs

fun intersection(head1: Node, head2: Node): Node? {
    val len1 = length(head1)
    val len2 = length(head2)

    var headPointer1: Node? = head1
    var headPointer2: Node? = head2
    val diff = abs(len1 - len2)
    if (len1 > len2) {
        headPointer1 = fastForward(head1, diff)
    } else {
        headPointer2 = fastForward(head2, diff)
    }

    while (headPointer1 != null && headPointer2 != null) {
        if (headPointer1 === headPointer2) return headPointer1
        headPointer1 = headPointer1.next
        headPointer2 = headPointer2.next
    }

    return null
}

fun fastForward(head: Node, k: Int): Node {
    var current = head
    for (i in k downTo 1) {
        current = current.next!!
    }

    return current
}

fun main() {
    val node = Node(5)

    val secondNode = Node(5)
    secondNode.next = node
    node.appendToTail(10)
    node.appendToTail(20)

    println(intersection(node, secondNode)?.data)
}