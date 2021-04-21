package invest

import invest.data.model.sellhistory.SellHistoryDto
import invest.data.model.sellhistory.SellHistoryMapper
import invest.domain.DailySellHistory
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlin.math.pow
import kotlin.math.sqrt


class SellHistoryRepository {


    fun calculateSharpRatioFromJSON(jSONPath: String): Double {
        val jsonFileText = getResourceAsText(jSONPath)
        val parsedJson: SellHistoryDto = Json.decodeFromString(jsonFileText)
        val mappedSellHistory = SellHistoryMapper.map(parsedJson)
        val dailySellHistoryList = mappedSellHistory.dropLast(725)
        val hourlyDataToDaily = mappedSellHistory.takeLast(720).chunked(24)
        return calculateSharpRatioFromDailyAndHourlySellHistory(dailySellHistoryList, hourlyDataToDaily)
    }

    val jsonFileText = getResourceAsText("/clutchCaseDSH.json")
    val parsedJson: SellHistoryDto = Json.decodeFromString(jsonFileText)
    val mappedSellHistory = SellHistoryMapper.map(parsedJson)
    val dailySellHistoryList = mappedSellHistory.dropLast(725)
    val hourlyDataToDaily = mappedSellHistory.takeLast(720).chunked(24)
    val haha = calculateSharpRatioFromDailyAndHourlySellHistory(dailySellHistoryList, hourlyDataToDaily)

    fun calculateSharpRatioFromDailyAndHourlySellHistory(
        dailySellHistoryList: List<DailySellHistory>,
        hoursDaysList: List<List<DailySellHistory>>
    ): Double {
        val dailyAvgPrices = extractPrices(dailySellHistoryList)
        val hourlyAvgPricesToDaily = toListOfDailyAvgPrices(hoursDaysList)
        val fullDailyAvgPrices = dailyAvgPrices + hourlyAvgPricesToDaily
        val growthPeriodList = BuildGrowthPeriodList(fullDailyAvgPrices)
        val calculatedReturn = calculateReturn(growthPeriodList)
        val standardDeviation = calculateSD(calculatedReturn)
        val mean = calculateMean(calculatedReturn)
        return calculateSharpRatio(mean, standardDeviation)
    }

    fun BuildGrowthPeriodList(fullDailyAvgPrices: List<Double>): List<Double> {
        val minPrice = fullDailyAvgPrices.minOrNull()!!
        return fullDailyAvgPrices.takeLastWhile { it != minPrice }
    }


    fun toListOfDailyAvgPrices(HourlyDays: List<List<DailySellHistory>>): MutableList<Double> {
        val averageDailyPriceList = mutableListOf<Double>()
        val hourlyPriceList = mutableListOf<Double>()
        HourlyDays.map { day -> day.map { hour -> hourlyPriceList.add(hour.price) } }
        hourlyPriceList.chunked(24).map { day -> averageDailyPriceList.add(day.sum() / 24) }
        return averageDailyPriceList
    }


    fun calculateSharpRatioFromDSH(dailySellHistoryList: List<DailySellHistory>): Double {
        val extractDSHData = extractPrices(dailySellHistoryList)
        val calculatedReturn = calculateReturn(extractDSHData)
        val standardDeviation = calculateSD(calculatedReturn)
        val mean = calculateMean(calculatedReturn)
        return calculateSharpRatio(mean, standardDeviation)
    }

    fun extractPrices(dailySellHistoryList: List<DailySellHistory>): MutableList<Double> {
        val pricesList = mutableListOf<Double>()
        dailySellHistoryList.map { day ->
            pricesList.add(day.price)
        }
        return pricesList
    }

    fun calculateReturn(pricesList: List<Double>): List<Double> {
        val previousArray = pricesList.slice(0 until pricesList.size - 1)
        val nextArray = pricesList.slice(1 until pricesList.size)
        val pairedArray = previousArray.zip(nextArray)
        return pairedArray.map { (first, second) ->
            (second - first) / first
        }
    }

    fun calculateSD(pricesList: List<Double>): Double {
        var standardDeviation = 0.0
        val mean = calculateMean(pricesList)

        for (num in pricesList) {
            standardDeviation += (num - mean).pow(2.0)
        }
        return sqrt(standardDeviation / pricesList.size)
    }

    fun calculateSharpRatio(mean: Double, standardDeviation: Double): Double {
        return mean / standardDeviation
    }

    fun calculateMean(pricesList: List<Double>): Double {
        var sum = 0.0
        for (num in pricesList) {
            sum += num
        }
        return sum / pricesList.size
    }

    private fun getResourceAsText(path: String): String {
        return object {}.javaClass.getResource(path).readText()
    }
}