package com.product.bugnado.horoscope.unittests

import com.product.bugnado.horoscope.Zodiac
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ZodiacTests {

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

    @Test
    fun sagittariusTest() {
        var month = 12
        for(i in 1..21){
            assertEquals("sagittarius",Zodiac.getSignByDate(i.toString()+"."+month+"."+"1997"))
        }
        month = 11
        for(i in 22..31){
            assertEquals("sagittarius",Zodiac.getSignByDate(i.toString()+"."+month+"."+"1997"))
        }
    }

    @Test
    fun capricornTest() {
        var month = 12
        for(i in 22..31){
            assertEquals("capricorn",Zodiac.getSignByDate(i.toString()+"."+month+"."+"1997"))
        }
        month = 1
        for(i in 1..19){
            assertEquals("capricorn",Zodiac.getSignByDate(i.toString()+"."+month+"."+"1997"))
        }
    }

    @Test
    fun aquariusTest() {
        var month = 1
        for(i in 20..31){
            assertEquals("aquarius",Zodiac.getSignByDate(i.toString()+"."+month+"."+"1997"))
        }
        month = 2
        for(i in 1..18){
            assertEquals("aquarius",Zodiac.getSignByDate(i.toString()+"."+month+"."+"1997"))
        }
    }

    @Test
    fun piscesTest() {
        var month = 2
        for(i in 19..31){
            assertEquals("pisces",Zodiac.getSignByDate(i.toString()+"."+month+"."+"1997"))
        }
        month = 3
        for(i in 1..20){
            assertEquals("pisces",Zodiac.getSignByDate(i.toString()+"."+month+"."+"1997"))
        }
    }

    @Test
    fun ariesTest() {
        var month = 3
        for(i in 21..31){
            assertEquals("aries",Zodiac.getSignByDate(i.toString()+"."+month+"."+"1997"))
        }
        month = 4
        for(i in 1..19){
            assertEquals("aries",Zodiac.getSignByDate(i.toString()+"."+month+"."+"1997"))
        }
    }

    @Test
    fun taurusTest() {
        var month = 4
        for(i in 20..31){
            assertEquals("taurus",Zodiac.getSignByDate(i.toString()+"."+month+"."+"1997"))
        }
        month = 5
        for(i in 1..20){
            assertEquals("taurus",Zodiac.getSignByDate(i.toString()+"."+month+"."+"1997"))
        }
    }

    @Test
    fun geminiTest() {
        var month = 5
        for(i in 21..31){
            assertEquals("gemini",Zodiac.getSignByDate(i.toString()+"."+month+"."+"1997"))
        }
        month = 6
        for(i in 1..20){
            assertEquals("gemini",Zodiac.getSignByDate(i.toString()+"."+month+"."+"1997"))
        }
    }

    @Test
    fun cancerTest() {
        var month = 6
        for(i in 21..31){
            assertEquals("cancer",Zodiac.getSignByDate(i.toString()+"."+month+"."+"1997"))
        }
        month = 7
        for(i in 1..22){
            assertEquals("cancer",Zodiac.getSignByDate(i.toString()+"."+month+"."+"1997"))
        }
    }

    @Test
    fun leoTest() {
        var month = 7
        for(i in 23..31){
            assertEquals("leo",Zodiac.getSignByDate(i.toString()+"."+month+"."+"1997"))
        }
        month = 8
        for(i in 1..22){
            assertEquals("leo",Zodiac.getSignByDate(i.toString()+"."+month+"."+"1997"))
        }
    }

    @Test
    fun virgoTest() {
        var month = 8
        for(i in 23..31){
            assertEquals("virgo",Zodiac.getSignByDate(i.toString()+"."+month+"."+"1997"))
        }
        month = 9
        for(i in 1..22){
            assertEquals("virgo",Zodiac.getSignByDate(i.toString()+"."+month+"."+"1997"))
        }
    }

    @Test
    fun libraTest() {
        var month = 9
        for(i in 23..31){
            assertEquals("libra",Zodiac.getSignByDate(i.toString()+"."+month+"."+"1997"))
        }
        month = 10
        for(i in 1..22){
            assertEquals("libra",Zodiac.getSignByDate(i.toString()+"."+month+"."+"1997"))
        }
    }

    @Test
    fun scorpioTest() {
        var month = 10
        for(i in 23..31){
            assertEquals("scorpio",Zodiac.getSignByDate(i.toString()+"."+month+"."+"1997"))
        }
        month = 11
        for(i in 1..21){
            assertEquals("scorpio",Zodiac.getSignByDate(i.toString()+"."+month+"."+"1997"))
        }
    }

    @Test
    fun signNameIdTest(){
        assertEquals(Zodiac.getSignId("aries"),2131558460)
        assertEquals(Zodiac.getSignId("taurus"),2131558469)
        assertEquals(Zodiac.getSignId("gemini"),2131558463)
        assertEquals(Zodiac.getSignId("cancer"),2131558461)
        assertEquals(Zodiac.getSignId("leo"),2131558464)
        assertEquals(Zodiac.getSignId("virgo"),2131558470)
        assertEquals(Zodiac.getSignId("libra"),2131558465)
        assertEquals(Zodiac.getSignId("scorpio"),2131558468)
        assertEquals(Zodiac.getSignId("sagittarius"),2131558467)
        assertEquals(Zodiac.getSignId("capricorn"),2131558462)
        assertEquals(Zodiac.getSignId("aquarius"),2131558459)
        assertEquals(Zodiac.getSignId("pisces"),2131558466)

    }
}