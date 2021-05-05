package invest.data.model.analyticaldetails

data class DailyAnalyticalDetails(
    val name: String,
//    val date: Instant,
    val dailyAvgReturnInPercent: Double,
    val dailyAvgReturnInRUB: Double,
    val dailyStandardDeviation: Double,
    val dailySharpRatio: Double,
)