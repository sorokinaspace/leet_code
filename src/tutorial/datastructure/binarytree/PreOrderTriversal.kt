package tutorial.datastructure.binarytree

import common.TreeNode

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
class Solution1 {

    fun preorderTraversal(root: TreeNode?): List<Int> {

        val result = mutableListOf<Int>()

        if (root == null) {
            return result
        }

        root.append(result)

        return result
    }

    private fun TreeNode.append(list: MutableCollection<Int>) {
        list.add(`val`)

        left?.run {
            append(list)
        }

        right?.run {
            append(list)
        }
    }
}