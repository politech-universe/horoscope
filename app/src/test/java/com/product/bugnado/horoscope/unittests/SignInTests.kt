package com.product.bugnado.horoscope.unittests

import android.app.Application
import android.content.Context
import android.opengl.Visibility
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.product.bugnado.horoscope.Horoscope
import com.product.bugnado.horoscope.R
import com.product.bugnado.horoscope.SignIn
import junit.framework.Assert.*
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.not
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

@RunWith(RobolectricTestRunner::class)
class SignInTests {


    private var activity: SignIn? = null

    private var name: EditText? = null
    private var date: EditText? = null

    @Before
    fun setup() {
        activity = Robolectric.buildActivity(SignIn::class.java)
            .create().get()

        name = activity!!.findViewById(R.id.textNameInput) as EditText
        date = activity!!.findViewById(R.id.textDateInput) as EditText
    }

    @Test
    @Throws(Exception::class)
    fun checkActivityNotNull() {
        assertNotNull(activity)
        assertNotNull(name)
        assertNotNull(date)
    }

    @Test
    @Throws(Exception::class)
    fun checkContinue() {
        name?.setText("HELLO")
        val button = activity!!.findViewById<View>(R.id.buttonContinue) as Button
        button.performClick()
        val intent = Shadows.shadowOf(activity!!).peekNextStartedActivity()
        assertEquals(Horoscope::class.java!!.canonicalName, intent.component!!.className)
    }

    @Test
    @Throws(Exception::class)
    fun checkContinueNameCaution() {
        val button = activity!!.findViewById<View>(R.id.buttonContinue) as Button
        button.performClick()
        val nameCaution = activity!!.findViewById<View>(R.id.textNameMissing) as TextView
        assertEquals(nameCaution.visibility,View.VISIBLE)
    }

    @Test
    @Throws(Exception::class)
    fun checkEmptyDateCaution() {
        name?.setText("HELLO")
        date?.setText("")
        val button = activity!!.findViewById<View>(R.id.buttonContinue) as Button
        button.performClick()
        val dateCaution = activity!!.findViewById<View>(R.id.textDateMissing) as TextView
        assertEquals(dateCaution.visibility,View.VISIBLE)
    }

    @Test
    @Throws(Exception::class)
    fun checkEmptyDateEmptyNameCaution() {
        date?.setText("")
        val button = activity!!.findViewById<View>(R.id.buttonContinue) as Button
        button.performClick()
        val dateCaution = activity!!.findViewById<View>(R.id.textDateMissing) as TextView
        assertEquals(dateCaution.visibility,View.INVISIBLE)
        val nameCaution = activity!!.findViewById<View>(R.id.textNameMissing) as TextView
        assertEquals(nameCaution.visibility,View.VISIBLE)
    }

    @Test
    @Throws(Exception::class)
    fun checkVK() {
        val button = activity!!.findViewById<View>(R.id.buttonVk) as Button
        button.performClick()
    }



}

