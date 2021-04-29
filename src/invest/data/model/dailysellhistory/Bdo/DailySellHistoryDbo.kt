package invest.data.model.dailysellhistory.Bdo

import java.time.Instant

data class DailySellHistoryDbo(
    val id: Int,
    val name: String,
    val date: Instant,
    val price: Double,
    val volume: Int
)