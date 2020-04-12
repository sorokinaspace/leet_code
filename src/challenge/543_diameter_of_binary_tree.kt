package challenge

import common.TreeNode
import common.printNode
import java.util.concurrent.atomic.AtomicInteger
import kotlin.math.max

fun diameterOfBinaryTree(root: TreeNode?): Int {
    val max = AtomicInteger(0)
    calcDepth(root, max)
    return max.get()
}

private fun calcDepth(node: TreeNode?, maximum: AtomicInteger): Int {

    node?.run {
        printNode()

        return if (left != null || right != null) {
            val leftDepth = left?.run {
                calcDepth(this, maximum) + 1
            } ?: 0
            val rightDepth = right?.run {
                calcDepth(this, maximum) + 1
            } ?: 0

            val localMax = max(maximum.get(), leftDepth + rightDepth)
            maximum.set(localMax)

            max(leftDepth, rightDepth)
        } else {
            0
        }
    }

    return 0
}

fun main() {

    val node = TreeNode(0, 1, 2).apply {
        left = TreeNode(3, 4, 5).apply {
            left = TreeNode(7)
            right = TreeNode(8)
        }
        right = TreeNode(6)
    }

    Test.assert(diameterOfBinaryTree(node), 3)
}