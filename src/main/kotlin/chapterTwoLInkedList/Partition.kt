package chapterTwoLInkedList

// the first node is the head of LL, the second node is the last of node with data < value
var headSmaller: Node? = null
fun partition(head: Node, value: Int): Node {
    if (head.next == null) {
        if (headSmaller == null && head.data < value) headSmaller = head
        return head
    }

    val nextLL = partition(head.next!!, value)
    return if (head.data < value) {
        if (headSmaller == null) {
            headSmaller = head
        }
        head.next = nextLL
        head
    } else {
        if (headSmaller == null) {
            // just append to beginning
            head.next = nextLL
            return head
        }
        head.next = headSmaller?.next
        headSmaller?.next = head
        nextLL
    }
}

fun main() {
    val node = Node(5)
    node.appendToTail(15)
    node.appendToTail(20)
    node.appendToTail(10)
    node.appendToTail(25)
    val nodeX = partition(node, 20)
    var current: Node? = nodeX
    while (current != null) {
        println(current.data)
        current = current.next
    }
}