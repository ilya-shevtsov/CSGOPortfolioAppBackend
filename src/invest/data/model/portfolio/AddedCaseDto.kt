package invest.data.model.portfolio

import kotlinx.serialization.Serializable

@Serializable
data class AddedCaseDto(
    val name: String,
    val amount: Int,
    val purchasePrice: Double
)