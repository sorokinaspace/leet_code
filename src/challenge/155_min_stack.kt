package challenge

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
class MinStack {

    /** initialize your data structure here. */
    private data class Node(val `val`: Int, val min: Int, var next: Node?) {
        override fun toString(): String {
            return "$`val`($min) ${if (next != null) " -> $next" else ""}"
        }
    }

    private var node: Node? = null

    fun push(x: Int) {
        val min = node?.run { if (min > x) x else min } ?: x
        node = Node(x, min, node)
    }

    fun pop() {
        node = node?.next
    }

    fun top(): Int {
        return node?.`val` ?: 0
    }

    fun getMin(): Int {
        return node?.min ?: 0
    }

    override fun toString(): String {
        return node?.toString().orEmpty()
    }
}

fun main() {
    val obj = MinStack()
    obj.push(-2)
    println("Push -2: $obj")
    obj.push(0)
    println("Push 0: $obj")
    obj.push(-1)
    println("Push -1: $obj")
    val min = obj.getMin()
    println("Min: $min")

    Test.assert(min, -2)
}