package chapterSeventeenHard

// this uses trie so, not implemented here
// the idea here is taken from text book

//fun searchAll(big: String, smalls: List<String>) {
//    val lookup = hashMapOf<String, Int>()
//    val maxLen = big.length
//    TrieNode root = createTreeFromStrings(smalls, maxLen).root
//
//    for (i in 0 until maxLen) {
//        val strings = findStringsAtLoc(root, big, i)
//        strings.forEach {
//            lookup[it] = i
//        }
//    }
//}

//fun createTrieFromStrings(smalls: List<String>, maxLen: Int): Trie {
//    val trie = Trie("")
//    smalls.forEach {
//        if (it.length <= maxLen) {
//            tree.insertString(s, 0)
//        }
//    }
//
//    return trie
//}

//fun findStringsAtLoc(root: TrieNode, big: String, start: Int) {
//    val strings = arrayListOf<String>()
//    val index = start
//    while (index < big.length) {
//        root = root.getChild(big.charAt(index))
//        if (root == null) break
//        if (root.terminates()) strings.add(big.substring(add, index + 1))
//        index++
//    }
//
//    return strings
//}