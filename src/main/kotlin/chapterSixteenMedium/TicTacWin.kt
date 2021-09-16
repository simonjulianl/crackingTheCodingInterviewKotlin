package chapterSixteenMedium

// modified to given current position in tictactoe, give who is the winner
// -1 for first player, 0 for tie, 1 for second player
// 0 is player1 -> x, 1 is player2 -> o
fun determineValue(board: CharArray, player: Boolean): Int {
    val dummyCounter = board.count { it == 'd' }
    if (dummyCounter == 0) {
        return checkValue(board)
    }

    // player 1 is x, so maximizing player
    if (player) {
        var bestVal = Integer.MIN_VALUE
        for (i in 0 until 9) {
            if (board[i] == 'd') {
                board[i] = 'x'
                val possibleValue = determineValue(board, !player)
                bestVal = bestVal.coerceAtLeast(possibleValue)
                board[i] = 'd'
            }
        }

        return bestVal;
    } else {
        var bestVal = Integer.MAX_VALUE
        for (i in 0 until 9) {
            if (board[i] == 'd') {
                board[i] = 'o'
                val possibleValue = determineValue(board, !player)
                bestVal = bestVal.coerceAtMost(possibleValue)
                board[i] = 'd'
            }
        }

        return bestVal;
    }
}

// when the board is full
fun checkValue(board: CharArray): Int {
    // 0 1 2
    // 3 4 5
    // 6 7 8
    val position = listOf(
        Triple(0, 1, 2), // row
        Triple(3, 4, 5),
        Triple(6, 7, 8),
        Triple(0, 3, 6), // col
        Triple(1, 4, 7),
        Triple(2, 5, 8),
        Triple(0, 4, 8), // diag
        Triple(6, 4, 2),
    )

    for ((x, y, z) in position) {
        val char = board[x];
        if (board[x] == board[y] && board[y] == board[z]) {
            return if (char == 'x') 1 else -1
        }
    }
    return 0;
}

fun main() {
    val emptyBoard = CharArray(9) { 'd' }
    println(determineValue(emptyBoard, true))
}