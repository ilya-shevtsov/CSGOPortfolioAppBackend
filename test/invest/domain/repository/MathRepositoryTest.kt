package invest.domain.repository

import features.caseanalytics.domain.MathRepository
import org.junit.Assert.*
import org.junit.Test
import kotlin.math.abs
import kotlin.math.ln
import kotlin.math.sqrt

class MathRepositoryTest {

    private val repo = MathRepository()

    private fun assertDoubleEquals(expected: Double, actual: Double, eps: Double = 1e-9) {
        assertTrue(
            "Expected <$expected> but was <$actual>",
            abs(expected - actual) <= eps
        )
    }

    @Test
    fun `getAverageReturn P and C when price gain is 100 RUB`() {
        val priceList = listOf(100.0, 200.0)

        val p = repo.getAverageReturn(priceList, 1)
        val c = repo.getAverageReturn(priceList, 2)

        assertDoubleEquals(100.0, p)
        assertDoubleEquals(100.0, c)
    }

    @Test
    fun `getAverageReturn P and C when price gain is -100 RUB`() {
        val priceList = listOf(200.0, 100.0)

        val p = repo.getAverageReturn(priceList, 1)
        val c = repo.getAverageReturn(priceList, 2)

        assertDoubleEquals(-50.0, p)
        assertDoubleEquals(-100.0, c)
    }

    @Test
    fun `getAverageReturn works for multi step series - percent vs currency`() {
        val priceList = listOf(100.0, 110.0, 121.0)

        val p = repo.getAverageReturn(priceList, 1)
        val c = repo.getAverageReturn(priceList, 2)

        assertDoubleEquals(10.0, p)
        assertDoubleEquals(10.5, c)
    }

    @Test
    fun `getAverageReturn returns 0_0 for single item list (paired array empty - NaN - myRound returns 0)`() {
        val priceList = listOf(123.0)

        val p = repo.getAverageReturn(priceList, 1)
        val c = repo.getAverageReturn(priceList, 2)

        assertDoubleEquals(0.0, p)
        assertDoubleEquals(0.0, c)
    }

    @Test
    fun `getAverageReturn throws for unsupported averageReturnType`() {
        try {
            repo.getAverageReturn(listOf(1.0, 2.0), 999)
            fail("Expected an exception for unsupported type")
        } catch (t: Throwable) {
            assertTrue(t is Exception)
        }
    }

    @Test
    fun `getStandardDeviation - symmetric log returns gives expected value`() {

        val prices = listOf(1.0, 2.0, 3.0, 2.0)

        val sd = repo.getStandardDeviation(prices)

        val a = ln(3.0 / 2.0)
        val expected = abs(a) * sqrt(2.0)

        assertDoubleEquals(expected, sd, eps = 1e-9)
        assertTrue(sd >= 0.0)
    }

    @Test
    fun `getStandardDeviation is invariant to scaling (multiply all prices by constant)`() {
        val prices = listOf(1.0, 2.0, 3.0, 2.0)
        val scaled = prices.map { it * 100.0 }

        val sd1 = repo.getStandardDeviation(prices)
        val sd2 = repo.getStandardDeviation(scaled)

        assertDoubleEquals(sd1, sd2, eps = 1e-9)
    }

    @Test
    fun `getSharpRatio - symmetric log returns gives 0`() {
        val prices = listOf(1.0, 2.0, 3.0, 2.0)

        val sharpe = repo.getSharpRatio(prices)

        assertDoubleEquals(0.0, sharpe, eps = 1e-9)
    }

    @Test
    fun `getSharpRatio returns NaN when not enough log returns (stdev computed with size-1 == 0)`() {
        val prices = listOf(1.0, 2.0, 4.0)

        val sharpe = repo.getSharpRatio(prices)

        assertTrue("Expected NaN, got $sharpe", sharpe.isNaN())
    }

    @Test
    fun `getSharpRatio returns NaN when min is last (growthPeriod empty)`() {
        val prices = listOf(10.0, 5.0, 1.0) // min at end => growthPeriod empty

        val sharpe = repo.getSharpRatio(prices)

        assertTrue("Expected NaN, got $sharpe", sharpe.isNaN())
    }

    @Test
    fun `getSharpRatio is invariant to scaling (multiply all prices by constant)`() {
        val prices = listOf(1.0, 2.0, 3.0, 2.0)
        val scaled = prices.map { it * 50.0 }

        val s1 = repo.getSharpRatio(prices)
        val s2 = repo.getSharpRatio(scaled)

        assertDoubleEquals(s1, s2, eps = 1e-9)
    }
}
