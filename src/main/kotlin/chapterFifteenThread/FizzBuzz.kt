package chapterFifteenThread

private val lock = Object()

class FBThread(
    val validate: (x: Int) -> Boolean,
    val printer: (x: Int) -> Unit
) : Thread() {
    private val max = 100
    var current = 1

    override fun run() {
        while (true) {
            synchronized(lock) {
                if (current > max) {
                    return
                }

                if (validate(current)) {
                    printer(current)
                }

                current++
            }
        }
    }
}

fun main() {
    val threads = listOf<Thread>(
        FBThread({ x -> x % 3 == 0 && x % 5 == 0 }, { x -> println("FizzBuzz") }),
        FBThread({ x -> x % 3 == 0 && x % 5 != 0 }, { x -> println("Fizz") }),
        FBThread({ x -> x % 3 != 0 && x % 5 == 0 }, { x -> println("Buzz") }),
        FBThread({ x -> x % 3 != 0 && x % 5 != 0 }, { x -> println(x) })
    )

    threads.forEach { it.start() }
}