package challenge

fun maximalSquare(matrix: Array<CharArray>): Int {

    var result = 0

    val rows = matrix.lastIndex
    val columns = matrix.firstOrNull()?.lastIndex ?: -1

    if (columns > -1) {
        fun validSquare(i: Int, j: Int, offset: Int): Boolean {

            for (vertical in i..(i + offset))
                if (matrix[vertical][j + offset] == '0') return false

            for (horizontal in j..(j + offset))
                if (matrix[i + offset][horizontal] == '0') return false

            return true
        }

        for (i in 0..rows) {
            for (j in 0..columns) {
                var sideSize = 0
                while (i + sideSize <= rows && j + sideSize <= columns && validSquare(i, j, sideSize)) {
                    sideSize++
                    with(sideSize * sideSize) {
                        if (this > result) result = this
                    }
                }
            }
        }
    }

    return result
}

fun main() {

    Test.assert(
        maximalSquare(
            arrayOf(
                charArrayOf('1', '0', '1', '0', '0'),
                charArrayOf('1', '0', '1', '1', '1'),
                charArrayOf('1', '1', '1', '1', '1'),
                charArrayOf('1', '0', '0', '1', '0')
            )
        ), 4
    )

    Test.assert(
        maximalSquare(
            arrayOf(
                charArrayOf('1', '1', '1', '1', '1', '1', '1', '1'),
                charArrayOf('1', '1', '1', '1', '1', '1', '1', '0'),
                charArrayOf('1', '1', '1', '1', '1', '1', '1', '0'),
                charArrayOf('1', '1', '1', '1', '1', '0', '0', '0'),
                charArrayOf('0', '1', '1', '1', '1', '0', '0', '0')
            )
        ), 16
    )
}