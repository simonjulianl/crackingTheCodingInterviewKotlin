import java.util.*

private fun readLn() = readLine()!!
private fun readInt() = readLn().toInt()
private fun readStrings() = readLn().split(" ")
private fun readInts() = readStrings().map { it.toInt() }

class Node<T>(var value: T) {
    var next: Node<T>? = null
}

//const val modulo: Int = 1000000007

//fun main() {
//    val N = readLine()!!.toInt()
//    val hashmap = hashMapOf<Pair<Int, Int>, Int>()
//    // start, length
//    for (i in 0 until 5) {
//        hashmap[Pair(i, 0)] = 1
//    }
//    for (i in 1 until 1000000) {
//        for (j in 0 until 5) {
//            hashmap[Pair(j, i)] = 0
//            for (k in j until 5) {
//                hashmap[Pair(j, i)] = (hashmap[Pair(j, i)]!! % modulo + hashmap[Pair(k, i - 1)]!! % modulo) % modulo
//            }
//        }
//    }
//
//    for (i in 0 until N) {
//        val n = readLine()!!.toInt() - 1
//        var sum = 0
//        for (j in 0 until 5) {
//            sum = (sum + hashmap[Pair(j, n)]!!) % modulo
//        }
//        println(sum)
//    }
//}

fun main() {
    val queue: Deque<Int> = LinkedList()
}