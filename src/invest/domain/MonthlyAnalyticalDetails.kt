package invest.domain

data class MonthlyAnalyticalDetails(
    val name: String,
//    val date: Instant,
    val monthlyAvgReturnInPercent: Double,
    val monthlyAvgReturnInRUB: Double,
    val monthlyStandardDeviation: Double,
    val monthlySharpRatio: Double
)