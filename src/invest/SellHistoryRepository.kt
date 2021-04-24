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



    private fun getSharpRatioFromJSON(jsonPath: String, period: Int): Double {
        val jsonFileText = getResourceDirectory(jsonPath)
        val parsedJson: SellHistoryDto = Json.decodeFromString(jsonFileText)

        val getDailySellHistoryList =
            getDailySellHistoryList(parsedJson)

        val getDailyFromHourlySellHistoryList =
            getDailyFromHourlySellHistoryList(parsedJson)


        val getDailyPriceList = getDailyPriceList(
            getDailySellHistoryList,
            getDailyFromHourlySellHistoryList,
            period
        )
        return getSharpRatioFromDailyPriceList(getDailyPriceList)
    }

    private fun getDailyPriceList(
        dailySellHistoryList: List<DailySellHistory>,
        hoursDaysList: List<List<DailySellHistory>>,
        period: Int
    ): MutableList<Double> {



        val dailyPriceList = toDailyPriceList(dailySellHistoryList, period)
        val hourlyToDailyPriceList = fromHourlyToDailyPriceList(hoursDaysList, period)
        return (dailyPriceList + hourlyToDailyPriceList).toMutableList()
    }

    private fun getSharpRatioFromDailyPriceList(dailyPriceList: MutableList<Double>): Double {
        val growthPeriod = getGrowthPeriodList(dailyPriceList)
        val returnList = getReturnList(growthPeriod)
        return getSharpRatio(getMean(returnList), getStandardDeviation(returnList))
    }

    private fun toDailyPriceList(dailySellHistoryList: List<DailySellHistory>, period: Int): MutableList<Double> {
        val priceList = mutableListOf<Double>()
        when (period) {
            1 -> {
                dailySellHistoryList.map { day -> priceList.add(day.price) }
            }
            30 -> {
                dailySellHistoryList.map { day ->
                    val dateSplit = day.date.split(" ")
                    if (dateSplit[1] == "13") {
                        priceList.add(day.price)
                    }
                }
            }
        }
        return priceList
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

    private fun getGrowthPeriodList(dailyPriceList: List<Double>): List<Double> {
        val minPrice = dailyPriceList.minOrNull()!!
        return dailyPriceList.takeLastWhile { price -> price != minPrice }
    }

    private fun getReturnList(priceList: List<Double>): List<Double> {
        val pairedArray = getPairedPriceArray(priceList)
        return getPercentReturnList(pairedArray)
    }

    fun getAverageReturn(priceList: List<Double>, averageReturnType: Int): Double {
        val pairedArray = getPairedPriceArray(priceList)
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

    private fun getStandardDeviation(priceList: List<Double>): Double {
        var standardDeviation = 0.0
        for (num in priceList) {
            standardDeviation += (num - (getMean(priceList))).pow(2.0)
        }
        return sqrt(standardDeviation / priceList.size)
    }

    private fun getSharpRatio(mean: Double, standardDeviation: Double): Double {
        return mean / standardDeviation
    }

    private fun getMean(priceList: List<Double>): Double {
        var sum = 0.0
        for (num in priceList) {
            sum += num
        }
        return sum / priceList.size
    }

    private fun myRound(number: Double) = (number * 100).roundToInt() / 100.0

    private fun getDailyFromHourlySellHistoryList(parsedJson: SellHistoryDto) =
        SellHistoryMapper.map(parsedJson).takeLast(720).chunked(24)

    private fun getDailySellHistoryList(parsedJson: SellHistoryDto) =
        SellHistoryMapper.map(parsedJson).dropLast(725)

    private fun getCurrencyReturnList(pairedArray: List<Pair<Double, Double>>) =
        pairedArray.map { (first, second) -> (second - first) }

    private fun getPercentReturnList(pairedArray: List<Pair<Double, Double>>) =
        pairedArray.map { (first, second) -> (second - first) / first }

    private fun getPairedPriceArray(priceList: List<Double>): List<Pair<Double, Double>> {
        val previousArray = priceList.slice(0 until priceList.size - 1)
        val nextArray = priceList.slice(1 until priceList.size)
        return previousArray.zip(nextArray)
    }

    private fun getResourceDirectory(path: String): String {
        return object {}.javaClass.getResource(path).readText()
    }
}