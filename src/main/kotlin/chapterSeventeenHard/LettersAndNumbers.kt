package chapterSeventeenHard

fun letterAndNumbers(list: List<Char>): Pair<Int, Int> {
    var cumNum = 0
    var cumLetter = 0

    // hashmap of difference to starting index, end index
    val hashmap = HashMap<Int, Pair<Int, Int>>()
    var ans = Pair(0, 0)
    list.forEachIndexed { index, it ->
        if (it.isDigit()) {
            cumNum++
        } else {
            cumLetter++
        }

        val diff = cumNum - cumLetter
        if (hashmap.containsKey(diff)) {
            hashmap[diff] = Pair(hashmap[diff]!!.first, index)
            val difference = index - hashmap[diff]!!.first
            if (difference > (ans.second - ans.first)) {
                ans = Pair(hashmap[diff]!!.first, index)
            }
        } else {
            hashmap[diff] = Pair(index, index)
        }
    }

    return ans
}

fun main() {
    println(letterAndNumbers(listOf('1','a','1','2','a','b','3','3','4')))
}
