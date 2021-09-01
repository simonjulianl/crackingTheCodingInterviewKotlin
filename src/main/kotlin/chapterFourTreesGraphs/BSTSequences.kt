package chapterFourTreesGraphs

fun bstsequences(node: Node?): List<List<Int>> {
    val finalList = ArrayList<List<Int>>()

    if (node == null) {
        finalList.add(listOf())
        return finalList
    }

    var leftList: List<List<Int>>
    var rightList: List<List<Int>>

    node.leftChild.let {
        leftList = bstsequences(it)
    }

    node.rightChild.let {
        rightList = bstsequences(it)
    }

    for (firstArray in leftList) {
        for(secondArray in rightList) {
            val weaved = weave(firstArray, secondArray).map {
                listOf(node.value, *it.toTypedArray())
            }
            finalList.addAll(weaved)
        }
    }

    return finalList
}

fun weave(first: List<Int>, second: List<Int>): List<List<Int>> {
    if (first.isEmpty()) return listOf(second)
    if (second.isEmpty()) return listOf(first)

    val result = ArrayList<List<Int>>()

    val firstChar = first.first()
    val firstList = first.subList(1, first.size)

    var weaved = weave(firstList, second)
    for (list in weaved) {
        result.add(listOf(firstChar, *list.toTypedArray()))
    }

    val secondChar = second.first()
    val secondList = second.subList(1, second.size)
    weaved = weave(first, secondList)
    for (list in weaved) {
        result.add(listOf(secondChar, *list.toTypedArray()))
    }

    return result
}

fun main() {
    val root = Node(5)
    val left = Node(1)
    val right = Node(3)

    root.leftChild = left
    root.rightChild = right

    val result = weave(listOf(1,2), listOf(3))
    println(result.size)
    println(bstsequences(root).size)
}