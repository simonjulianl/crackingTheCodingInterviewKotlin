package chapterFourTreesGraphs

fun countPathsWithSum(node: TreeNode?, targetSum: Int, runningSum: Int, pathCount: HashMap<Int, Int>): Int {
    if (node == null) return 0

    val sum = node.data + runningSum
    val difference = sum - targetSum
    var totalPaths = pathCount.getOrDefault(difference, 0)

    if (sum == targetSum) totalPaths++
    pathCount[sum] = pathCount.getOrDefault(sum,1)
    totalPaths += countPathsWithSum(node.left, targetSum, sum, pathCount)
    totalPaths += countPathsWithSum(node.right, targetSum, sum, pathCount)
    pathCount[sum]?.minus(1)

    return totalPaths
}

fun main() {
    val node = TreeNode(5)
    node.left = TreeNode(10)
    node.right = TreeNode(15)

    println(countPathsWithSum(node, 15, 0, hashMapOf()))
}