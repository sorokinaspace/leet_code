package challenge_may_2020

import java.util.*

fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {

    val initialColor = image[sr][sc]

    if (initialColor == newColor) {
        return image
    }

    val stack = Stack<Pair<Int, Int>>()
    stack.push(sr to sc)

    image[sr][sc] = newColor

    while (stack.isNotEmpty()) {
        val nextLevel = Stack<Pair<Int, Int>>()

        fun put(newPixel: Pair<Int, Int>) {
            image[newPixel.first][newPixel.second] = newColor
            nextLevel.add(newPixel)
        }

        while (stack.isNotEmpty()) {
            val pixel = stack.pop()

            if (pixel.first > 0 && image[pixel.first - 1][pixel.second] == initialColor) {
                put(pixel.first - 1 to pixel.second)
            }
            if (pixel.first < image.lastIndex && image[pixel.first + 1][pixel.second] == initialColor) {
                put(pixel.first + 1 to pixel.second)
            }
            if (pixel.second > 0 && image[pixel.first][pixel.second - 1] == initialColor) {
                put(pixel.first to pixel.second - 1)
            }
            if (pixel.second < image[0].lastIndex && image[pixel.first][pixel.second + 1] == initialColor) {
                put(pixel.first to pixel.second + 1)
            }
        }

        stack.addAll(nextLevel)
    }

    return image
}

fun main() {

    Test.assert(
        floodFill(
            arrayOf(
                intArrayOf(1, 1, 1),
                intArrayOf(1, 1, 0),
                intArrayOf(1, 0, 1)
            ), 1, 1, 2
        ).contentDeepEquals(
            arrayOf(
                intArrayOf(2, 2, 2),
                intArrayOf(2, 2, 0),
                intArrayOf(2, 0, 1)
            )
        )
    )

    Test.assert(
        floodFill(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 1)
            ), 1, 1, 1
        ).contentDeepEquals(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 1)
            )
        )
    )
}