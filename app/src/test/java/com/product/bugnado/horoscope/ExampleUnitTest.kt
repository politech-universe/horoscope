package com.product.bugnado.horoscope

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_Kate() {
        var sign = Zodiac.getSignByDate("29.04.1997")
        assertEquals("taurus", sign)
    }
    @Test
    fun addition_Vadim() {
        var sign = Zodiac.getSignByDate("24.02.1997")
        assertEquals("pisces", sign)
    }
    @Test
    fun addition_Alexander() {
        var sign = Zodiac.getSignByDate("27.10.1997")
        assertEquals("scorpio", sign)}


}
