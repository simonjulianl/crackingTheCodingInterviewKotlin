package chapterTenSearchingSorting

fun group(arr: Array<String>) {
    // functional method
    val test = arr.mapIndexed { index, s -> Pair(index, stringToMap(s)) }
        .groupBy { it.second }
        .map { list -> list.value.map { arr[it.first] }.toMutableList() }
        .reduce { acc, a ->
            acc.addAll(a)
            acc
        }

    println(test)

    // otherwise, do a bucket sort, use the hashmap of String to String where the first String is the sorted string
    // then just output based on the key
}

fun stringToMap(s: String): Map<Char, Int> {
    val map = mutableMapOf<Char, Int>()
    for (char in s) {
        map[char] = map.getOrDefault(char, 0) + 1
    }

    return map
}

fun main() {
    group(arrayOf("sua", "test", "ttes", "asu"))
}