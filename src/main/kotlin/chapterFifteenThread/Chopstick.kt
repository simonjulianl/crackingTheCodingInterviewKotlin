package chapterFifteenThread

import java.util.concurrent.locks.ReentrantLock

class Chopstick {
    private val lock = ReentrantLock();

    fun pickUp() {
        lock.lock()
    }

    fun putDown() {
        lock.unlock()
    }
}
