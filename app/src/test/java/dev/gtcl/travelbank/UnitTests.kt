package dev.gtcl.travelbank

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UnitTests {
    @Test
    fun monthAndDayIsCorrect() {
        val remoteDateStr = "2021-07-13T00:00:00.000Z"
        val result = convertRemoteDateToMonthAndDay(remoteDateStr)
        assertEquals("Jul 13", result)
    }

    @Test
    fun monthDayAndYearIsCorrect() {
        val remoteDateStr = "2021-07-13T00:00:00.000Z"
        val result = convertRemoteDateToMonthDayAndYear(remoteDateStr)
        assertEquals("Jul 13, 2021", result)
    }
}