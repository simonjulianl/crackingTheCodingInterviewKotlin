package chapterTwoLInkedList

// iterative fashion
fun sumList(head1: Node, head2: Node): Node {
    var pointerFirst: Node? = head1
    var pointerSecond: Node? = head2
    var carry = 0

    var firstNode: Node? = null
    var lastNode: Node? = null

    while (pointerFirst != null || pointerSecond != null) {
        val firstValue: Int = pointerFirst?.data ?: 0
        val secondValue: Int = pointerSecond?.data ?: 0
        val sum = firstValue + secondValue + carry
        var number = sum
        if (sum >= 10) {
            carry = 1
            number -= 10
        } else {
            carry = 0
        }

        val newNode = Node(number)
        lastNode?.next = newNode
        if (firstNode == null) firstNode = newNode
        lastNode = newNode

        pointerFirst = pointerFirst?.next
        pointerSecond = pointerSecond?.next
    }

    if (carry == 1) {
        val extraNode = Node(carry)
        lastNode?.next = extraNode
    }

    return firstNode!!
}

data class PartialSum(
    var sum: Node?,
    var carry: Int
)

fun length(head: Node): Int {
    var current: Node = head
    var counter = 1
    while (current.next != null) {
        counter++
        current = current.next!!
    }

    return counter
}

fun padList(head: Node, length: Int): Node {
    var counter = length
    var current = head
    while (counter > 0) {
        val newNode = Node(0)
        newNode.next = current
        current = newNode
        counter--
    }

    return current
}

// recursive
fun sumListRecursive(head1: Node, head2: Node): Node? {
    val len1 = length(head1)
    val len2 = length(head2)

    var ll1 = head1
    var ll2 = head2

    if (len1 < len2) {
        ll1 = padList(ll1, len2 - len1)
    } else {
        ll2 = padList(ll2, len1 - len2)
    }

    val (LL, carry) = addList(ll1, ll2)
    return if (carry == 1) {
        val extraNode = Node(1)
        extraNode.next = LL
        extraNode
    } else {
        LL
    }
}

fun addList(head1: Node?, head2: Node?): PartialSum {
    // head1 and 2 has the same length
    if (head1 == null || head2 == null) return PartialSum(null, 0)

    val (nextLL, carry) = addList(head1.next, head2.next)

    val sum = head1.data + head2.data + carry

    return if (sum >= 10) {
        val newNode = Node(sum - 10)
        newNode.next = nextLL
        PartialSum(newNode, 1)
    } else {
        val newNode = Node(sum)
        newNode.next = nextLL
        PartialSum(newNode, 0)
    }
}

fun main() {
    val node = Node(5)
    node.appendToTail(1)
    node.appendToTail(2)
    node.appendToTail(3)
    node.appendToTail(4)

    val node2 = Node(5)
    node2.appendToTail(1)
    node2.appendToTail(2)
    node2.appendToTail(3)
    node2.appendToTail(4)

    val nodeX = sumListRecursive(node, node2)
    var current: Node? = nodeX
    while (current != null) {
        println(current.data)
        current = current.next
    }
}