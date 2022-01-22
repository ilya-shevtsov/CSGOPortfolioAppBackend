package invest.domain.repository

import kotlin.math.ln
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

class MathRepository {

    fun getStandardDeviation(priceList: List<Double>): Double {
        val growthPeriod = getGrowthPeriodList(priceList)
        val logReturnList = getLogReturnList(growthPeriod)
        val mean = logReturnList.average()
        val squaredDeviationSum = logReturnList
            .fold(0.0, { accumulator, next -> accumulator + (next - mean).pow(2.0) })
        return sqrt(squaredDeviationSum / (logReturnList.size - 1))
    }

    fun getSharpRatio(priceList: List<Double>): Double {
        val growthPeriod = getGrowthPeriodList(priceList)
        val logReturnList = getLogReturnList(growthPeriod)
        val mean = logReturnList.average()
        val squaredDeviationSum = logReturnList
            .fold(0.0, { accumulator, logReturn -> accumulator + (logReturn - mean).pow(2.0) })
        val standardDeviation = sqrt(squaredDeviationSum / (logReturnList.size - 1))
        return mean / standardDeviation
    }

    private fun getGrowthPeriodList(priceList: List<Double>): List<Double> {
        val minPrice = priceList.minOrNull()
        return priceList.takeLastWhile { price -> price != minPrice }
    }

    private fun getLogReturnList(priceList: List<Double>): List<Double> {
        return getPairedPriceArray(priceList).map { (first, second) -> ln(second / first) }
    }

    fun getAverageReturn(priceList: List<Double>, averageReturnType: Int): Double {
        val pairedArray = getPairedPriceArray(priceList)
        return when (averageReturnType) {
            1 -> {
                val percentList = getPercentReturnList(pairedArray)
                val percentListSum = percentList.sum()
                val averageReturnP = (percentListSum / pairedArray.size)
                val roundedAverageReturnP = myRound(averageReturnP)
                roundedAverageReturnP
            }
            2 -> {
                val currencyList = getCurrencyReturnList(pairedArray)
                val currencyListSum = currencyList.sum()
                val averageReturnC = (currencyListSum / pairedArray.size)
                val roundedAverageReturnC = myRound(averageReturnC)
                roundedAverageReturnC
            }
            else -> throw Exception("The type of average return that your provided is not supported")
        }
    }

    private fun myRound(number: Double) = (number * 100).roundToInt() / 100.0

    private fun getCurrencyReturnList(pairedArray: List<Pair<Double, Double>>) =
        pairedArray.map { (first, second) -> (second - first) }

    private fun getPercentReturnList(pairedArray: List<Pair<Double, Double>>) =
        pairedArray.map { (first, second) -> ((second - first) / first) * 100 }

    private fun getPairedPriceArray(priceList: List<Double>): List<Pair<Double, Double>> {
        val previousArray = priceList.slice(0 until priceList.size - 1)
        val nextArray = priceList.slice(1 until priceList.size)
        return previousArray.zip(nextArray)
    }
}
