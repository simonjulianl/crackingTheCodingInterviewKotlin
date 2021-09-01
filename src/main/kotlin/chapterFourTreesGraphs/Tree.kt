package chapterFourTreesGraphs

class Node(val value: Int) {
    var leftChild: Node? = null
    var rightChild: Node? = null
}

val adjList = List(6) { mutableListOf<Int>() }.apply {
    this[0].add(1)
    this[1].addAll(listOf(2, 3))
    this[2].add(3)
    this[3].add(4)

    // the last node 4 is terminating node
    // 0 -> 1 -> 2     5 <- solo node
    //      |   /
    //  4 <- 3
}

fun inOrder(node: Node?) {
    if (node == null) return
    inOrder(node.leftChild)
    println(node.value)
    inOrder(node.rightChild)
}

//fun dfs(node: Node<*>) {
//    if (node.visited) return
//    visit(node)
//    node.visited = true
//    for(neighbours of node)
//        if (neighbour not visited)
//            visit(neighbour)
//}

//fun dfsStack(node: Node<*>) {
//    val stack = Stack<Node>()
//    node.visited = true
//    stack.push(node)
//
//    while(stack not empty) {
//        val node = stack.pop()
//        for (neighbours of node) {
//            if (not visited node){
//                node.visited = true
//                stack.push(neighbour)
//            }
//        }
//    }
//}

//fun bfs(node: Node<*>) {
//    val queue = Queue<Node<T>>()
//    root.visited = true
//    queue.enqueue(root)
//
//    while(queue not empty) {
//        val node = queue.pop()
//        visit(node)
//        node.visited = true
//        for (neighbours of node) {
//            if (node not visited) {
//                node.visited = true
//                queue.enqueue(node)
//            }
//        }
//    }
//}

//
//fun main() {
//    val root = Node(5)
//    root.leftChild = Node(10)
//    root.rightChild = Node(15)
//
//    // inorder
//    inOrder(root)
//}