package common

interface BinaryMatrix {
    fun get(x: Int, y: Int): Int
    fun dimensions(): List<Int>
}

class BinaryMatrixImpl(private val matrix: Array<IntArray>) : BinaryMatrix {

    private var accessCounter = 0

    override fun get(x: Int, y: Int): Int {
        accessCounter++
        return matrix[x][y]
    }

    override fun dimensions(): List<Int> {
        return listOf(matrix.size, matrix.firstOrNull()?.size ?: 0)
    }

    override fun toString(): String {
        return "Counter $accessCounter, matrix size ${dimensions()}"
    }
}