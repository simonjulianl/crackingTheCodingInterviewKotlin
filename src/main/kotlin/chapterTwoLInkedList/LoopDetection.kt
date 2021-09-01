package chapterTwoLInkedList

// already given a circular linked list
fun loopDetection(head: Node): Node {
    var slow: Node = head
    var fast: Node = head

    // there must be a meeting point, since the given is already a corrupt LL
    while (fast.next != null) {
        slow = slow.next!!
        fast = fast.next!!.next!!
        if (slow === fast) break
    }

    // now fast is at n*ls - K steps ahead in the loop
    // the slow is at also the same point, to achieve n*ls so we at the head of loop
    // we need additional K steps which is from head to start of loop
    slow = head
    while (slow !== fast) {
        slow = slow.next!!
        fast = fast.next!!
    }

    return fast
}

fun main() {
    val head = Node(5)
    val second = Node(6)
    val third = Node(7)

    head.next = second
    second.next = third
    third.next = second

    val node = loopDetection(head)
    println(node.data)
}
