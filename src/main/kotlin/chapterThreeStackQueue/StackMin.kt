package chapterThreeStackQueue

import java.util.*

class StackMin<T: Comparable<T>> {
    private class StackNode<T>(val data: T) {
        var nextMin: StackNode<T>? = null
        var next: StackNode<T>? = null
    }

    private var top: StackNode<T>? = null
    private var currentMin: StackNode<T>? = null

    fun pop(): T {
        if (top == null) throw EmptyStackException()

        if (top === currentMin) {
            currentMin = currentMin?.next
        }

        val item = top!!.data
        top = top!!.next

        return item
    }

    fun add(data: T) {
        val newNode = StackNode(data)
        newNode.next = top
        top = newNode

        if (currentMin == null) {
            currentMin = newNode
        } else {
            if (currentMin?.data!! > data) {
                newNode.nextMin = currentMin
                currentMin = newNode
            }
        }
    }

    fun getMin(): T? {
        return currentMin?.data
    }

    fun isEmpty(): Boolean = top == null

    fun peek(): T {
        if (top == null) throw EmptyStackException()
        return top!!.data
    }
}

fun main() {
    val stackMin = StackMin<Int>()
    stackMin.add(4)
    stackMin.add(2)
    stackMin.add(1)
    stackMin.add(3)
    stackMin.pop()
    stackMin.pop()

    println(stackMin.getMin())

}
