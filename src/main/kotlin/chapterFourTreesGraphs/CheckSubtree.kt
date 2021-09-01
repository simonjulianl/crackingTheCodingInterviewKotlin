package chapterFourTreesGraphs

fun preorderWithExtra(node: Node?): String {
    if (node == null) return "X"
    val string = StringBuilder()
    string.append(node.value)
    val leftString = preorderWithExtra(node.leftChild)
    val rightString = preorderWithExtra(node.rightChild)
    string.append(leftString)
    string.append(rightString)
    return string.toString()
}

fun checkSubtree(node: Node, node2: Node): Boolean {
    val preorder1 = preorderWithExtra(node)
    val preorder2 = preorderWithExtra(node2)

    // node2 < node size
    println(preorder1)
    println(preorder2)
    return preorder1.contains(preorder2)
}

fun main() {
    val root = Node(5)
    val left = Node(1)
    root.leftChild = left

    val right = Node(10)
    root.rightChild = right

    val root2 = Node(1)

    println(checkSubtree(root, root2))
}