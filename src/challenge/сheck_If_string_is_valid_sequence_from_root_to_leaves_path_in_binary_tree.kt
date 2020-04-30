package challenge

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
fun isValidSequence(root: TreeNode?, arr: IntArray): Boolean {

    var level = 0

    val stack = Stack<TreeNode>()
    root?.run { stack.push(this) }

    while (level < arr.size) {

        val nextLevel = Stack<TreeNode>()
        val item = arr[level]

        while (stack.isNotEmpty()) {

            val node = stack.pop()
            if (node.`val` == item) {

                if (level == arr.lastIndex && node.left == null && node.right == null) {
                    return true
                }

                node.left?.run { nextLevel.push(this) }
                node.right?.run { nextLevel.push(this) }
            }
        }

        stack.addAll(nextLevel)
        level++
    }

    return false
}

fun main() {
    val root = TreeNode(0).apply {
        left = TreeNode(1).apply {
            left = TreeNode(0).apply {
                left = TreeNode(1)
            }
            right = TreeNode(1).apply {
                left = TreeNode(0)
                right = TreeNode(0)
            }
        }
        right = TreeNode(0).apply {
            left = TreeNode(0)
        }
    }

    Test.assert(isValidSequence(root, intArrayOf(0, 1, 0, 1)))
    Test.assert(!isValidSequence(root, intArrayOf(0, 0, 1)))
    Test.assert(!isValidSequence(root, intArrayOf(0, 1, 1)))
}