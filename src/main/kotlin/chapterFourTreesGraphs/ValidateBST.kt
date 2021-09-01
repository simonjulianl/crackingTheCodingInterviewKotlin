package chapterFourTreesGraphs

fun validateBST(node: Node?): Boolean {
    if (node == null) return true
    return validateBST(node.leftChild)
            && validateBST(node.rightChild)
            && node.value <= (node.rightChild?.value ?: Int.MAX_VALUE)
            && node.value >= (node.leftChild?.value ?: Int.MIN_VALUE)
}

fun main() {
    val array = arrayListOf(1, 2, 3, 4, 5)
    val tree = minimalTree(array)
    println(validateBST(tree))
}