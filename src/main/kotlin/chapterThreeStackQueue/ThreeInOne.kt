package chapterThreeStackQueue

// simple fix division
class FixedMultiStack(private val stackSize: Int) {
    private val array = IntArray(stackSize * 3) { 0 }
    private val sizes = IntArray(3) { 0 }

    fun push(stackNum: Int, value: Int) {
        if (isFull(stackNum)) throw FullStackException("full")
        array[stackSize * stackNum + sizes[stackNum]] = value
        sizes[stackNum]++
    }

    fun pop(stackNum: Int): Int {
        if (isEmpty(stackNum)) throw FullStackException("empty")
        sizes[stackNum]--
        val index = stackSize * stackNum + sizes[stackNum]
        return array[index].also {
            array[index] = 0
        }
    }

    fun peek(stackNum: Int): Int {
        if (isEmpty(stackNum)) throw FullStackException("empty")
        val index = stackSize * stackNum + sizes[stackNum] - 1
        return array[index]
    }

    private fun isEmpty(stackNum: Int): Boolean = sizes[stackNum - 1] == 0

    private fun isFull(stackNum: Int): Boolean = sizes[stackNum - 1] == (stackSize - 1)
}

class FullStackException(message: String) : Exception(message)

fun main() {
    val test = IntArray(100)
    println(test[0])
}