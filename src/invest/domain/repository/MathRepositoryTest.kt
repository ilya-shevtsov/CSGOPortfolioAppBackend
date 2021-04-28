package invest.domain.repository

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.text.SimpleDateFormat
import java.util.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class MathRepositoryTest{

    val input = "Apr 17 2015 01: +0"

    @Test
    fun dateParse() {
        val datePattern = SimpleDateFormat("MMM dd yyyy HH: +0", Locale.ENGLISH)
        val newhaha = datePattern.parse(input)
        assertEquals(newhaha,"f")
    }

}