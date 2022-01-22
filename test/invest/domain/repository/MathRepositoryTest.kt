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
    @Test
    fun `getAverageReturn P and C when example priceList(ChromaCase)`() {

        val priceList = listOf(
            451.563,
            344.652,
            323.338,
            300.489,
            261.415,
            250.424,
            222.172,
            189.713,
            151.709,
            1.858,
            1.208,
            1.256,
            1.11,
            1.251,
            1.497,
            1.421,
            1.114,
            1.212,
            1.027,
            1.201,
            1.103,
            1.297,
            1.522,
            1.31,
            1.015,
            1.224,
            0.945,
            1.121,
            1.075,
            1.21,
            0.998,
            0.965,
            0.776,
            0.614,
            0.576,
            0.904,
            0.791,
            0.924,
            0.877,
            0.768,
            0.949,
            0.855,
            1.041,
            1.062,
            0.857,
            1.087,
            1.136,
            0.651,
            1.217,
            1.182,
            0.901,
            1.01,
            1.101,
            0.842,
            1.143,
            0.926,
            0.881,
            1.046,
            0.927,
            0.979,
            1.024,
            0.95,
            0.947,
            1.414,
            0.901,
            1.289,
        )
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