package invest.data.model.porftolio.dbo

data class PortfolioDbo(
    val id: Int,
    val name: String,
    //    val date: Instant,
    val position: Int,
    val currentCasePrice: Double,
    val currentPositionValue: Double,
    val boughtCasePrice: Double,
    val boughtPositionValue: Double,
    val todayMovement: Double,
    val todayProfitInRUB: Double,
    val todayProfitInPercent: Double
)
