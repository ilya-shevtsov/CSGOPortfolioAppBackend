package invest.domain.repository

import invest.data.model.sellhistory.SellHistoryMapper
import invest.domain.model.DailySellHistory
import invest.data.model.sellhistory.SellHistoryDto
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File
import java.util.*

class SellHistoryRepository {

    private val mathRepository = MathRepository()

    fun prepareSharpRatioResponse(resourcePath: String, period: Int): List<String> {
        val outputList = mutableListOf<String>()
        val resourceList = File(resourcePath).walk().toMutableList().drop(1)
        resourceList.forEach { file ->
            val filePath = handleFilePath(file)
            val fileName = handleFileName(filePath)
            val sharpRatio = getSharpRatioFromJson(filePath, period)

            if (sharpRatio.isNaN()) {
                outputList.add("$fileName could not calculate, for more details check /Errors")
            } else {
                when (period) {
                    30 -> outputList.add("$fileName monthly sharp Ratio is: $sharpRatio")
                    1 -> outputList.add("$fileName daily sharp Ratio is: $sharpRatio")
                }
            }
        }
        return outputList
    }

    fun prepareStandardDeviationResponse(resourcePath: String, period: Int): List<String> {
        val outputList = mutableListOf<String>()
        val resourceList = File(resourcePath).walk().toMutableList().drop(1)
        resourceList.forEach { file ->
            val filePath = handleFilePath(file)
            val fileName = handleFileName(filePath)
            val standardDeviation = getStandardDeviationFromJson(filePath, period)

            if (standardDeviation.isNaN()) {
                outputList.add("$fileName could not calculate, for more details check /Errors")
            } else {
                when (period) {
                    30 -> outputList.add("$fileName monthly standard deviation is: $standardDeviation")
                    1 -> outputList.add("$fileName daily standard deviation is: $standardDeviation")
                }
            }
        }
        return outputList
    }

    private fun getAverageReturnFromJson(
        jsonPath: String,
        period: Int,
        averageReturnType: Int
    ): Double {
        val jsonFileText = getResourceDirectory(jsonPath)
        val parsedJson: SellHistoryDto = Json.decodeFromString(jsonFileText)
        val priceList = getPriceList(parsedJson, period)
        return mathRepository.getAverageReturn(priceList, averageReturnType)
    }

    private fun getSharpRatioFromJson(jsonPath: String, period: Int): Double {
        val jsonFileText = getResourceDirectory(jsonPath)
        val parsedJson: SellHistoryDto = Json.decodeFromString(jsonFileText)
        val priceList = getPriceList(parsedJson, period)
        return mathRepository.getSharpRatio(priceList)
    }

    private fun getStandardDeviationFromJson(jsonPath: String, period: Int): Double {
        val jsonFileText = getResourceDirectory(jsonPath)
        val parsedJson: SellHistoryDto = Json.decodeFromString(jsonFileText)
        val priceList = getPriceList(parsedJson, period)

        return mathRepository.getStandardDeviation(priceList)
    }

    private fun handleFileName(filePath: String): String {
        return filePath
            .replace(".json", "")
            .replace("caseJson/", "")
            .replace("/", "")
    }

    private fun handleFilePath(file: File): String {
        val filePath = file.toString()
            .replace("resources\\", "")
            .replace("""\""", "/")
        return "/$filePath"
    }

    private fun getPriceList(
        parsedJson: SellHistoryDto,
        period: Int
    ): MutableList<Double> {

        val dailyPriceList = getPriceListFromDaily(getDailySellHistoryList(parsedJson), period)
        val dailyPriceListFromHourly = toPriceListFromHourly(
            getDailyFromHourlySellHistoryList(parsedJson), period
        )

        return (dailyPriceList + dailyPriceListFromHourly).toMutableList()
    }

    private fun getPriceListFromDaily(dailySellHistoryList: List<DailySellHistory>, period: Int): MutableList<Double> {
        val priceList = mutableListOf<Double>()
        when (period) {
            1 -> {
                dailySellHistoryList.map { day -> priceList.add(day.price) }
            }
            30 -> {
                dailySellHistoryList.map { day ->
                    if (day.date.date == 13) {
                        priceList.add(day.price)
                    }
                }
            }
        }
        return priceList
    }


    private fun toPriceListFromHourly(hourlyDayList: List<List<DailySellHistory>>, period: Int): MutableList<Double> {
        val hourlyPriceList = mutableListOf<Double>()
        hourlyDayList.map { day ->
            day.map { hour ->
                when (period) {
                    1 -> {
                        if (hour.date.hours == 1) {
                            hourlyPriceList.add(hour.price)
                        }
                    }
                    30 -> if (hour.date.hours == 1 && hour.date.date == 13) {
                        hourlyPriceList.add(hour.price)
                    }
                }
            }
        }
        return hourlyPriceList
    }

    private fun getDailyFromHourlySellHistoryList(parsedJson: SellHistoryDto) =
        SellHistoryMapper.map(parsedJson).takeLast(720).chunked(24)

    private fun getDailySellHistoryList(parsedJson: SellHistoryDto) =
        SellHistoryMapper.map(parsedJson).dropLast(725)

    private fun getResourceDirectory(path: String): String {
        return object {}.javaClass.getResource(path).readText()
    }
}