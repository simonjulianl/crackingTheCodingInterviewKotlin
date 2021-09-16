package chapterSixteenMedium

data class Point(val x: Int, val y: Int)

fun intersect(origin1: Point, end1: Point, origin2: Point, end2: Point): Boolean {
    val m1 = (end1.y - origin1.y).toDouble() / (end1.x - origin1.x)

    val m2 = (end2.y - origin2.y).toDouble() / (end2.x - origin2.x)

    // same gradient, cannot intersect
    if (m1 == m2) return false;

    // calculate the point of intersection
    val c1 = origin1.y - m1 * origin1.x
    val c2 = origin2.y - m2 * origin2.x

    val xAns = (c2 - c1) / (m1 - m2);

    // check within line1 range
    if (origin1.x > xAns || xAns > end1.x) return false

    // check within line2 range
    if (origin2.x > xAns || xAns > end2.x) return false

    return true
}

fun main() {
    val origin = Point(0, 0)
    val dest = Point(5, 5)

    val origin2 = Point(0, 5)
    val dest2 = Point(5, 0)

    println(intersect(origin, dest, origin2, dest2))
}