package invest

import invest.data.model.sellhistory.SellHistoryMapper
import invest.domain.DailySellHistory
import invest.serializer.invest.data.model.sellhistory.SellHistoryDto
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

class SellHistoryRepository {

    fun checkSharpRatio(resourcePath: String, period: Int): List<String> {
        val errorMessage = "Case price is currently in decline"
        val outputList = mutableListOf<String>()
        val haha = File(resourcePath).walk().toMutableList().drop(1)

        haha.forEach { file ->
            val filePath = file.toString()
                .replace("resources\\", "")
                .replace("""\""", "/")
            val filePathNew = "/$filePath"
            val fileName = filePath
                .replace(".json", "")
                .replace("caseJson/", "")
            val response = calculateSharpRatioFromJSON(filePathNew, period)
            if (response.isNaN()) {
                outputList.add("$fileName Sharp Ratio is: $errorMessage")
            } else {
                outputList.add("$fileName Sharp Ratio is: $response")
            }
        }
        return outputList
    }

    private fun calculateSharpRatioFromJSON(jSONPath: String, period: Int): Double {
        val jsonFileText = getResourceDirectory(jSONPath)
        val parsedJson: SellHistoryDto = Json.decodeFromString(jsonFileText)
        val mappedSellHistory = SellHistoryMapper.map(parsedJson)
        val dailySellHistoryList = mappedSellHistory.dropLast(725)
        val hourlyDataToDaily = mappedSellHistory.takeLast(720).chunked(24)
        return calculateSharpRatioFromDailyAndHourlySellHistory(dailySellHistoryList, hourlyDataToDaily, period)
    }

    private fun calculateSharpRatioFromDailyAndHourlySellHistory(
        dailySellHistoryList: List<DailySellHistory>,
        hoursDaysList: List<List<DailySellHistory>>,
        period: Int
    ): Double {
        val dailyPriceList = toDailyPriceList(dailySellHistoryList, period)
        val hourlyToDailyPriceList = fromHourlyToDailyPriceList(hoursDaysList, period)
        val fullDailyPriceLise = (dailyPriceList + hourlyToDailyPriceList).toMutableList()

        val growthPeriodList = buildGrowthPeriodList(fullDailyPriceLise)
        val calculatedReturn = calculateReturn(growthPeriodList)
        val standardDeviation = calculateStandardDeviation(calculatedReturn)
        val mean = calculateMean(calculatedReturn)

        return calculateSharpRatio(mean, standardDeviation)
    }

    private fun toDailyPriceList(dailySellHistoryList: List<DailySellHistory>, period: Int): MutableList<Double> {
        val pricesList = mutableListOf<Double>()
        when (period) {
            1 -> {
                dailySellHistoryList.map { day -> pricesList.add(day.price) }
            }
            30 -> {
                dailySellHistoryList.map { day ->
                    val dateSplit = day.date.split(" ")
                    if (dateSplit[1] == "13") {
                        pricesList.add(day.price)
                    }
                }
            }
        }
        return pricesList
    }

    private fun fromHourlyToDailyPriceList(HourlyDays: List<List<DailySellHistory>>, period: Int): MutableList<Double> {
        val hourlyPriceList = mutableListOf<Double>()
        HourlyDays.map { day ->
            day.map { hour ->
                val dateSplit = hour.date.split(" ")
                when (period) {
                    1 -> {
                        if (dateSplit[3] == "01:") {
                            hourlyPriceList.add(hour.price)
                        }
                    }
                    30 -> if (dateSplit[3] == "01:" && dateSplit[1] == "13") {
                        hourlyPriceList.add(hour.price)
                    }
                }
            }
        }
        return hourlyPriceList
    }

    private fun buildGrowthPeriodList(fullDailyAvgPrices: List<Double>): List<Double> {
        val minPrice = fullDailyAvgPrices.minOrNull()!!
        return fullDailyAvgPrices.takeLastWhile { price -> price != minPrice }
    }

    private fun calculateReturn(pricesList: List<Double>): List<Double> {
        val previousArray = pricesList.slice(0 until pricesList.size - 1)
        val nextArray = pricesList.slice(1 until pricesList.size)
        val pairedArray = previousArray.zip(nextArray)
        return pairedArray.map { (first, second) -> (second - first) / first }
    }

    fun calculateAvgReturn(pricesList: List<Double>, type: Int): Double {
        var roundedAvgReturn = 0.0
        val previousArray = pricesList.slice(0 until pricesList.size - 1)
        val nextArray = pricesList.slice(1 until pricesList.size)
        val pairedArray = previousArray.zip(nextArray)
        when (type) {
            1 -> {
                val returnList = pairedArray.map { (first, second) -> (second - first) / first }
                val avgReturn = (returnList.sum() / pairedArray.size) * 100
                roundedAvgReturn = (avgReturn * 100).roundToInt() / 100.0
            }
            2 -> {
                val returnList = pairedArray.map { (first, second) -> (second - first) }
                val avgReturn = returnList.sum() / pairedArray.size
                roundedAvgReturn = (avgReturn * 100).roundToInt() / 100.0
            }
        }
        return roundedAvgReturn
    }

    private fun calculateStandardDeviation(pricesList: List<Double>): Double {
        var standardDeviation = 0.0
        val mean = calculateMean(pricesList)

        for (num in pricesList) {
            standardDeviation += (num - mean).pow(2.0)
        }
        return sqrt(standardDeviation / pricesList.size)
    }

    private fun calculateSharpRatio(mean: Double, standardDeviation: Double): Double {
        return mean / standardDeviation
    }

    private fun calculateMean(pricesList: List<Double>): Double {
        var sum = 0.0
        for (num in pricesList) {
            sum += num
        }
        return sum / pricesList.size
    }

    private fun getResourceDirectory(path: String): String {
        return object {}.javaClass.getResource(path).readText()
    }
}