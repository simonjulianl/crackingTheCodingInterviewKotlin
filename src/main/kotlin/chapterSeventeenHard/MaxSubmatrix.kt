package chapterSeventeenHard

fun maxSumArray(array: Array<IntArray>): Array<Array<Int>> {
    val sumMatrix = Array(array.size) { Array(array.size) { 0 } }
    val length = array.size
    for (r in 0 until length) {
        for (c in 0 until length) {
            var sum = array[r][c]
            if (c - 1 >= 0) {
                sum += sumMatrix[r][c - 1]
            }
            if (r - 1 >= 0) {
                sum += sumMatrix[r - 1][c]
            }

            if (c - 1 >= 0 && r - 1 >= 0) {
                sum -= sumMatrix[r - 1][c - 1]
            }
            sumMatrix[r][c] = sum
        }
    }

    sumMatrix.forEach { println(it.toList()) }
    return sumMatrix
}

fun findMaxSubMatrix(processed: Array<Array<Int>>): Int {
    val length = processed.size
    var max = 0
    for (r1 in 0 until length) {
        for (c1 in 0 until length) {
            for (r2 in r1 until length) {
                for (c2 in c1 until length) {
                    val tempSum = processed[r2][c2] + processed[r1][c1] - processed[r2][c1] - processed[r1][c2]
                    if (tempSum > max) max = tempSum
                }
            }
        }
    }

    for (r in 0 until length) {
        for (c in 0 until length) {
            val tempSum = processed[r][c]
            if (tempSum > max) {
                max = tempSum
            }
        }
    }

    return max
}

fun efficientMaxSubArray(array: Array<IntArray>) {
    var sum = Pair(Pair(0, 0), Pair(0, 0))
    var totalSum = 0
    for (rowStart in array.indices) {
        val partialSum = IntArray(array.size)
        for (rowEnd in rowStart until array.size) {
            val rows = Pair(rowStart, rowEnd)
            for (col in array.indices) {
                partialSum[col] += array[rowEnd][col]
            }

            val cols = maxSubArray(partialSum)
            var tempSum = 0
            for (i in cols.first..cols.second) {
                tempSum += partialSum[i]
            }
            if (tempSum > totalSum) {
                totalSum = tempSum
                sum = Pair(rows, cols)
            }
        }
    }

    println(sum)
    println(totalSum)
}

fun maxSubArray(array: IntArray): Pair<Int, Int> {
    var startIndex = 0
    var endIndex = 0
    var currentSum = 0

    var bestCurrentIndex = Pair(startIndex, endIndex)
    var bestSum = 0

    for (i in array.indices) {
        if (currentSum == 0) {
            startIndex = i
            endIndex = i
        }
        currentSum += array[i]
        if (currentSum > bestSum) {
            bestSum = currentSum
            bestCurrentIndex = Pair(startIndex, endIndex)
        }

        if (currentSum < 0) {
            currentSum = 0
        } else {
            endIndex++
        }
    }

    return bestCurrentIndex
}

fun main() {
    val matrix = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
    println(findMaxSubMatrix(maxSumArray(matrix)))
    println(maxSubArray(intArrayOf(1, -1, 2, -4, 5, 6)))
    efficientMaxSubArray(matrix)
}