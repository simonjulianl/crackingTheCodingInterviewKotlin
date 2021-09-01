package chapterThreeStackQueue

import java.util.*

sealed class Animal(var tag: Int)
class Dog(tag: Int = 0) : Animal(tag)
class Cat(tag: Int = 0) : Animal(tag)

class AnimalShelter {
    private var counter = 1
    private val dogQueue: Queue<Dog> = LinkedList()
    private val catQueue: Queue<Cat> = LinkedList()

    fun enqueue(animal: Animal) {
        animal.tag = counter
        counter++

        when (animal) {
            is Dog -> dogQueue.add(animal)
            is Cat -> catQueue.add(animal)
        }
    }

    fun dequeueAny(): Animal {
        return if (dogQueue.peek().tag > catQueue.peek().tag) {
            catQueue.poll()
        } else {
            dogQueue.poll()
        }
    }

    fun dequeueCat(): Cat {
        return catQueue.poll()
    }

    fun dequeueDog(): Dog {
        return dogQueue.poll()
    }
}

fun main() {
    val shelter = AnimalShelter()
    shelter.enqueue(Dog())
    println(shelter.dequeueCat())
}