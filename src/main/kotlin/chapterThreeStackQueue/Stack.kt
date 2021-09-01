package chapterThreeStackQueue

import java.util.*

class StackPractice<T> {
    private class StackNode<T>(val data: T) {
        var next: StackNode<T>? = null
    }

    private var top: StackNode<T>? = null

    fun pop(): T {
        if (top == null) throw EmptyStackException()
        val item = top!!.data
        top = top!!.next
        return item
    }

    fun add(data: T) {
        val newNode = StackNode(data)
        newNode.next = top
        top = newNode
    }

    fun isEmpty(): Boolean = top == null

    fun peek(): T {
        if (top == null) throw EmptyStackException()
        return top!!.data
    }
}

fun main() {
    val realStack = Stack<Int>() // use what kotlin/java collections provide
    val realQueue: Queue<Int> = ArrayDeque()
}