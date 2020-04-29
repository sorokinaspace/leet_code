package challenge

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
fun maxPathSum(root: TreeNode?): Int {
    root?.run {

        var maxSum = `val`

        fun sum(node: TreeNode?): Int {
            if (node == null) {
                return 0
            }

            val it = node.`val`
            val left = sum(node.left)
            val right = sum(node.right)

            val localMaxPath = it + with(if (left > right) left else right) { if (this < 0) 0 else this }
            val total = it + left + right

            if (total > maxSum) {
                maxSum = total
            } else if (localMaxPath > maxSum) {
                maxSum = localMaxPath
            }

            return localMaxPath
        }

        sum(this)

        return maxSum
    }

    return 0
}

fun main() {
    Test.assert(maxPathSum(TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3)
    }), 6)

    Test.assert(maxPathSum(TreeNode(-10).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }), 42)

    Test.assert(maxPathSum(TreeNode(1).apply {
        left = TreeNode(-2)
        right = TreeNode(3)
    }), 4)


    Test.assert(maxPathSum(TreeNode(5).apply {
        left = TreeNode(4).apply {
            left = TreeNode(11).apply {
                left = TreeNode(7)
                right = TreeNode(2)
            }
        }
        right = TreeNode(8).apply {
            left = TreeNode(13)
            right = TreeNode(4).apply {
                left = TreeNode(1)
            }
        }
    }), 48)
}