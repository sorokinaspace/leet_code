package challenge

// Similar - LRU Cache
class FirstUnique(nums: IntArray) {

    private val map = linkedMapOf<Int, Int>()

    init {
        nums.forEach {
            add(it)
        }
    }

    fun showFirstUnique(): Int {
        for ((t, u) in map) {
            if (u == 1) return t
        }
        return -1
    }

    fun add(value: Int) {
        val counter = map[value]?.run { this + 1 } ?: 1
        map[value] = counter
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * var obj = FirstUnique(nums)
 * var param_1 = obj.showFirstUnique()
 * obj.add(value)
 */

fun main() {
    val firstUnique = FirstUnique(intArrayOf(2, 3, 5))
    Test.assert(firstUnique.showFirstUnique(), 2) // return 2
    firstUnique.add(5)            // the queue is now [2,3,5,5]
    Test.assert(firstUnique.showFirstUnique(), 2) // return 2
    firstUnique.add(2)            // the queue is now [2,3,5,5,2]
    Test.assert(firstUnique.showFirstUnique(), 3) // return 3
    firstUnique.add(3)            // the queue is now [2,3,5,5,2,3]
    Test.assert(firstUnique.showFirstUnique(), -1) // return -1
}