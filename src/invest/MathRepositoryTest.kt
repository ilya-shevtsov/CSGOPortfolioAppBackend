package invest

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import kotlin.math.ln
import kotlin.math.pow
import kotlin.math.sqrt

internal class MathRepositoryTest {

    private lateinit var mathRepository: MathRepository

    val input = mutableListOf(
        94.00,
        101.00,
        102.00,
        98.00,
        101.00,
        95.00,
        97.00,
        97.00,
        104.00,
        97.00,
        95.00,
        99.00,
        100.00,
        101.00,
        101.00,
        95.00,
        95.00,
        99.00,
        103.00,
        102.00
    )

    @BeforeEach
    fun onSetup() {
        mathRepository = MathRepository()
    }

    @Test
    fun testGetStandardDeviation() {
        val output = mathRepository.getStandardDeviation(input)
        assertEquals(0.041339265683302234, output)
    }

    @Test
    fun testGetSharpRatio() {
        val output = mathRepository.getSharpRatio(input)
        assertEquals(0.10398935894329135, output)
    }
}