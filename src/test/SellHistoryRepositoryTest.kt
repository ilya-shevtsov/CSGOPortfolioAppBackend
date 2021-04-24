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
        val haha = calculateAvgReturn(inputList, 1)
        Assertions.assertEquals(41.47, haha)
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
}
