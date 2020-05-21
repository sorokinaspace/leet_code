package challenge_may_2020

import common.TreeNode
import java.util.*

fun kthSmallest(root: TreeNode?, k: Int): Int {

    var node: TreeNode? = root
    var num = k

    val stack = LinkedList<TreeNode>()

    while (true) {
        while (node != null) {
            stack.add(node)
            node = node.left
        }
        node = stack.removeLast()

        if (--num == 0) {
            return node.`val`
        }
        node = node.right
    }
}