package invest

import invest.domain.DailySellHistory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class SellHistoryRepositoryTest {


    @Test

    fun haha() {
        val input = listOf(
            listOf<DailySellHistory>(
                DailySellHistory(
                    date = "Apr 22 2021 01: +0",
                    price = 18.959,
                    volume = 2457
                ),
                DailySellHistory(
                    date = "Apr 22 2021 02: +0",
                    price = 19.19,
                    volume = 2643
                )
            )
        )
        val output = toListOfDailyAvgPrices(input)

        Assertions.assertEquals(output, mutableListOf(18.959))
    }


    fun toListOfDailyAvgPrices(HourlyDays: List<List<DailySellHistory>>): MutableList<Double> {

        val hourlyPriceList = mutableListOf<Double>()

        HourlyDays.map { day ->
            day.map { hour ->

                val hourSplit = hour.date.split(" ")
                if (hourSplit[3] == "01:") {
                    hourlyPriceList.add(hour.price)
                }
            }
        }
        return hourlyPriceList
    }

//    val inputList = listOf(
//        1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0,
//        11.0, 12.0, 13.0, 14.0, 15.0, 16.0, 17.0, 18.0, 19.0, 20.0,
//        21.0, 22.0, 23.0, 24.0, 25.0, 26.0, 27.0, 28.0, 29.0, 30.0,
//
//        31.0, 32.0, 33.0, 34.0, 35.0, 36.0, 37.0, 38.0, 39.0, 40.0,
//        41.0, 42.0, 43.0, 44.0, 45.0, 46.0, 47.0, 48.0, 49.0, 50.0,
//        51.0, 52.0, 53.0, 54.0, 55.0, 56.0, 57.0, 58.0, 59.0, 60.0,61.0
//    )
//
//    val outputListPeriodOne = listOf(
//        1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0,
//        11.0, 12.0, 13.0, 14.0, 15.0, 16.0, 17.0, 18.0, 19.0, 20.0,
//        21.0, 22.0, 23.0, 24.0, 25.0, 26.0, 27.0, 28.0, 29.0, 30.0,
//
//        31.0, 32.0, 33.0, 34.0, 35.0, 36.0, 37.0, 38.0, 39.0, 40.0,
//        41.0, 42.0, 43.0, 44.0, 45.0, 46.0, 47.0, 48.0, 49.0, 50.0,
//        51.0, 52.0, 53.0, 54.0, 55.0, 56.0, 57.0, 58.0, 59.0, 60.0,
//    )
//    val outputListPeriodTwo = listOf(15.5,45.5)

//    fun haha() {
//        val haha = analyzedPeriod(inputList, 30)
//        Assertions.assertEquals(outputListPeriodTwo, haha)
//    }

//    fun analyzedPeriod(fullDailyAvgPrices: List<Double>, period: Int): List<Double> {
//
//        val outputListOfFun = mutableListOf<Double>()
//        when (period) {
//            1 -> {
//                fullDailyAvgPrices.map { day ->
//                    outputListOfFun.add(day)
//                }
//
//            }
//            30 -> {
//                fullDailyAvgPrices.chunked(30).map {month ->
//                    val avgForMonth = month.sum()/30
//                    outputListOfFun.add(avgForMonth)
//                }
//            }
//        }
//        return outputListOfFun
//    }
}
