package challenge_may_2020

import Test

fun possibleBipartition(N: Int, dislikes: Array<IntArray>): Boolean {
    val graph = Array(N + 1) {
        MutableList(0) { 0 }
    }
    val color = mutableMapOf<Int, Int>()

    fun dfs(node: Int, c: Int): Boolean {
        if (color.containsKey(node)) return color[node] == c
        color[node] = c
        for (nei in graph[node]) if (!dfs(nei, c xor 1)) return false
        return true
    }

    for (edge in dislikes) {
        if (edge.isEmpty()) continue
        graph[edge[0]].add(edge[1])
        graph[edge[1]].add(edge[0])
    }
    for (node in 1..N) if (!color.containsKey(node) && !dfs(node, 0)) return false
    return true
}

fun main() {
    Test.assert(possibleBipartition(4, arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(2, 4)
    )))
    Test.assert(!possibleBipartition(4, arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(2, 3)
    )))
    Test.assert(possibleBipartition(1, arrayOf(
            intArrayOf()
    )))
    Test.assert(!possibleBipartition(5, arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4),
            intArrayOf(4, 5),
            intArrayOf(3, 5)
    )))
}