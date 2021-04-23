package invest.serializer.invest.data.model.dailysellhistory

import invest.serializer.DailySellHistorySerializer
import kotlinx.serialization.Serializable

@Serializable(with = DailySellHistorySerializer::class)
data class DailySellHistoryDtoNew(
    val date: String,
    val price: Double,
    val volume: Int
)