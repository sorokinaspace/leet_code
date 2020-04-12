package challenge

import common.ListNode

fun middleNode(head: ListNode?): ListNode? {

    println("Input $head")

    var count = 0
    var middleIndex = 0
    var middle = head
    var currentNode = head

    while (currentNode != null) {
        count++
        val nextMiddleIndex = count / 2

        println("Count $count, middle index $middleIndex, next middle index $nextMiddleIndex")

        for (i in middleIndex until nextMiddleIndex) {
            middle = middle?.next
            println("moved to ${middle?.`val`}")
        }

        middleIndex = nextMiddleIndex
        currentNode = currentNode.next
    }

    return middle
}

fun main() {
    Test.assert(middleNode(ListNode.fromList(listOf(1, 2, 3, 4, 5)))?.`val`, 3)
    Test.assert(middleNode(ListNode.fromList(listOf(1)))?.`val`, 1)
    Test.assert(middleNode(ListNode.fromList(listOf(1, 2)))?.`val`, 2)
    Test.assert(middleNode(ListNode.fromList(listOf(1, 2, 6, 7)))?.`val`, 6)
}