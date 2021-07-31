package dev.gtcl.travelbank

import org.junit.Test

import org.junit.Assert.*

class UnitTests {

    @Test
    fun convertRemoteDateToMonthAndDay_isMatching() {
        val remoteDateStr = "2021-07-13T00:00:00.000Z"
        val result = convertRemoteDateToMonthAndDay(remoteDateStr)
        assertEquals("Jul 13", result)
    }

    @Test
    fun convertRemoteDateToMonthDayAndYear_isMatching() {
        val remoteDateStr = "2021-07-13T00:00:00.000Z"
        val result = convertRemoteDateToMonthDayAndYear(remoteDateStr)
        assertEquals("Jul 13, 2021", result)
    }
    
    @Test
    fun convertFloatToDollars_isMatching() {
        val amount = 12345.1F
        assertEquals(amount.toDollars(), "$12,345.10")
    }

}