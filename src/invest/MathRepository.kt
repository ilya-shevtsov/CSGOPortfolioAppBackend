package invest

import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

class MathRepository {

    fun getSharpRatioFromPriceList(priceList: MutableList<Double>): Double {
        val growthPeriod = getGrowthPeriodList(priceList)
        val returnList = getReturnList(growthPeriod)
        return getSharpRatio(getMean(returnList), getStandardDeviation(returnList))
    }

    fun getGrowthPeriodList(priceList: List<Double>): List<Double> {
        val minPrice = priceList.minOrNull()!!
        return priceList.takeLastWhile { price -> price != minPrice }
    }

    fun getReturnList(priceList: List<Double>): List<Double> {
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

    fun getStandardDeviation(returnList: List<Double>): Double {
        var standardDeviation = 0.0
        for (num in returnList) {
            standardDeviation += (num - (getMean(returnList))).pow(2.0)
        }
        return sqrt(standardDeviation / returnList.size)
    }

    private fun getSharpRatio(mean: Double, standardDeviation: Double): Double {
        return mean / standardDeviation
    }

    fun getMean(priceList: List<Double>): Double {
        var sum = 0.0
        for (num in priceList) {
            sum += num
        }
        return sum / priceList.size
    }

    private fun myRound(number: Double) = (number * 100).roundToInt() / 100.0

    private fun getCurrencyReturnList(pairedArray: List<Pair<Double, Double>>) =
        pairedArray.map { (first, second) -> (second - first) }

    private fun getPercentReturnList(pairedArray: List<Pair<Double, Double>>) =
        pairedArray.map { (first, second) -> (second - first) / first }

    private fun getPairedPriceArray(priceList: List<Double>): List<Pair<Double, Double>> {
        val previousArray = priceList.slice(0 until priceList.size - 1)
        val nextArray = priceList.slice(1 until priceList.size)
        return previousArray.zip(nextArray)
    }
}