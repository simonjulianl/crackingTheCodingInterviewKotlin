package chapterSeventeenHard

data class BiNode(val value: Int, var left: BiNode? = null, var right: BiNode? = null)

fun convertBstToLL(root: BiNode): BiNode {
    if (root.right == null && root.left == null || root.left == root)  {
        root.left = root
        root.right = root
        return root
    } // leaf

    var head: BiNode = root

    val rightLeftover = root.right

    if (root.left != null) {
        val left = convertBstToLL(root.left!!)

        val tailLeft = left.left!!

        // circular linked list
        tailLeft.right = root
        root.left = tailLeft

        root.right = left
        left.left = root

        head = left
    }

    if (rightLeftover != null) {
        val right = convertBstToLL(rightLeftover)
        val rightTail= right.left!!

        right.left = root
        root.right = right

        head.left = rightTail
        rightTail.left = head
    }

    return head
}

fun main() {
    val one = BiNode(1)
    val two = BiNode(2)
    val three = BiNode(3)
    val five = BiNode(5)
    val seven = BiNode(7)
    val eight = BiNode(8)

    two.left = one
    three.left = two
    three.right = seven
    seven.left = five
    seven.right = eight

    // root is three
    var test: BiNode? = convertBstToLL(three)

    val last = test!!.left!!
    last.right = null
    test.left = null

    while (test != null) {
        println(test.value)
        test = test.right
    }
}