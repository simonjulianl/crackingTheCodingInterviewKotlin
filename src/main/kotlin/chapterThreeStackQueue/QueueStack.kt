package chapterThreeStackQueue

import java.util.*

class MyQueue {
    // queue implementation using two stacks
    private val stackNewest = Stack<Int>()
    private val stackOldest = Stack<Int>()

    fun add(item: Int) {
        stackOldest.add(item)
    }

    fun peek(): Int {
        return stackNewest.peek()
    }

    fun remove(): Int {
        return if (stackNewest.isEmpty()) {
            if (stackOldest.isEmpty()) throw EmptyStackException()

            // flip over all the oldest to newest stack
            while (!stackOldest.isEmpty()) {
                stackNewest.add(stackOldest.pop())
            }

            stackNewest.pop()
        } else {
            stackNewest.pop()
        }
    }
}

fun main() {
    val queue = MyQueue()
    queue.add(5)
    queue.add(6)
    queue.add(7)
    queue.add(8)
    println(queue.remove())
}