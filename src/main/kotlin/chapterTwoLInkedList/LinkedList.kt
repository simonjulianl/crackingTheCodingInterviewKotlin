package chapterTwoLInkedList

class Node(var data: Int) {
    var next: Node? = null

    fun appendToTail(data: Int) {
        val newNode = Node(data)
        var current: Node = this
        while (current.next != null) {
            current = current.next!!
        }

        current.next = newNode
    }

    fun display() {
        var current: Node? = this
        while (current != null) {
            println(current.data)
            current = current.next
        }
    }

    fun delete(data: Int): Node {
        var prev: Node? = null
        var current: Node? = this
        while (current != null && current.data != data) {
            prev = current
            current = current.next!!
        }

        if (current == null) return this
        return if (prev == null) {
            // first item
            current.next!!
        } else {
            prev.next = current.next
            this
        }
    }

    // qn 1 remove duplicate
    fun removeDuplicate(): Node {
        val hashMap = hashMapOf<Int, Int>()
        var current: Node? = this
        var prev: Node? = null
        while (current != null) {
            val currentValue = current.data
            val count = hashMap.getOrDefault(currentValue, 0)
            if (count != 0) {
                // duplicate value
                val temp = current.next
                prev?.next = current.next
                current = temp
            } else {
                hashMap[currentValue] = 1
                prev = current
                current = current.next
            }
        }

        return this
    }
}



fun main() {
    var node = Node(5)
    node.appendToTail(10)
    node.appendToTail(5)
    node.appendToTail(10)
    node = node.removeDuplicate()
    var current: Node? = node
    while (current != null) {
        println(current.data)
        current = current.next
    }
}