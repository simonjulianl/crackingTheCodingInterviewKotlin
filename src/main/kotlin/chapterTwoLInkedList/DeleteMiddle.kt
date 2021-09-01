package chapterTwoLInkedList

fun deleteMiddleNode(node: Node): Node? {
    // the node given in the question cannot be the first or last so must be at least LL of length 3
    return if (node.next == null) {
        null
    } else {
        node.data = node.next!!.data
        node.next = deleteMiddleNode(node.next!!)
        node
    }
}

fun main() {
    val node = Node(5)
    val node2 = Node(10)
    val node3 = Node(15)
    node.next = node2
    node2.next = node3
    deleteMiddleNode(node2)

    var current: Node? = node
    while (current != null) {
        println(current.data)
        current = current.next
    }
}

