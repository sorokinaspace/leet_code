package tutorial.datastructure.binarytree

import common.TreeNode
import common.isLeaf

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
class Solution5 {

    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        if (root == null) {
            return false
        }

        return sumChildNode(root, root.`val`, sum)
    }

    private fun sumChildNode(node: TreeNode, nodeSum: Int, sum: Int): Boolean {
        node.let {
            if (it.isLeaf()) {
                return nodeSum == sum
            }

            return it.left?.run {
                sumChildNode(this, nodeSum + `val`, sum)
            } ?: false || it.right?.run {
                sumChildNode(this, nodeSum + `val`, sum)
            } ?: false
        }
    }
}