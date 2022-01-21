package invest.domain.repository

import org.junit.Test
import kotlin.test.assertEquals


class MathRepositoryTest {
    private val mathRepository = MathRepository()


    @Test
    fun `getAverageReturn P and C when price gain is 100 RUB`() {

        val priceList = listOf(100.0,200.0)
        val averageReturnTypeP = 1
        val averageReturnTypeC = 2

        val getAverageReturnP = mathRepository.getAverageReturn(
            priceList = priceList,
            averageReturnType = averageReturnTypeP
        )
        val getAverageReturnC = mathRepository.getAverageReturn(
            priceList = priceList,
            averageReturnType = averageReturnTypeC
        )
        assertEquals(100.0,getAverageReturnP)
        assertEquals(100.0,getAverageReturnC)
    }

    @Test
    fun `getAverageReturn P and C when price gain is -100 RUB`() {

        val priceList = listOf(200.0,100.0)
        val averageReturnTypeP = 1
        val averageReturnTypeC = 2

        val getAverageReturnP = mathRepository.getAverageReturn(
            priceList = priceList,
            averageReturnType = averageReturnTypeP
        )
        val getAverageReturnC = mathRepository.getAverageReturn(
            priceList = priceList,
            averageReturnType = averageReturnTypeC
        )
        assertEquals(-50.0,getAverageReturnP)
        assertEquals(-100.0,getAverageReturnC)
    }
}