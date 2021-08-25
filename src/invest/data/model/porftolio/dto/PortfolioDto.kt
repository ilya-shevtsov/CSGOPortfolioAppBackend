package invest.data.model.porftolio.dto

import kotlinx.serialization.Serializable

@Serializable
data class PortfolioDto(
    val name: String,
    val position: Int,
    val currentCasePrice: Double,
    val currentPositionValue: Double,
    val boughtCasePrice: Double,
    val boughtPositionValue: Double,
    val todayMovement: Double,
    val todayProfitInRUB: Double,
    val todayProfitInPercent: Double
)