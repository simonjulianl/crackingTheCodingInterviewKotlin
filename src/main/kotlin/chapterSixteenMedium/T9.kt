package chapterSixteenMedium

// answer
fun getValidWords(numbers: String, dict: HashMap<String, ArrayList<String>>): ArrayList<String>? {
    return dict[numbers]
}

fun convertToT9(word: String, letterToNumberMap: HashMap<Char, Char>): String {
    val sb = StringBuilder()
    for (char in word) {
        if (letterToNumberMap.containsKey(char)) {
            val digit = letterToNumberMap[char]
            sb.append(digit)
        }
    }
    return sb.toString()
}

fun createLetterToNumberMap(): HashMap<Char, Char> {
    val hashmap = HashMap<Char, Char>()
    val t9letters = arrayOf(
        charArrayOf('~'),
        charArrayOf('a','b','c')
    )
    for (i in t9letters.indices) {
        val letters = t9letters[i]

        for(letter in letters) {
            val c = Character.forDigit(i, 10)
            hashmap[letter] = c
        }
    }

    return hashmap
}

fun initDict(words: Array<String>): HashMap<String, ArrayList<String>> {
    val letterToNumberMap = createLetterToNumberMap()

    val wordToNumber = HashMap<String, ArrayList<String>>()
    words.forEach { word ->
        val numbers = convertToT9(word, letterToNumberMap)

        if (wordToNumber[numbers] == null) {
            wordToNumber[numbers] = arrayListOf()
        }

        wordToNumber[numbers]!!.add(word)
    }

    return wordToNumber
}