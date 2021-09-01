package chapterEightDPRecursion

fun coinfun(n: Int, coins: ArrayList<Int>, memo: HashMap<Int, Int>): Int {
    if (coins.isEmpty()) return 0
    if (n == 0) return 1

    val result = memo.getOrDefault(n, -1)
    if (result != -1) return result

    val currentCoin = coins.first()
    val common = coinfun(n, ArrayList(coins.slice(1 until coins.size)), memo)
    return if (n >= currentCoin) {
        val current = coinfun(n - currentCoin, coins, memo) + common
        memo[n] = current
        current
    } else {
        memo[n] = common
        common
    }
}

fun main() {
    println(coinfun(5, arrayListOf(50, 25, 5, 1), hashMapOf()))
}