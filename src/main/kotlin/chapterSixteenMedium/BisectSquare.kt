package chapterSixteenMedium

data class Square(val side: Int, val x: Int, val y: Int)
data class Line(val m: Double, val c: Double)

fun getLineDividesSquares(a: Square, b: Square): Line {
    val m: Double = (b.y - a.y).toDouble() / (b.x - a.x)
    val c: Double = b.y - b.x * m

    return Line(m, c)
}

fun main() {
    val square1 = Square(5, 10, 10)
    val square2 = Square(10, 20, 20)

    println(getLineDividesSquares(square1, square2))
}