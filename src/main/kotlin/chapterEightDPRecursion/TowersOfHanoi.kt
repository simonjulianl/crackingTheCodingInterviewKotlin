package chapterEightDPRecursion

import java.util.*

class Tower(private val index: Int) {
    private val stack = Stack<Int>()
    fun add(d: Int) {
        stack.add(d)
    }

    fun moveTopTo(t: Tower) {
        t.add(stack.pop())
    }

    override fun toString(): String {
        return stack.toString()
    }
}

fun solveTower(n: Int, origin: Tower, dest: Tower, buffer: Tower) {
    if (n <= 0) return
    solveTower(n - 1, origin, buffer, dest)
    origin.moveTopTo(dest)
    solveTower(n - 1, buffer, dest, origin)
}

fun main() {
    val n = 3;
    val tower: Array<Tower> = Array(3) { Tower(it) }
    (4 downTo 1).forEach {
        tower[0].add(it)
    }

    solveTower(4, tower[0], tower[2], tower[1])
    println(tower[2])
}