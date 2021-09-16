import java.util.*
import kotlin.collections.HashMap

val hashmap = HashMap<String, Int>()

fun populate(book: Array<String>) {
    for (word in book) {
        val processedWord = word.lowercase().trim()
        hashmap[processedWord] = hashmap.getOrDefault(processedWord, 0) + 1
    }
}

fun main() {
    val test = "test"
    println(hashmap[test.lowercase().trim()])
    println("testT saf   ".trimEnd())
}