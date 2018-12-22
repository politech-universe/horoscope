package com.product.bugnado.horoscope

import android.app.Activity
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.TextView

import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*
import android.content.Intent
import com.vk.sdk.VKScope
import com.vk.sdk.VKSdk
import com.vk.sdk.api.VKApi
import com.vk.sdk.api.VKApiConst
import com.vk.sdk.api.VKParameters
import com.vk.sdk.api.VKRequest
import com.vk.sdk.api.VKError
import com.vk.sdk.api.VKResponse
import com.vk.sdk.api.VKRequest.VKRequestListener
import org.json.JSONObject
import java.lang.Exception


class SignIn : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        initCalendarPicker()
    }


    private fun initCalendarPicker() {
        var textDateInput: TextView = findViewById(R.id.textDateInput)

        textDateInput.text = SimpleDateFormat("dd.MM.yyyy").format(System.currentTimeMillis())

        var cal = Calendar.getInstance()

        val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd.MM.yyyy"
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            textDateInput.text = sdf.format(cal.time)

        }

        textDateInput.setOnClickListener {
            DatePickerDialog(this@SignIn, dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
        }

    }

    public fun message(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show()
    }

    public fun onClickContinue(view: View) {
        var textDateInput: TextView = findViewById(R.id.textDateInput)
        var textNameInput: TextView = findViewById(R.id.textNameInput)
        var textNameMissing: TextView = findViewById(R.id.textNameMissing)
        var textDateMissing: TextView = findViewById(R.id.textDateMissing)
        var name: String = textNameInput.text.toString()
        var date: String = textDateInput.text.toString()
        if (name == "") {
            textNameMissing.visibility = View.VISIBLE
        } else if (date == "") {
            textDateMissing.visibility = View.VISIBLE
        } else {
            val intent = Intent(this, Horoscope::class.java).apply {
                putExtra("DATE", date)
                putExtra("NAME", name)
            }
            startActivity(intent)
        }
    }

    public fun onClickVK(view: View) {
        VKSdk.login(this)
        var name: String = ""
        var lname: String = ""
        var date: String = ""
        var textNameInput: TextView = findViewById(R.id.textNameInput)
        var textDateInput: TextView = findViewById(R.id.textDateInput)

        var request: VKRequest = VKRequest("account.getProfileInfo", VKParameters.from(VKApiConst.FIELDS, "first_name,bdate"));
        request.executeWithListener(object : VKRequestListener() {
            override fun onComplete(response: VKResponse?) {

                var resp: JSONObject = response!!.json
                name = resp.getJSONObject("response").getString("first_name")
                date = resp.getJSONObject("response").getString("bdate")
                lname = resp.getJSONObject("response").getString("last_name")
                textNameInput.text = name + " " + lname
                textDateInput.text = date

            }

            override fun onError(error: VKError?) {
            }

            override fun attemptFailed(request: VKRequest?, attemptNumber: Int, totalAttempts: Int) {
            }
        })
    }

}
