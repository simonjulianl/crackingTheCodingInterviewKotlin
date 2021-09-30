package util

fun subset(list: MutableList<Int>): MutableList<List<Int>> {
    if (list.isEmpty()) {
        return listOf<List<Int>>(emptyList()).toMutableList()
    }

    val rest = subset(list.slice(1 until list.size).toMutableList())
    val current = list[0]
    val restCopy = rest.toMutableList()
    val newCopy = restCopy.map {
        val new = it.toMutableList()
        new.add(0, current)
        new
    }
    rest.addAll(newCopy)
    return rest
}

fun main() {
    println(subset(mutableListOf(1, 2, 3)))
}