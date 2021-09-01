package chapterOneArrayString

fun rotateMatrix(matrix: Array<IntArray>): Array<IntArray> {
    // matrix size (since its n x n)
    val n = matrix.size
    if (n == 0 || n != matrix[0].size) return matrix// not a square matrix or null matrix
    // actually i think for matrix you can transpose and then do y reflection
    // but its still O(n^2)
    for (layer in 0 until n / 2) {
        val first = layer
        val last = n - 1 - layer
        for (i in first until last) {
            val top = matrix[first][i]

            // left -> top
            matrix[first][i] = matrix[n - 1 - i][first]

            // bottom -> left
            matrix[n - 1 - i][first] = matrix[last][n - 1 - i]

            // right -> bottom
            matrix[last][n - 1 - i] = matrix[i][last]

            // temp -> right
            matrix[i][last] = top
        }
    }
    return matrix
}
