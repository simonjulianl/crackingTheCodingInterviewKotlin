package chapterFourTreesGraphs

// node somehow has a link to its parent
class NodeParent(val value: Int) {
    var left: NodeParent? = null
    var right: NodeParent? = null
    var parent: NodeParent? = null
}

fun successor(node: NodeParent): NodeParent? {
    var current: NodeParent?
    if (node.right != null) {
        current = node.right!!
        while (current!!.left != null) {
            current = current.left
        }
        return current
    }

    // current is null
    val parent = node.parent
    if (parent == null || node == parent.right) return null
    // else return parent
    return parent
}

fun main() {
    val root = NodeParent(5)
    val left = NodeParent(1)
    val right = NodeParent(10)

    root.left = left
    left.parent = root

    root.right = right
    right.parent = root

    println(successor(left)?.value)
}