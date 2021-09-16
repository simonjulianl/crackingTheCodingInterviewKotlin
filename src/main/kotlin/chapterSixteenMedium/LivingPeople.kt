package chapterSixteenMedium

data class People(val birth: Int, val death: Int)

fun livingPeople(list: List<People>) {
    val array = Array(101) { Pair(0, 0) }

    list.forEach {
        array[it.birth] = Pair(array[it.birth].first + 1, array[it.birth].second)
        array[it.death] = Pair(array[it.death].first, array[it.death].second + 1)
    }

    var current = 0
    var ans = Pair(0, 0) // year, people
    array.forEachIndexed { index, pair ->
        current += pair.first
        if (current > ans.second) {
            ans = Pair(index, current)
        }
        current -= pair.second
    }

    println(ans)
}

fun main() {
    livingPeople(listOf(People(15, 99), People(20, 99)))
}