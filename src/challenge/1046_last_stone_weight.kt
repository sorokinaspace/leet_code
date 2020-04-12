package challenge

import java.util.*

fun lastStoneWeight(stones: IntArray): Int {

    val queue: PriorityQueue<Int> = PriorityQueue(Collections.reverseOrder())
    queue.addAll(stones.toList())

    while (queue.isNotEmpty()) {
        val big = queue.poll()
        if (queue.isEmpty()) return big

        val small = queue.poll()
        if (big > small) queue.add(big - small)
    }

    return 0
}

fun main() {
    Test.assert(lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1)), 1)
    Test.assert(lastStoneWeight(intArrayOf(7, 5, 6, 9, 10, 5)), 0)
}