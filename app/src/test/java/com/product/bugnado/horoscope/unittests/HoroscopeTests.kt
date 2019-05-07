package com.product.bugnado.horoscope.unittests

import android.app.Application
import android.content.Context
import android.opengl.Visibility
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import com.product.bugnado.horoscope.Dreamer
import com.product.bugnado.horoscope.Horoscope
import com.product.bugnado.horoscope.R
import com.product.bugnado.horoscope.SignIn
import junit.framework.Assert.*
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.not
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.robolectric.Robolectric
import org.robolectric.Robolectric.buildActivity
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows
import org.robolectric.annotation.Config
import org.w3c.dom.Text

@RunWith(RobolectricTestRunner::class)
class HoroscopeTests {

    private var activity: Horoscope? = null

    private var name: TextView? = null

    @Before
    fun setup() {
        activity = Robolectric.buildActivity(Horoscope::class.java)
            .create().get()
        name = activity!!.findViewById(R.id.username) as TextView
    }

    @Test
    @Throws(Exception::class)
    fun checkActivityNotNull() {
        assertNotNull(activity)
    }

    @Test
    @Throws(Exception::class)
    fun checkRightUserName() {
        assertEquals(name?.text, "Vadim")
    }


    @Test
    @Throws(Exception::class)
    fun checkDreamerWay() {
        val button = activity!!.findViewById<View>(R.id.b2) as Button
        button.performClick()
        val intent = Shadows.shadowOf(activity!!).peekNextStartedActivity()
        assertEquals(Dreamer::class.java!!.canonicalName, intent.component!!.className)
    }

    @Test
    @Throws(Exception::class)
    fun checkSpinner() {
        val spinner = activity!!.findViewById<View>(R.id.spinner) as Spinner
        assertNotNull(spinner)
        assertEquals(spinner.selectedItem.toString(),"на сегодня")
    }


}

