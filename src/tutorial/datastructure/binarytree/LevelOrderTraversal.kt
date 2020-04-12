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
class Solution {

    fun levelOrder(root: TreeNode?): List<List<Int>> {

        val result = mutableListOf<List<Int>>()

        if (root == null) {
            return result
        }

        attachLevel(result, listOf(root))

        return result
    }

    private fun attachLevel(result: MutableList<List<Int>>, currentLevel: List<TreeNode>) {
        val currentResult = mutableListOf<Int>()
        val nextLevel = mutableListOf<TreeNode>()

        currentLevel.forEach {
            currentResult.add(it.`val`)
            it.left?.run {
                nextLevel.add(this)
            }
            it.right?.run {
                nextLevel.add(this)
            }
        }

        if (currentResult.isNotEmpty()) {
            result.add(currentResult)

            if (nextLevel.isNotEmpty()) {
                attachLevel(result, nextLevel)
            }
        }
    }
}