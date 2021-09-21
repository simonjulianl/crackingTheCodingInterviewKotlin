package chapterSixteenMedium

data class Node(var next: Node?, var data: Int, var prev: Node?)

class LruCache(val maxSize: Int) {
    private val map = HashMap<Int, Node>()
    private var listHead: Node? = null
    private var listTail: Node? = null

    fun getValue(key: Int): Int {
        val node = map[key] ?: return -1
        if (node != listHead) {
            removeFromLL(node)
            insertAtFrontLL(node)
        }

        return node.data
    }

    private fun removeFromLL(node: Node?) {
        node ?: return

        if (node.prev != null) node.prev!!.next = node.next
        if (node.next != null) node.next!!.prev = node.prev
        if (node == listTail) listTail = node.prev
        if (node == listHead) listHead = node.next
    }

    private fun insertAtFrontLL(node: Node) {
        if (listHead == null) {
            listHead = node
            listTail = node
        } else {
            listHead!!.prev = node
            node.next = listHead
            listHead = node
        }
    }

    fun removeKey(key: Int): Boolean {
        val node = map[key] ?: return false
        removeFromLL(node)
        map.remove(key)
        return true
    }

    fun setKeyValue(key: Int, data: Int) {
        removeKey(key)

        if (map.size >= 10 && listTail != null) {
            removeKey(listTail!!.data)
        }

        val newNode = Node(null, data, null)
        map[key] = newNode
        insertAtFrontLL(newNode)
    }
}