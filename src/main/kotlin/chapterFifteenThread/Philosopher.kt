package chapterFifteenThread

class Philosopher(val left: Chopstick, val right: Chopstick) : Thread() {
    val BITES = 10

    fun eat() {
        pickUp()
        chew()
        putDown()
    }

    fun chew() {

    }

    fun pickUp() {
        left.pickUp()
        right.pickUp()
    }

    fun putDown() {
        left.putDown()
        right.putDown()
    }

    override fun run() {
        for (i in 0 until BITES) {
            eat()
        }
    }
}

fun main() {
    val thread = Philosopher(Chopstick(), Chopstick())
    thread.start()
}