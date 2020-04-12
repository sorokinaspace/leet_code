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

// From problem 21
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

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    when {
        lists.isNullOrEmpty() -> return null
        lists.size == 1 -> return lists.first()
        // TODO else -> lists.reduce{list1, list2 -> mergeTwoLists(list1, list2)}
    }

    var rootNode: ListNode? = null

    for (node in lists) {
        if (rootNode == null) {
            rootNode = node
        } else {
            if (node == null) {
                continue
            }
            if (node.`val` < rootNode.`val`) {
                node.attach(rootNode)
                rootNode = node
            } else {
                rootNode.attach(node)
            }
        }
    }

    return rootNode
}

private fun ListNode.attach(node: ListNode) {
    val rootNextVal = next?.`val`
    val nodeVal = node.`val`

    if (rootNextVal == null || nodeVal <= rootNextVal) {
        val oldRootNext = next
        val nodeNext = node.next

        next = node
        node.next = oldRootNext

        if (nodeNext != null) {
            node.attach(nodeNext)
        }
    } else {
        next?.attach(node)
    }
}

fun main() {
    val node1 = ListNode.fromList(listOf(1, 4, 5))
    val node2 = ListNode.fromList(listOf(1, 3, 4))
    val node3 = ListNode.fromList(listOf(2, 6))

    val expected1 = ListNode.fromList(listOf(1, 1, 2, 3, 4, 4, 5, 6))?.toString()
    Test.assert(mergeKLists(arrayOf(node1, node2, node3))?.toString() == expected1, true, expected1)

    val node4 = ListNode.fromList(listOf(1))
    val node5 = ListNode.fromList(listOf(0))

    val expected2 = ListNode.fromList(listOf(0, 1))?.toString()
    Test.assert(mergeKLists(arrayOf(node4, node5))?.toString() == expected2, true, expected2)

}