package chapterTenSearchingSorting

// avl tree ...
// in cpp they have a lib for that

class Node(val data: Int) {
    var left: Node? = null
    var right: Node? = null
    var rank = 1;

    fun insert(d: Int) {
        if (d > data) {
            if (right == null) {
                right = Node(d)
            } else {
                right!!.insert(d)
            }
        } else {
            rank++
            if (left == null) {
                left = Node(d)
            } else {
                left!!.insert(d)
            }
        }
    }

    fun getRank(d: Int): Int {
        if (d == data) return rank
        return if (d > data) {
            if (right == null) {
                -1
            } else {
                rank + right!!.getRank(d)
            }
        } else {
            if (left == null) {
                -1
            } else {
                left!!.getRank(d)
            }
        }
    }
}

fun main() {
    val root = Node(5)
    root.insert(10)
    root.insert(3)
    println(root.getRank(10))
}