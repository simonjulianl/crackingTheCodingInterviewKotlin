package chapterSixteenMedium

fun pairsWithSum(array: IntArray, target: Int) {
    val hashSet = hashSetOf<Int>()

    array.forEach {
        if (hashSet.contains(target - it)) {
            println("${target - it} $it")
        } else {
            hashSet.add(it)
        }
    }
}

fun main() {
    pairsWithSum(intArrayOf(1,2,3,4), 6)
}