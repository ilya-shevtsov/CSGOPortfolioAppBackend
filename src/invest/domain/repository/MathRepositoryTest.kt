package invest.domain.repository

import invest.data.database.repository.AnalyticalDetailsRepository
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MathRepositoryTest {

    val mathRepository = MathRepository()
    val analyticalDetailsRepository = AnalyticalDetailsRepository()

    @Test
    fun getAverageReturn() {
        val input = listOf(1.0,2.0,3.0,4.0,5.0)
        val output = mathRepository.getAverageReturn(input,2)
        assertEquals("d",output)
    }
}