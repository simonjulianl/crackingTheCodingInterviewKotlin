package chapterFiveBitManipulation

fun debugger(n: Int): Boolean {
    // its means that n is the power of 2
    return (n and (n - 1)) == 0
}

fun main() {
    debugger(100)
    // because it will be 0 only if 1 0000.. and 0 111...1, otherwise if there is more than 1, the other one will stay and the result wont be zero
}