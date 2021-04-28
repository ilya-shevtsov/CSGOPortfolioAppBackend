package invest.domain.repository

import invest.domain.model.DailySellHistory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.text.SimpleDateFormat
import java.util.*


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class SellHistoryRepositoryTest {

    val datePattern = SimpleDateFormat("MMM dd yyyy HH: +0", Locale.ENGLISH)

    val input = listOf(
        DailySellHistory(
            date = datePattern.parse("Sep 13 2015 01: +0"),
            price = 20.293,
            volume = 41463
        ),
        DailySellHistory(
            date = datePattern.parse("Sep 14 2015 01: +0"),
            price = 22.592,
            volume = 43049
        )
    )

    @Test
    fun testGetPriceListFromDaily() {
        val getPriceListFromDaily = getPriceListFromDaily(input,30)
        Assertions.assertEquals(listOf(20.293), getPriceListFromDaily)
    }

    fun getPriceListFromDaily(dailySellHistoryList: List<DailySellHistory>, period: Int): MutableList<Double> {
        val priceList = mutableListOf<Double>()
        when (period) {
            1 -> {
                dailySellHistoryList.map { day -> priceList.add(day.price) }
            }
            30 -> {
                dailySellHistoryList.map { day ->
                    if ( day.date.date== 13) {
                        priceList.add(day.price)
                    }
                }
            }
        }
        return priceList
    }
}