import java.util.*
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock
import kotlin.math.absoluteValue

private fun readLn() = readLine()!!
private fun readInt() = readLn().toInt()
private fun readStrings() = readLn().split(" ")
private fun readInts() = readStrings().map { it.toInt() }

class Node<T>(var value: T) {
    var next: Node<T>? = null
}



fun main(args: Array<String>) {
    val lock = ReentrantLock()
}