package chapterSeventeenHard

data class ParseResult(var result: Int, var string: String)

fun split(dict: HashSet<String>, sentence: String, start: Int, memo: Array<ParseResult?>): ParseResult {
    if (start >= sentence.length) {
        return ParseResult(0, "")
    }

    if (memo[start] != null) {
        return memo[start]!!
    }

    var bestInvalid = Int.MAX_VALUE
    var bestParsing = ""
    var partial = ""
    var index = start

    while (index < sentence.length) {
        val c = sentence[index]
        partial += c
        val invalid = if(dict.contains(partial)) 0 else partial.length
        if (invalid < bestInvalid) {
            val result = split(dict, sentence, index + 1, memo)
            if (invalid + result.result < bestInvalid) {
                bestParsing = partial + " " + result.string
                bestInvalid = invalid + result.result
                if (bestInvalid == 0) break
            }
        }
        index++
    }

    memo[start] = ParseResult(bestInvalid, bestParsing)
    return memo[start]!!
}

fun main() {
    val sentence = "trying"
    val map = Array<ParseResult?>(sentence.length) { null }
}