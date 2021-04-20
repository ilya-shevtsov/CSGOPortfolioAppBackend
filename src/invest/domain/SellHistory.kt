package invest.domain

data class SellHistory(
    val prices: List<List<DailySellHistory>>
)