package chapterTwoLInkedList

// O(N) solution, twice passing
fun returnKthLast(head: Node?, k: Int): Node? {
    // find length of the LL
    var length = 0
    var current: Node? = head
    while (current != null) {
        length++
        current = current.next
    }

    var counter = length - k

    if (counter < 0) return head // size < k
    current = head
    while (counter > 0) {
        current = current?.next
        counter--
    }

    return current
}

fun returnKthLastRecursive(head: Node?,k : Int): Int {
    if (head == null) return 0
    val index = returnKthLastRecursive(head.next, k) + 1
    if (index == k) println(head.data)
    return index
}

fun main() {
    val node = Node(5)
    node.appendToTail(10)
    node.appendToTail(15)
    node.appendToTail(20)
    node.appendToTail(25)
    returnKthLastRecursive(node, 1)
}