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
        val errorMessage = "price is currently in decline"
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
            val response = getSharpRatioFromJSON(filePathNew, period)
            if (response.isNaN()) {
                outputList.add("$fileName $errorMessage")
            } else {
                outputList.add("$fileName Sharp Ratio is: $response")
            }
        }
        return outputList
    }

    private fun getSharpRatioFromJSON(jSONPath: String, period: Int): Double {
        val jsonFileText = getResourceDirectory(jSONPath)
        val parsedJson: SellHistoryDto = Json.decodeFromString(jsonFileText)
        val mappedSellHistory = SellHistoryMapper.map(parsedJson)
        val dailySellHistoryList = mappedSellHistory.dropLast(725)
        val hourlyDataToDaily = mappedSellHistory.takeLast(720).chunked(24)
        val getFullDailyPriceList = getFullDailyPriceList(dailySellHistoryList, hourlyDataToDaily, period)
        return getSharpRatioFromDailyPriceList(getFullDailyPriceList)
    }

    private fun getFullDailyPriceList(
        dailySellHistoryList: List<DailySellHistory>,
        hoursDaysList: List<List<DailySellHistory>>,
        period: Int
    ): MutableList<Double> {
        val dailyPriceList = toDailyPriceList(dailySellHistoryList, period)
        val hourlyToDailyPriceList = fromHourlyToDailyPriceList(hoursDaysList, period)

        return (dailyPriceList + hourlyToDailyPriceList).toMutableList()
    }

    fun getSharpRatioFromDailyPriceList(fullDailyPriceLise: MutableList<Double>): Double {
        val growthPeriodList = getGrowthPeriodList(fullDailyPriceLise)
        val calculatedReturn = getReturnList(growthPeriodList)
        val standardDeviation = getStandardDeviation(calculatedReturn)
        val mean = getMean(calculatedReturn)
        return getSharpRatio(mean, standardDeviation)
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

    private fun getGrowthPeriodList(fullDailyAvgPrices: List<Double>): List<Double> {
        val minPrice = fullDailyAvgPrices.minOrNull()!!
        return fullDailyAvgPrices.takeLastWhile { price -> price != minPrice }
    }

    private fun getReturnList(pricesList: List<Double>): List<Double> {
        val pairedArray = getPairedPriceList(pricesList)
        return getPercentReturnList(pairedArray)
    }

    fun getAverageReturn(pricesList: List<Double>, averageReturnType: Int): Double {
        val pairedArray = getPairedPriceList(pricesList)
        return when (averageReturnType) {
            1 -> {
                myRound(((getPercentReturnList(pairedArray).sum() / pairedArray.size) * 100))
            }
            2 -> {
                myRound(getCurrencyReturnList(pairedArray).sum() / pairedArray.size)
            }
            else -> throw Exception("The type of average return that your provided is not supported")
        }
    }

    private fun getStandardDeviation(pricesList: List<Double>): Double {
        var standardDeviation = 0.0
        for (num in pricesList) {
            standardDeviation += (num - (getMean(pricesList))).pow(2.0)
        }
        return sqrt(standardDeviation / pricesList.size)
    }

    private fun getSharpRatio(mean: Double, standardDeviation: Double): Double {
        return mean / standardDeviation
    }

    private fun getMean(pricesList: List<Double>): Double {
        var sum = 0.0
        for (num in pricesList) {
            sum += num
        }
        return sum / pricesList.size
    }

    private fun myRound(number: Double) = (number * 100).roundToInt() / 100.0

    private fun getCurrencyReturnList(pairedArray: List<Pair<Double, Double>>) =
        pairedArray.map { (first, second) -> (second - first) }

    private fun getPercentReturnList(pairedArray: List<Pair<Double, Double>>) =
        pairedArray.map { (first, second) -> (second - first) / first }

    private fun getPairedPriceList(pricesList: List<Double>): List<Pair<Double, Double>> {
        val previousArray = pricesList.slice(0 until pricesList.size - 1)
        val nextArray = pricesList.slice(1 until pricesList.size)
        return previousArray.zip(nextArray)
    }

    private fun getResourceDirectory(path: String): String {
        return object {}.javaClass.getResource(path).readText()
    }
}