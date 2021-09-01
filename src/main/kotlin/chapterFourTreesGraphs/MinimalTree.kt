package chapterFourTreesGraphs

fun minimalTree(array: List<Int>): Node? {
    if (array.isEmpty()) return null

    val middle = array.size / 2

    val root = Node(array[middle])
    val (left, right) = array.partition { i -> i < array[middle] }
    root.leftChild = minimalTree(left)
    root.rightChild = minimalTree(right.drop(1))

    return root
}

fun main() {
    val array = arrayListOf(1, 2, 3, 4, 5)
    inOrder(minimalTree(array))
}