package util

fun <V> List<V>.permutations(): List<List<V>> {
    val retVal: MutableList<List<V>> = mutableListOf()

    fun <V> swap(list: MutableList<V>, i: Int, i1: Int) {
        val temp = list[i]
        list[i] = list[i1]
        list[i1] = temp
    }

    fun generate(k: Int, list: MutableList<V>) {
        // If only 1 element, just output the array
        if (k == 1) {
            retVal.add(list.toList())
        } else {
            for (i in 0 until k) {
                generate(k - 1, list)
                if (k % 2 == 0) {
                    swap(list, i, k - 1)
                } else {
                    swap(list, 0, k - 1)
                }
            }
        }
    }

    generate(this.count(), this.toMutableList())
    return retVal
}