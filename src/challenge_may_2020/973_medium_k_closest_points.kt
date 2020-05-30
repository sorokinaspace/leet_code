package challenge_may_2020

import java.util.*

fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {

    fun dist(point: IntArray): Int {
        return point[0] * point[0] + point[1] * point[1];
    }

    val dists = IntArray(points.size)
    for (i in points.indices) dists[i] = dist(points[i])

    Arrays.sort(dists)
    val distK = dists[K - 1]

    val ans = Array(K) { IntArray(2) }
    var t = 0
    for (i in points.indices) if (dist(points[i]) <= distK) ans[t++] = points[i]
    return ans
}

fun main() {
    Test.assert(kClosest(arrayOf(intArrayOf(1, 3), intArrayOf(-2, 2)), 1).contentDeepEquals(
            arrayOf(intArrayOf(-2, 2))
    ))
}