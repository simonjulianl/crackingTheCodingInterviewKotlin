package util

val hashmap = HashMap<Pair<Int, Int>, Int>()

fun knapsack(weight: List<Int>, value: List<Int>, w: Int, n: Int): Int {
    if (w == 0 || n == 0) return 0
    if (hashmap.containsKey(Pair(n, w))) {
        return hashmap[Pair(n, w)]!!
    }

    return if (weight[n - 1] <= w) {
        // if less, we can either choose or ignore
        val v = Math.max(
            knapsack(weight, value, w, n - 1),
            value[n - 1] + knapsack(weight, value, w - weight[n - 1], n - 1)
        )
        hashmap[Pair(n, w)] = v
        v
    } else {
        val v = knapsack(weight, value, w - weight[n - 1], n - 1)
        hashmap[Pair(n, w)] = v
        v
    }
}

// given a list e.g. {1,2,3,4,5} and an int sum, determine whether there is any combi such that the sum can be achieved (by summing some of them)
val hashmapTwo = HashMap<Pair<Int, Int>, Boolean>()

fun modifiedKnapsack(list: List<Int>, weight: Int, n: Int): Boolean {
    if (weight == 0 && n >= 0) return true
    if (n <= 0 && weight != 0) return false

    if (hashmapTwo.containsKey(Pair(weight, n))) {
        return hashmapTwo[Pair(weight, n)]!!
    }

    return if (list[n - 1] <= weight) {
        val v = modifiedKnapsack(list, weight - list[n - 1], n - 1) || modifiedKnapsack(list, weight, n - 1)
        hashmapTwo[Pair(n, weight)] = v
        v
    } else {
        val v = modifiedKnapsack(list, weight, n - 1)
        hashmapTwo[Pair(n, weight)] = v
        v
    }
}


fun main() {
    println(knapsack(listOf(10, 20, 30), listOf(60, 100, 120), 50, 3))
    println(modifiedKnapsack(listOf(1,2,3,4), 5, 4));
}