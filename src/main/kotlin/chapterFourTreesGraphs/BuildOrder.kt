package chapterFourTreesGraphs

import java.util.*

class Project(var name: String) {
    enum class State { COMPLETE, PARTIAL, BLANK }

    private val map = hashMapOf<String, Project>()
    var state = State.BLANK

    // actually this is neighbours
    val children = ArrayList<Project>()

    fun addNeighbour(node: Project) {
        if (!map.containsKey(node.name)) {
            children.add(node)
            map[node.name] = node
        }
    }
}

class Graph {
    // list of vertices
    val nodes = ArrayList<Project>()

    // list of edges
    val map = hashMapOf<String, Project>()

    fun getOrCreateNode(name: String): Project {
        if (!map.containsKey(name)) {
            val newNode = Project(name)
            nodes.add(newNode)
            map[name] = newNode
        }

        return map[name]!!
    }

    fun addEdge(startName: String, endName: String) {
        val start = getOrCreateNode(startName)
        val end = getOrCreateNode(endName)
        start.addNeighbour(end)
    }
}

fun buildOrder(projects: List<String>, dependencies: List<Pair<String, String>>): Stack<Project>? {
    val graph = buildGraph(projects, dependencies)
    return orderProjects(graph.nodes)
}

fun orderProjects(nodes: ArrayList<Project>): Stack<Project>? {
    val stack = Stack<Project>()
    for (project in nodes) {
        // fresh, not visited node
        if (project.state == Project.State.BLANK) {
            if (!doDFS(project, stack)) {
                return null
            }
        }
    }

    return stack
}

fun doDFS(project: Project, stack: Stack<Project>): Boolean {
    // currently being traversed but being traversed again
    if (project.state == Project.State.PARTIAL) return false // cycle

    // fresh, not visited yet
    if (project.state == Project.State.BLANK) {
        project.state = Project.State.PARTIAL
        for (neighbour in project.children) {
            if (!doDFS(neighbour, stack)) return false
        }
        project.state = Project.State.COMPLETE
        stack.push(project)
    }

    return true
}

fun buildGraph(projects: List<String>, dependencies: List<Pair<String, String>>): Graph {
    val graph = Graph()
    for (project in projects) {
        graph.getOrCreateNode(project)
    }

    for (dependency in dependencies) {
        val first = dependency.first
        val second = dependency.second
        graph.addEdge(first, second)
    }

    return graph
}

fun main() {
    val project = listOf("a", "b", "c", "d", "e", "f")
    val dependency = listOf("a" to "d", "f" to "b", "b" to "d", "f" to "a", "d" to "c")
    val stack = buildOrder(project, dependency)
    while (stack!!.isNotEmpty()) {
        println(stack.pop().name)
    }
}
