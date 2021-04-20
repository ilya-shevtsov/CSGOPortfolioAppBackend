package invest.data.model.dailysellhistory

import kotlinx.serialization.Serializable

@Serializable
data class DailySellHistoryDto(
    val date: String,
    val price: Double,
    val volume: String
)