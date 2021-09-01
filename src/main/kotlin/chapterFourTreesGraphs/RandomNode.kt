package chapterFourTreesGraphs

import kotlin.random.Random

class Tree {
    val root: TreeNode? = null
    val size: Int
        get() = root?.size ?: 0

    fun getRandomNode(): TreeNode? {
        if (root == null) return null

        val random = Random.nextInt(size)
        return root.getIthNode(random)
    }
}

class TreeNode(var data: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    var parent: TreeNode? = null
    val isLeaf: Boolean
        get() = left == null && right == null

    var size = 1

    fun getIthNode(i: Int): TreeNode? {
        val leftSize = left?.size ?: 0
        return if (i < leftSize) {
            left?.getIthNode(i)
        } else if (i == leftSize) {
            this
        } else {
            right?.getIthNode(i)
        }
    }

    fun delete(i: Int) {
        this.size--

        // leaf, just remove it
        if (this.data == i) {
            // to be deleted
            if (isLeaf) {
                if (parent?.left == this) {
                    parent?.left = null
                } else {
                    parent?.right = null
                }
            } else if (right != null && left != null) {
                var current = right
                current!!.size--

                while (current!!.left != null) {
                    current = current.left
                    current!!.size--
                }
                this.data = current.data
            } else {
                if (parent?.left == this) {
                    if (left != null) {
                        parent?.left = left
                    } else {
                        parent?.right = right
                    }
                } else {
                    if (left != null) {
                        parent?.left = left
                    } else {
                        parent?.right = right
                    }
                }
            }
        } else {
            if (data > i) {
                right?.delete(i)
            } else {
                left?.delete(i)
            }
        }
    }

    fun insert(i: Int) {
        this.size++
        if (i <= this.data) {
            if (left == null) {
                left = TreeNode(i)
                left!!.parent = this
            } else {
                left!!.insert(i)
            }
        } else {
            if (right == null) {
                right = TreeNode(i)
                right!!.parent = this
            } else {
                right!!.insert(i)
            }
        }
    }

    fun find(i: Int): TreeNode? {
        if (i == data) {
            return this
        } else if (this.left != null && i < data) {
            return left!!.find(i)
        } else if (this.right != null && i > data) {
            return right!!.find(i)
        }

        return null
    }
}