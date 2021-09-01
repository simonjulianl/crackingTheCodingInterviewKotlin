package chapterTwoLInkedList

// remove duplicate with no extra space
fun removeDuplicateToo(head: Node): Node {
    var current: Node? = head
    while(current != null) {
        var runner = current
        while (runner!!.next != null) {
            if (runner.next!!.data == current.data) {
                runner.next = runner.next!!.next
            } else {
                runner = runner.next
            }
        }
        current = current.next
    }

    return head
}