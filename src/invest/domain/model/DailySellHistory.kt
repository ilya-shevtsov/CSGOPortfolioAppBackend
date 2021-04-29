package invest.domain.model

import java.time.Instant
import java.util.*

data class DailySellHistory(
    val date: Instant,
    val price: Double,
    val volume: Int
)