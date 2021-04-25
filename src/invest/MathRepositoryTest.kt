package invest

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import kotlin.math.ln
import kotlin.math.pow
import kotlin.math.sqrt

internal class MathRepositoryTest {

    private lateinit var mathRepository: MathRepository

    val input = mutableListOf(7.76, 10.03, 19.46, 19.68)
    val inputForSD = mutableListOf(0.29252577319587625, 0.9401794616151548, 0.0113052415210688)

    @BeforeEach
    fun onSetup() {
        mathRepository = MathRepository()
    }

    @Test
    fun testGetCurrencyReturnList() {
        val input: List<Pair<Double, Double>> = listOf(Pair(95.0,101.0))
        val output = mathRepository.getCurrencyReturnList(input)
        assertEquals(listOf(6.0),output)
    }
}