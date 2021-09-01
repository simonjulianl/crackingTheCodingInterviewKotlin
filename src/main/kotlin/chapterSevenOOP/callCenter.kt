package chapterSevenOOP

import java.util.*

class Call(val caller: String)

class MyComp : Comparator<Employee> {
    override fun compare(o1: Employee, o2: Employee): Int {
        return o1.isAvailable.compareTo(o2.isAvailable)
    }
}

sealed class Employee(var isAvailable: Boolean = false)
class Respondent : Employee()
class Manager : Employee()
class Director : Employee()

class CallCenter {
    val employees = Array<List<Employee>>(3) { mutableListOf() }
    private val queue = Array<PriorityQueue<Employee>>(3) { PriorityQueue(MyComp()) }

    fun dispatchCall(call: Call): Boolean {
        for (q in queue) {
            val employee = q.peek()
            if (!employee.isAvailable) {
                continue
            } else {
                employee.isAvailable = false
                return true
            }
        }

        return false
    }
}
