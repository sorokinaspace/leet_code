package challenge

import common.TreeNode

fun bstFromPreorder(preorder: IntArray): TreeNode? {

    fun TreeNode.append(num: Int) {
        when {
            num < `val` -> if (left == null) left = TreeNode(num) else left?.append(num)
            else -> if (right == null) right = TreeNode(num) else right?.append(num)
        }
    }

    var root: TreeNode? = null

    preorder.forEach {
        when (root) {
            null -> root = TreeNode(it)
            else -> root?.append(it)
        }
    }

    return root
}

fun main() {
    Test.assert(bstFromPreorder(intArrayOf(8, 5, 1, 7, 10, 12)).toString() == "8, 5, 1, 7, 10, 12")
}