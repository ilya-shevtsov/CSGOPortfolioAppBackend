package invest.data.model.dailysellhistory.dto

import invest.serializer.DailySellHistorySerializer
import kotlinx.serialization.Serializable

@Serializable(with = DailySellHistorySerializer::class)
data class DailySellHistoryDto(
    val date: String,
    val price: Double,
    val volume: Int
)