package challenge

import java.util.*
import kotlin.collections.HashMap

class LRUCache(private val capacity: Int) {

    private val queue = LinkedList<Int>()
    private val map = HashMap<Int, Int>()

    fun get(key: Int): Int {
        val value = map.getOrDefault(key, -1)

        if (value != -1) {
            if (queue.contains(key)) {
                queue.remove(key)
                queue.add(key)
                println("get up=$value")
            } else {
                if (queue.size >= capacity) {
                    val removed = queue.poll()
                    println("get poll=$removed")
                }
                println("get add=$value")
                queue.contains(key)
            }
        }

        println("Get $value, queue = $queue")
        return value
    }

    fun put(key: Int, value: Int) {

        println("put [$key]=$value, capacity = $capacity, size = ${queue.size}")

        if (queue.contains(key)) {
            queue.remove(key)
            map.remove(key)
        } else if (queue.size >= capacity) {
            val removedKey = queue.poll()
            map.remove(removedKey)
        }

        queue.add(key)
        map[key] = value

        println("Put queue = $queue")
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */

fun main() {
    test1()
    test2()
}

private fun test2() {
    val cache = LRUCache(2 /* capacity */)
    Test.assert(cache.get(2), -1)
    cache.put(2, 6)
    Test.assert(cache.get(1), -1)
    cache.put(1, 5)
    cache.put(1, 2)
    Test.assert(cache.get(1), 2)
    Test.assert(cache.get(2), 6)
}

private fun test1() {
    val cache = LRUCache(2 /* capacity */)

    cache.put(1, 1)
    cache.put(2, 2)
    val get1 = cache.get(1) // returns 1
    Test.assert(get1, 1)

    cache.put(3, 3) // evicts key 2

    val get2 = cache.get(2) // returns -1 (not found)
    Test.assert(get2, -1)
    cache.put(4, 4) // evicts key 1

    val get3 = cache.get(1) // returns -1 (not found)
    Test.assert(get3, -1)
    val get4 = cache.get(3) // returns 3
    Test.assert(get4, 3)
    val get5 = cache.get(4) // returns 4
    Test.assert(get5, 4)
}