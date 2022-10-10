package invest.domain

data class DailyAnalyticalDetails(
    val name: String,
//    val date: Instant,
    val dailyAvgReturnInPercent: Double,
    val dailyAvgReturnInRUB: Double,
    val dailyStandardDeviation: Double,
    val dailySharpRatio: Double,
)