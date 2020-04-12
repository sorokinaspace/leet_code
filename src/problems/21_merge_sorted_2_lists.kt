package problems

import common.ListNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

private fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null || list2 == null) {
        return list1 ?: list2
    }

    return if (list1.`val` < list2.`val`) {
        list1.next = mergeTwoLists(list1.next, list2)
        list1
    } else {
        list2.next = mergeTwoLists(list1, list2.next)
        list2
    }
}

fun main() {
    val node1 = ListNode.fromList(listOf(1, 2, 4))
    val node2 = ListNode.fromList(listOf(1, 3, 4))

    val expected1 = ListNode.fromList(listOf(1, 1, 2, 3, 4, 4))?.toString()
    Test.assert(mergeTwoLists(node1, node2)?.toString() == expected1, true, expected1)
}
