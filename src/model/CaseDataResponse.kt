package model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class CaseDataResponse(

    @SerializedName("success")
    val success: Boolean,

    @SerializedName("lowest_price")
    val lowestPrice: String,

    @SerializedName("volume")
    val volume: String,

    @SerializedName("median_price")
    val medianPrice: String,
)