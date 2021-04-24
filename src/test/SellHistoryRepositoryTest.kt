package invest

import invest.domain.DailySellHistory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.math.roundToInt
import java.io.File

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class SellHistoryRepositoryTest {

    val sellHistoryRepository = SellHistoryRepository()

    val inputList = listOf(7.76, 10.03, 19.46, 19.68)

    @Test
    fun haha() {
        val haha = calculateAvgReturn(inputList, 2)
        Assertions.assertEquals(3.97, haha)
    }

    fun calculateAvgReturn(pricesList: List<Double>, type: Int): Double {
        val pairedArray = buildPairedPriceList(pricesList)
        return when (type) {
            1 -> {
                myRound(((getPercentReturnList(pairedArray).sum() / pairedArray.size) * 100))
            }
            2 -> {
                myRound(getCurrencyReturnList(pairedArray).sum() / pairedArray.size)
            }
            else -> throw Exception("The type of average return that your provided is not supported")
        }
    }
    private fun myRound(number: Double) = (number * 100).roundToInt() / 100.0

    private fun getCurrencyReturnList(pairedArray: List<Pair<Double, Double>>) =
        pairedArray.map { (first, second) -> (second - first) }

    private fun getPercentReturnList(pairedArray: List<Pair<Double, Double>>) =
        pairedArray.map { (first, second) -> (second - first) / first }

    private fun buildPairedPriceList(pricesList: List<Double>): List<Pair<Double, Double>> {
        val previousArray = pricesList.slice(0 until pricesList.size - 1)
        val nextArray = pricesList.slice(1 until pricesList.size)
        return previousArray.zip(nextArray)
    }
}
