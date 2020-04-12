package challenge

fun maxProfit(prices: IntArray): Int {

    var total = 0

    prices.forEachIndexed { index, it ->
        if (index > 0) {
            if (it > prices[index - 1]) {
                total += it - prices[index - 1]
            }
        }
    }

    return total
}


fun maxProfit_1(prices: IntArray): Int {

    var total = 0
    var transaction = -1

    prices.forEachIndexed { index, it ->
        if (transaction < 0) { // need to buy
            if (index < prices.size - 1) { // not the last trade day
                if (it < prices[index + 1]) { // can sell tomorrow
                    transaction = it // buy
                }
            }
        } else { // need to sell
            if (index == prices.size - 1 || it > prices[index + 1]) { // the last chance or cheaper tomorrow
                total += it - transaction // sell
                transaction = -1
            }
        }
    }

    return total
}

fun main() {
    Test.assert(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)), 7)
    Test.assert(maxProfit(intArrayOf(1, 2, 3, 4, 5)), 4)
    Test.assert(maxProfit(intArrayOf(7, 6, 4, 3, 1)), 0)
}