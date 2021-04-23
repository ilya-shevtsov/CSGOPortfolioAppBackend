package invest

import invest.data.model.sellhistory.SellHistoryMapper
import invest.domain.DailySellHistory
import invest.serializer.invest.data.model.sellhistory.SellHistoryDto
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlin.math.pow
import kotlin.math.sqrt

class SellHistoryRepository {


//    fun calculateSharpRatioFromJSON(jSONPath: String): Double {
//        val jsonFileText = getResourceDirectory(jSONPath)
//        val parsedJson: SellHistoryDto = Json.decodeFromString(jsonFileText)
//
//        val mappedSellHistory = SellHistoryMapper.map(parsedJson)
//
//        val dailySellHistoryList = mappedSellHistory.dropLast(725)
//        val hourlyDataToDaily = mappedSellHistory.takeLast(720).chunked(24)
//
//        return calculateSharpRatioFromDailyAndHourlySellHistory(dailySellHistoryList, hourlyDataToDaily)
//    }
//
//    fun calculateSharpRatioFromDailyAndHourlySellHistory(
//        dailySellHistoryList: List<DailySellHistory>,
//        hoursDaysList: List<List<DailySellHistory>>
//    ): Double {
//
//        val dailyPriceList = toDailyPriceList(dailySellHistoryList)
//        val hourlyToDailyPriceList = fromHourlyToDailyPriceList(hoursDaysList)
//
//        val fullDailyPriceLise = (dailyPriceList + hourlyToDailyPriceList).toMutableList()
//        println(fullDailyPriceLise.size)
//        val analyzedPeriod = analyzedPeriod(fullDailyPriceLise,30)
//        println(analyzedPeriod.size)
//
//        // here I am working with Doubles, so before this I need to figure out if I want daily of monthly data
//        val growthPeriodList = BuildGrowthPeriodList(analyzedPeriod)
//        val calculatedReturn = calculateReturn(growthPeriodList)
//        val standardDeviation = calculateSD(calculatedReturn)
//        val mean = calculateMean(calculatedReturn)
//
//        return calculateSharpRatio(mean, standardDeviation)
//    }

//    private fun analyzedPeriod(fullDailyAvgPrices: List<Double>, period: Int): List<Double> {
//
//        val haha = mutableListOf<Double>()
//        when (period){
//            1 -> haha == fullDailyAvgPrices
//            30 -> haha == fullDailyAvgPrices.chunked(30)
//        }
//        return haha
//    }

    fun toDailyPriceList(dailySellHistoryList: List<DailySellHistory>): MutableList<Double> {
        val pricesList = mutableListOf<Double>()
        dailySellHistoryList.map { day ->
            pricesList.add(day.price)
        }
        return pricesList
    }


    fun fromHourlyToDailyPriceList(HourlyDays: List<List<DailySellHistory>>): MutableList<Double> {

        val hourlyPriceList = mutableListOf<Double>()

        HourlyDays.map { day ->
            day.map { hour ->

                val hourSplit = hour.date.split(" ")
                if (hourSplit[3] == "01:") {
                    hourlyPriceList.add(hour.price)
                }
            }
        }
        println(hourlyPriceList)
        return hourlyPriceList
    }

    fun BuildGrowthPeriodList(fullDailyAvgPrices: List<Double>): List<Double> {
        val minPrice = fullDailyAvgPrices.minOrNull()!!
        return fullDailyAvgPrices.takeLastWhile { it != minPrice }
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

    private fun getResourceDirectory(path: String): String {
        return object {}.javaClass.getResource(path).readText()
    }
}