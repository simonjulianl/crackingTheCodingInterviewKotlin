package chapterFourTreesGraphs

import java.util.*

fun routeBetweenNode(adjList: List<List<Int>>, nodeA: Int, nodeB: Int): Boolean {
    // assume nodeA and B is inside the adjacency list
    val visited = BooleanArray(adjList.size) { false }
    visited[nodeA] = true

    val stack: Stack<Int> = Stack()
    stack.push(nodeA)

    while(stack.isNotEmpty()) {
        val top = stack.pop()
        if (top == nodeB) return true

        for (neighbour in adjList[top]) {
            if (!visited[neighbour]) {
                visited[neighbour] = true
                stack.push(neighbour)
            }
        }
    }

    return false
}

fun main() {
    println(routeBetweenNode(adjList, 4, 0))
}