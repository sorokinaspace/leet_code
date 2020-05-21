package challenge_may_2020

import kotlin.math.max

/**
 * Your StockSpanner object will be instantiated and called as such:
 * var obj = StockSpanner()
 * var param_1 = obj.next(price)
 */
class StockSpanner() {

    private val dayStocks = sortedMapOf<Int, Int>()

    fun next(price: Int): Int {
        var days = 1

        var start = 0
        var end = dayStocks.size

        var keys = dayStocks.keys

        while (start < end) {
            val middle = start + (end - start) / 2
            val middlePrice = dayStocks[middle]
            if (middlePrice != null && middlePrice > price) {
                start = middle + 1
            } else {
                end = middle - 1
                days = max(days, dayStocks.size - middle)
            }
        }

        dayStocks[price] = dayStocks.size

        return days
    }
}

fun main() {
    val S = StockSpanner()
    Test.assert(S.next(100), 1)
    Test.assert(S.next(80), 1)
    Test.assert(S.next(60), 1)
    Test.assert(S.next(70), 2)
    Test.assert(S.next(60), 1)
    Test.assert(S.next(75), 4)
    Test.assert(S.next(85), 6)
}