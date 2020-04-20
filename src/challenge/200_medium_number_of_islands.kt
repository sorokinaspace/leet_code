package challenge

private class TreeNode(val row: Int, val column: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    var top: TreeNode? = null
    var bottom: TreeNode? = null

    override fun toString(): String {
        return "[$row][$column]"
    }

    fun addChildren(grid: Array<CharArray>): TreeNode {
        return this.apply {
            left = getLeft(grid)
            right = getRight(grid)
            top = getTop(grid)
            bottom = getBottom(grid)
        }
    }
    
    fun getRight(grid: Array<CharArray>): TreeNode? {
        if (column < grid[row].size - 1 && grid[row][column + 1] == '1') {
            grid[row][column + 1] = '0'
            return TreeNode(row, column + 1).addChildren(grid)
        }

        return null
    }

    fun getTop(grid: Array<CharArray>): TreeNode? {
        if (row > 0 && grid[row - 1][column] == '1') {
            grid[row - 1][column] = '0'
            return TreeNode(row - 1, column).addChildren(grid)
        }

        return null
    }

    fun getLeft(grid: Array<CharArray>): TreeNode? {
        if (column > 0 && grid[row][column - 1] == '1') {
            grid[row][column - 1] = '0'
            return TreeNode(row, column - 1).addChildren(grid)
        }

        return null
    }

    fun getBottom(grid: Array<CharArray>): TreeNode? {
        if (row < grid.size - 1 && grid[row + 1][column] == '1') {
            grid[row + 1][column] = '0'
            return TreeNode(row + 1, column).addChildren(grid)
        }

        return null
    }
}

fun numIslands(grid: Array<CharArray>): Int {

    var islands = 0

    grid.forEachIndexed { row, line ->
        line.forEachIndexed { column, char ->

            if (char == '1') {
                TreeNode(row, column).addChildren(grid)

                grid[row][column] = '0'
                islands++
            }
        }
    }

    return islands
}

fun main() {
    Test.assert(
        numIslands(
            arrayOf(
                charArrayOf('1', '1', '1', '1', '0'),
                charArrayOf('1', '1', '0', '1', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('1', '1', '0', '0', '0')
            )
        ), 1
    )

    Test.assert(
        numIslands(
            arrayOf(
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '1', '0', '0'),
                charArrayOf('0', '0', '0', '1', '1')
            )
        ), 3
    )

    Test.assert(
        numIslands(
            arrayOf(
                charArrayOf('1', '1', '1'),
                charArrayOf('0', '1', '0'),
                charArrayOf('1', '1', '1')
            )
        ), 1
    )
}