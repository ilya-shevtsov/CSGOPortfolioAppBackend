package invest.domain

import kotlinx.serialization.Serializable

@Serializable
data class DailySellHistory(
    val date: String,
    val price: Double,
    val volume: String
)