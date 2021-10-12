package util

fun findCombination() {
    val order = listOf(0, 1, 2, 3) // let the order by a -> 0, b -> 1, c -> 2, d -> 3
    val permutations = order.permutations()

    val allPossibleBits = generateAll4BitsPermutations()

    val toSearch = listOf(1, 4, 5, 6, 7, 13)
    for (individualOrder in permutations) {
        val bigger = arrayListOf<Int>()
        val equal = arrayListOf<Int>()
        val smaller = arrayListOf<Int>()

        for (item in allPossibleBits) {
            val firstString = Integer.parseInt(item[individualOrder[0]].toString() + item[individualOrder[1]], 2)
            val secondString = Integer.parseInt(item[individualOrder[2]].toString() + item[individualOrder[3]], 2)

            if (firstString > secondString) {
                bigger.add(Integer.parseInt(item, 2))
            }

            if (firstString == secondString) {
                equal.add(Integer.parseInt(item, 2))
            }

            if (firstString < secondString) {
                smaller.add(Integer.parseInt(item, 2))
            }
        }

        if (smaller == toSearch || bigger == toSearch || equal == toSearch) {
            println("order : $individualOrder")
            println("bigger $bigger")
            println("smaller $smaller")
            println("equal $equal \n")
        }
    }
}

fun generateAll4BitsPermutations(): ArrayList<String> {
    val array = arrayListOf<String>()
    val sb = StringBuilder()
    for (a in 0..1) {
        sb.append(a)
        for (b in 0..1) {
            sb.append(b)
            for (c in 0..1) {
                sb.append(c)
                for (d in 0..1) {
                    sb.append(d)
                    array.add(sb.toString())
                    sb.deleteAt(3)
                }
                sb.deleteAt(2)
            }
            sb.deleteAt(1)
        }
        sb.deleteAt(0)
    }

    return array
}

fun main() {
    findCombination()
}