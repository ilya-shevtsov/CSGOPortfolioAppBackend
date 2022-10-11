package features.caseanalytics.data.entities

import features.caseanalytics.serializer.DailySellHistorySerializer
import kotlinx.serialization.Serializable

@Serializable(with = DailySellHistorySerializer::class)
data class DailySellHistoryDto(
    val date: String,
    val price: Double,
    val volume: Int
)