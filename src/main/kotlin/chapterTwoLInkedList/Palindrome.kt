package chapterTwoLInkedList

fun isPalindrome(head: Node): Boolean {
    // get the middle
    var slowPointer: Node? = head
    var fastPointer: Node? = head
    while (fastPointer?.next?.next != null)  {
        slowPointer = slowPointer?.next
        fastPointer = fastPointer.next!!.next
    }

    var reversedLL: Node? = reverseLinkedList(slowPointer?.next!!)
    var currentHead: Node? = head

    while (reversedLL != null && currentHead != null) {
        if (currentHead.data != reversedLL.data) return false
        currentHead = currentHead.next
        reversedLL = reversedLL.next
    }

    return true
}

fun reverseLinkedList(head: Node): Node {
    var prev: Node? = null
    var current: Node? = head
    var next: Node?

    while (current != null) {
        next = current.next
        current.next = prev
        prev = current
        current = next
    }

    return prev!!
}

fun main() {
    var node = Node(1)
    node.appendToTail(2)
    node.appendToTail(2)
    node.appendToTail(1)

    print(isPalindrome(node))
}