package invest.serializer.invest.data.model.sellhistory

import invest.data.model.dailysellhistory.DailySellHistoryDto
import invest.serializer.invest.data.model.dailysellhistory.DailySellHistoryDtoNew
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SellHistoryDtoNew(

    val success: Boolean,

    @SerialName("price_prefix")
    val pricePrefix: String,

    @SerialName("price_suffix")
    val priceSuffix: String,

    val prices: List<DailySellHistoryDtoNew>
)