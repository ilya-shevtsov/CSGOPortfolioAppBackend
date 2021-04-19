package invest.domain

import kotlinx.serialization.Serializable

@Serializable
data class DailySellData(
    val date: String,
    val price: Double,
    val volume: String
)