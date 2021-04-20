package invest.data.model

import kotlinx.serialization.Serializable

@Serializable
data class DailySellHistoryDto(
    val date: String,
    val price: Double,
    val volume: String
)