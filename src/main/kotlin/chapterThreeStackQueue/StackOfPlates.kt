package chapterThreeStackQueue

import java.util.*

class StackOfStacks(private val capacity: Int) {
    private var stacks = mutableListOf<Stack<Int>>(Stack())

    fun push(data: Int) {
        val stack = stacks.last()
        if (stack.size == capacity) {
            val newStack = Stack<Int>()
            newStack.add(data)
            stacks.add(newStack)
        } else {
            stack.add(data)
        }
    }

    fun pop(): Int {
        var stack = stacks.last()
        return if (stack.isEmpty() && stacks.size > 1) {
            stacks.removeLast()
            stack = stacks.last()
            stack.pop()
        } else {
            if (stack.isEmpty()) throw EmptyStackException()
            stack.pop()
        }
    }

    // follow up
    // cannot assume that every stack is full, some of the stacks will be inherently empty
    // but another way is to keep shifting
    fun popAt(index: Int): Int {
        return stacks[index].pop()
    }
}

fun main() {
    val stacks = StackOfStacks(3)
    stacks.push(5)
    stacks.push(5)
    stacks.push(5)
    stacks.push(5)
    println(stacks.pop())
    println(stacks.pop())
    println(stacks.pop())
    println(stacks.pop())
    println(stacks.pop())
    println(stacks.pop())
}