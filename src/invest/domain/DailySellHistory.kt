package invest.domain

data class DailySellHistory(
    val date: String,
    val price: Double,
    val volume: Int
)