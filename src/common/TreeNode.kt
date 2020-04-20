package common

class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    constructor(`val`: Int, left: Int? = null, right: Int? = null) : this(`val`) {
        this.left = left?.run { TreeNode(this) }
        this.right = right?.run { TreeNode(this) }
    }

    override fun toString(): String {
        return "$`val`${if (left == null) "" else ", $left"}${if (right == null) "" else ", $right"}"
    }

}

fun TreeNode.isLeaf() = left == null && right == null

fun TreeNode.printNode() {
    if (isLeaf()) {
        println("leaf $`val`")
    } else {
        println("-----------------------")
        if (right != null) {
            println("  right $right")
        }

        println("node $this")

        if (left != null) {
            println("   left $left")
        }
        println("-----------------------")
    }
}