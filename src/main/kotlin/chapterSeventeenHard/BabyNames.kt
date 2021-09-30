package chapterSeventeenHard

data class Node(var freq: Int = 0, var neighbours: ArrayList<Node> = arrayListOf(), var isVisited: Boolean = false)

fun babyNames(list: List<Pair<String, Int>>, synonym: List<Pair<String, String>>) {
    val hashmap = HashMap<String, Node>()
    synonym.forEach { (first, second) ->
        if (!hashmap.containsKey(first)) {
            hashmap[first] = Node()
        }

        if (!hashmap.containsKey(second)) {
            hashmap[second] = Node()
        }

        hashmap[first]!!.neighbours.add(hashmap[second]!!)
        hashmap[second]!!.neighbours.add(hashmap[first]!!)
    }

    list.forEach { (name, freq) ->
        hashmap[name]!!.freq = freq
    }

    hashmap.entries.forEach { (name, node) ->
        if (!node.isVisited) {
            println("$name ${dfs(node)}")
        }
    }
}

fun dfs(node: Node): Int {
    if (node.isVisited) return 0

    var answer = node.freq
    node.isVisited = true

    node.neighbours.forEach {
        if (!it.isVisited) {
            answer += dfs(it)
        }
    }

    return answer
}

fun main() {
    val synonym = listOf(Pair("S", "A"))
    val names = listOf(Pair("S", 10), Pair("A", 100))
    babyNames(names, synonym)
}