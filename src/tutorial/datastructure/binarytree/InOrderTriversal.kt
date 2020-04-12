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
class Solution2 {

    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()

        if (root == null) {
            return result
        }

        root.append(result)

        return result
    }

    private fun TreeNode.append(list: MutableCollection<Int>) {
        left?.run {
            append(list)
        }

        list.add(`val`)

        right?.run {
            append(list)
        }
    }
}