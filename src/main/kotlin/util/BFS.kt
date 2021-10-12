package util

import java.util.*

//
//private var V // No. of vertices
//        = 0
//private var adj: Array<LinkedList<Int>> //Adjacency Lists
//
//
//// Constructor
//fun Graph(v: Int) {
//    V = v
//    adj = arrayOfNulls<LinkedList<*>>(v)
//    for (i in 0 until v) adj[i] = LinkedList<Any?>()
//}
//
//// Function to add an edge into the graph
//fun addEdge(v: Int, w: Int) {
//    adj[v].add(w)
//}
//
//// prints BFS traversal from a given source s
//fun BFS(s: Int) {
//    // Mark all the vertices as not visited(By default
//    // set as false)
//    var s = s
//    val visited = BooleanArray(V)
//
//    // Create a queue for BFS
//    val queue = LinkedList<Int>()
//
//    // Mark the current node as visited and enqueue it
//    visited[s] = true
//    queue.add(s)
//    while (queue.size != 0) {
//        // Dequeue a vertex from queue and print it
//        s = queue.poll()
//        print("$s ")
//
//        // Get all adjacent vertices of the dequeued vertex s
//        // If a adjacent has not been visited, then mark it
//        // visited and enqueue it
//        val i: Iterator<Int> = adj[s].listIterator()
//        while (i.hasNext()) {
//            val n = i.next()
//            if (!visited[n]) {
//                visited[n] = true
//                queue.add(n)
//            }
//        }
//    }
//}