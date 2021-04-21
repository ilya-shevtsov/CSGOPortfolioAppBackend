package invest

import invest.data.model.sellhistory.SellHistoryDto
import invest.data.model.sellhistory.SellHistoryMapper
import invest.domain.DailySellHistory
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlin.math.pow
import kotlin.math.sqrt


class SellHistoryRepository {

    val casePrices = listOf(
        DailySellHistory("Apr 19 2021 00: +0", 7.76, "2893"),
        DailySellHistory("Apr 19 2021 01: +0", 10.03, "2528"),
        DailySellHistory("Apr 19 2021 02: +0", 19.46, "3235"),
        DailySellHistory("Apr 19 2021 03: +0", 19.68, "3399"),
    )

    val dailySellHistoryList = listOf(
        DailySellHistory("Apr 19 2021 00: +0", 18.33, "2893"),
        DailySellHistory("Apr 19 2021 01: +0", 18.361, "2528"),
        DailySellHistory("Apr 19 2021 02: +0", 19.094, "3235"),
        DailySellHistory("Apr 19 2021 03: +0", 19.414, "3399"),
        DailySellHistory("Apr 19 2021 04: +0", 19.414, "2932"),
        DailySellHistory("Apr 19 2021 05: +0", 20.232, "3437"),
        DailySellHistory("Apr 19 2021 06: +0", 19.858, "2492"),
        DailySellHistory("Apr 19 2021 07: +0", 19.858, "2719"),
        DailySellHistory("Apr 19 2021 08: +0", 19.764, "3779"),
        DailySellHistory("Apr 19 2021 09: +0", 19.606, "3904"),
        DailySellHistory("Apr 19 2021 10: +0", 19.983, "5379"),
        DailySellHistory("Apr 19 2021 11: +0", 19.881, "5685"),
        DailySellHistory("Apr 19 2021 12: +0", 19.775, "5931"),
        DailySellHistory("Apr 19 2021 13: +0", 19.881, "6320"),
        DailySellHistory("Apr 19 2021 14: +0", 19.531, "5821"),
        DailySellHistory("Apr 19 2021 15: +0", 19.506, "6581"),
        DailySellHistory("Apr 19 2021 16: +0", 19.647, "7517"),
        DailySellHistory("Apr 19 2021 17: +0", 19.104, "6368"),
        DailySellHistory("Apr 19 2021 18: +0", 19.094, "6461"),
        DailySellHistory("Apr 19 2021 19: +0", 19.212, "7320"),
        DailySellHistory("Apr 19 2021 20: +0", 19.094, "6813"),
        DailySellHistory("Apr 19 2021 21: +0", 19.094, "6961"),
        DailySellHistory("Apr 19 2021 22: +0", 19.094, "4487"),
        DailySellHistory("Apr 19 2021 23: +0", 19.094, "3499")
    )


    val jsonFileText = getResourceAsText("/clutchCaseDSH.json")
    val parsed: SellHistoryDto = Json.decodeFromString(jsonFileText)
    val mappedSellHistory = SellHistoryMapper.map(parsed)

    val beforeHourlyAndBad = mappedSellHistory.dropLast(725)
    val hourlyDays = mappedSellHistory.takeLast(720)
    val hourlyDaysByDays = hourlyDays.chunked(24)

    val thisSouldBe = toListOfDailyAvgPrices(hourlyDaysByDays)


    fun toListOfDailyAvgPrices(hoursDaysList: List<List<DailySellHistory>>): MutableList<Double> {
        val hourlyPriceList = mutableListOf<Double>()
        val averageDailyPriceList = mutableListOf<Double>()
        hoursDaysList.map { day ->
            day.map { hour ->
                hourlyPriceList.add(hour.price)
            }
        }
        hourlyPriceList.chunked(24).map { day ->
            averageDailyPriceList.add(day.sum() / 24)
        }
        return averageDailyPriceList
    }


    fun calculateSharpRatio(dailySellHistoryList: List<DailySellHistory>): Double {
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

    fun calculateReturn(pricesList: MutableList<Double>): MutableList<Double> {
        val previousArray = pricesList.slice(0 until pricesList.size - 1)
        val nextArray = pricesList.slice(1 until pricesList.size)
        val pairedArray = previousArray.zip(nextArray)
        return pairedArray.map { (first, second) ->
            (second - first) / first
        }.toMutableList()
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