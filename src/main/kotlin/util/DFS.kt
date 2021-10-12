package util

//fun DFSUtil(v: Int, visited: BooleanArray) {
//    // Mark the current node as visited and print it
//    visited[v] = true
//    print("$v ")
//
//    // Recur for all the vertices adjacent to this
//    // vertex
//    val i: Iterator<Int> = adj.get(v).listIterator()
//    while (i.hasNext()) {
//        val n = i.next()
//        if (!visited[n]) DFSUtil(n, visited)
//    }
//}