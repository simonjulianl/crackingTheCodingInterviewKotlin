package chapterThreeStackQueue

import java.util.*

fun sortStack(stack: Stack<Int>) {
    if (stack.isEmpty()) return
    val addStack = Stack<Int>()

    val top = stack.pop()

    // mutation on stack
    sortStack(stack)

    while (!stack.isEmpty() && stack.peek() < top) {
        addStack.push(stack.pop())
    }

    stack.push(top)

    // return the second stack onto the correct stack
    while (!addStack.isEmpty()) {
        stack.push(addStack.pop())
    }
}

fun main() {
    val stack = Stack<Int>()
    stack.push(5)
    stack.push(3)
    stack.push(7)

    sortStack(stack)

    println(stack)
}