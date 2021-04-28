package invest.domain.model

import java.util.*

data class DailySellHistory(
    val date: Date,
    val price: Double,
    val volume: Int
)