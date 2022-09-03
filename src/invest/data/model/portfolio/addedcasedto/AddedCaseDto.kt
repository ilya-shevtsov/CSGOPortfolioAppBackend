package invest.data.model.portfolio.addedcasedto

import kotlinx.serialization.Serializable

@Serializable
data class AddedCaseDto(
    val name: String,
    val amount: Int,
    val purchasePrice: Double
)