package chapterFourTreesGraphs

import java.util.*

class LLNode(val value: Int) {
    var next: LLNode? = null
}

fun listOfDepths(node: Node): List<LLNode> {
    class Wrapper(val node: Node, val level: Int)

    val queue: Queue<Wrapper> = LinkedList()
    var level = 1
    var root: LLNode? = null

    queue.add(Wrapper(node, level))

    val listOfDepths: ArrayList<LLNode> = ArrayList()

    var current = root

    while (queue.isNotEmpty()) {
        val top = queue.poll()
        if (level != top.level) {
            // push the previous one
            listOfDepths.add(root!!)
            root = LLNode(top.node.value)
            current = root
            level = top.level
        } else {
            val newNode = LLNode(top.node.value)
            if (root == null) {
                root = newNode
                current = root
            } else {
                current!!.next = newNode
                current = current.next!!
            }
        }

        top.node.leftChild?.let {
            queue.add(Wrapper(it, top.level + 1))
        }

        top.node.rightChild?.let {
            queue.add(Wrapper(it, top.level + 1))
        }
    }

    listOfDepths.add(root!!)

    return listOfDepths
}

fun main() {
    val array = arrayListOf(1, 2, 3, 4, 5)
    val tree = minimalTree(array)

    val list = listOfDepths(tree!!)
    var current: LLNode? = list[1]
    while (current != null) {
        println(current.value)
        current = current.next
    }
}