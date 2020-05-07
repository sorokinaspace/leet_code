package challenge_may_2020

import common.TreeNode
import java.util.*

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {

    val stack = Stack<TreeNode>()
    root?.run { stack.push(this) }

    var nodeXRoot: TreeNode? = null
    var nodeYRoot: TreeNode? = null

    while (stack.isNotEmpty()) {

        val nextLevel = Stack<TreeNode>()

        while (stack.isNotEmpty()) {
            val node = stack.pop()

            with(node) {
                if (left?.`val` == x) nodeXRoot = node
                else if (left?.`val` == y) nodeYRoot = node
                else if (right?.`val` == x) nodeXRoot = node
                else if (right?.`val` == y) nodeYRoot = node
                else {
                    left?.run { nextLevel.push(this) }
                    right?.run { nextLevel.push(this) }
                }
            }

            if (nodeXRoot != null && nodeYRoot != null) {
                return nodeXRoot != nodeYRoot
            }
        }

        if (nodeXRoot != null || nodeYRoot != null) {
            return false
        }

        stack.addAll(nextLevel)
    }

    return false
}

fun main() {
    val root = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
        }
        right = TreeNode(3)
    }
    Test.assert(!isCousins(root, 3, 4))

    val root2 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            right = TreeNode(4)
        }
        right = TreeNode(3).apply {
            right = TreeNode(5)
        }
    }
    Test.assert(isCousins(root2, 4, 5))

    val root3 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4)
        }
        right = TreeNode(3)
    }
    Test.assert(!isCousins(root3, 2, 3))
}