package invest.domain.model.dailysellhistory

import java.time.Instant

data class DailySellHistory(
    val date: Instant,
    val price: Double,
    val volume: Int
)