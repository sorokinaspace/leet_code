package challenge_may_2020

import Test

fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val graph = Array(numCourses) { MutableList(0) { 0 } }
    val visited = BooleanArray(numCourses)
    val explored = BooleanArray(numCourses)

    fun isCyclic(u: Int): Boolean {
        visited[u] = true;
        for (v in graph[u]) {
            if (!visited[v]) {
                if (isCyclic(v)) {
                    return true
                }
            } else if (!explored[v]) {
                return true
            }
        }
        // explored all the adjacent vertices for vertex "u" and thus marking "u" as explored
        explored[u] = true;
        return false;
    }

    for (i in prerequisites.indices) {
        graph[prerequisites[i][0]].add(prerequisites[i][1])
    }

    for (i in 0 until numCourses) {
        if (!visited[i]) {
            if (isCyclic(i)) {
                return false
            }
        }
    }

    return true
}

fun main() {
    Test.assert(canFinish(2, arrayOf(intArrayOf(1, 0))))
    Test.assert(!canFinish(2, arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))))
}