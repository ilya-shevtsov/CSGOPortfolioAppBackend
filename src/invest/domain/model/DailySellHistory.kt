package invest.domain.model

data class DailySellHistory(
    val date: String,
    val price: Double,
    val volume: Int
)