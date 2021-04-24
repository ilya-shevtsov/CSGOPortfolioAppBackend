package invest

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import kotlin.math.pow
import kotlin.math.sqrt

internal class MathRepositoryTest {

    private lateinit var mathRepository: MathRepository

    val input = mutableListOf(7.76,10.03, 19.46, 19.68)
    val inputForSD = mutableListOf(0.29252577319587625, 0.9401794616151548, 0.0113052415210688)

    @BeforeEach
    fun onSetup() {
        mathRepository = MathRepository()
    }

    @Test
    fun testGetMean(){
        val output = mathRepository.getMean(inputForSD)
        assertEquals(	0.4146701587773666, output)
    }


    @Test
    fun testGetSharpRatioFromPriceList() {
        val output = mathRepository.getSharpRatioFromPriceList(input)
        assertEquals(1.0243418135125415, output)
    }

    @Test
    fun testGetGrowthPeriodList() {
        val output = mathRepository.getGrowthPeriodList(input)
        assertEquals(listOf(10.03, 19.46, 19.68), output)
    }

    @Test
    fun testGetReturnList() {
        val output = mathRepository.getReturnList(input)
        assertEquals(listOf(0.29252577319587625, 0.9401794616151548, 0.0113052415210688), output)
    }

    @Test
    fun testGetAverageReturnInPercent() {
        val output = mathRepository.getAverageReturn(input, 1)
        assertEquals(41.47, output)
    }

    @Test
    fun testGetAverageReturnInCurrency() {
        val output = mathRepository.getAverageReturn(input, 2)
        assertEquals(3.97, output)
    }

    @Test
    fun testGetStandardDeviation() {
        val output = mathRepository.getStandardDeviation(inputForSD)
        assertEquals(0.46, output)
    }
}