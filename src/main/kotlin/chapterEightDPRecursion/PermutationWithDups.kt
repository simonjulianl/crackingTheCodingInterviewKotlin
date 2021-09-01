package chapterEightDPRecursion

fun printPerms(s: String): ArrayList<String> {
    val result = ArrayList<String>()
    val map: HashMap<Char, Int> = buildFreqTable(s)
    printPerms(map, "", s.length, result)
    return result
}

fun buildFreqTable(s: String): HashMap<Char, Int> {
    val map = HashMap<Char, Int>()
    for (c in s.toCharArray()) {
        if (!map.containsKey(c)) {
            map[c] = 0
        }
        map[c] = map[c]!! + 1
    }
    return map
}

fun printPerms(map: HashMap<Char, Int>, prefix: String, remaining: Int, result: ArrayList<String>) {
    if (remaining == 0) {
        result.add(prefix)
        return
    }

    for (c in map.keys) {
        val count = map[c] ?: 0
        if (count > 0) {
            map[c] = count - 1
            printPerms(map, prefix + c, remaining - 1, result)
            map[c] = count
        }
    }
}

fun main() {
    println(printPerms("tt"))
}
