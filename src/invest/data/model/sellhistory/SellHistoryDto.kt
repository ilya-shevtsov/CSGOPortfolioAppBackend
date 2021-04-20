package invest.data.model.sellhistory

import com.google.gson.JsonElement
import invest.data.model.dailysellhistory.DailySellHistoryDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SellHistoryDto(

    val success: Boolean,

    @SerialName("price_prefix")
    val pricePrefix: String,

    @SerialName("price_suffix")
    val priceSuffix: String,

    val prices: List<List<String>>
)