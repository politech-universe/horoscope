package com.product.bugnado.horoscope


import org.junit.Assert
import org.junit.Test
import org.powermock.api.mockito.PowerMockito
import android.os.AsyncTask
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.junit.Before
import org.robolectric.shadows.ShadowLooper
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit.MILLISECONDS
import org.powermock.modules.junit4.PowerMockRunner
import org.robolectric.shadows.ShadowApplication
import android.R.attr.countDown
import java.util.concurrent.CountDownLatch


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class DreamerTests {

    @Test
    fun dreamerDefaultValuesTest() {
        var dreamer = Dreamer()
        Assert.assertEquals(dreamer.date, "10.10.2010")
        Assert.assertEquals(dreamer.name, "Vadim")
    }
}