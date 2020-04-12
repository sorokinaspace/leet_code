package tutorial.datastructure.binarytree

import common.TreeNode
import kotlin.math.max

class Solution4 {

    fun maxDepth(root: TreeNode?): Int {
        return calcDepth(root, 1)
    }

    private fun calcDepth(node: TreeNode?, depth: Int): Int {

        node?.run {
            return if (left != null || right != null) {
                val leftDepth = left?.run { calcDepth(this, depth + 1) } ?: 0
                val rightDepth = right?.run { calcDepth(this, depth + 1) } ?: 0
                max(leftDepth, rightDepth)
            } else {
                depth
            }
        }

        return 0
    }

}