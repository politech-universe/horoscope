package com.product.bugnado.horoscope

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import android.os.AsyncTask
import android.text.method.LinkMovementMethod
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import android.widget.Spinner
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.text.Html
import java.util.*


class Horoscope : AppCompatActivity() {
    var date: String = "10.10.2010"
    var name: String = "Vadim"
    var time: String = ""
    var url: String = ""
    private var curSign: String = "sagittarius"
    lateinit var prediction: TextView
    lateinit var source: TextView
    lateinit var spinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horoscope)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        var textSign: TextView = findViewById(R.id.textSign)
        var textName: TextView = findViewById(R.id.username)

        val spinner = findViewById<View>(R.id.spinner) as Spinner
        spinner.setSelection(1)

        url = getString(R.string.res_rambler)

        date = intent.getStringExtra("DATE")
        name = intent.getStringExtra("NAME")

        curSign = Zodiac.getSignByDate(date)
        textSign.text = getString(Zodiac.getSignId(curSign))
        textName.text = name

        source = findViewById(R.id.text_resource)
        prediction = findViewById(R.id.text_prediction)

        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View,
                                        position: Int, id: Long) {
                Toast.makeText(baseContext, spinner.selectedItem.toString(), Toast.LENGTH_SHORT).show()
                time = getTimeUrl(spinner.selectedItem.toString())
                AsyncReqExec()
            }

            override fun onNothingSelected(arg0: AdapterView<*>) {}
        }
        AsyncReqExec()
    }

    private fun AsyncReqExec(){
        source.text = ""
        prediction.text = ""
        AsyncRequest().execute()

    }

    public fun onClickSlipper(view: View) {
        val intent = Intent(this, Dreamer::class.java).apply {
            putExtra("DATE", date)
            putExtra("NAME", name)

        }
        startActivity(intent)
    }

    public fun onClickName(view: View) {
        curSign = Zodiac.getSignByDate(date)
        onSignChange(curSign, getString(Zodiac.getSignId(curSign)))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.signs_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        Toast.makeText(this, item?.title.toString(), Toast.LENGTH_LONG).show()

        onSignChange(item?.titleCondensed.toString(), item?.title.toString())

        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("StaticFieldLeak")
    internal inner class AsyncRequest : AsyncTask<String, Int, String>() {
        lateinit var title: String
        override fun doInBackground(vararg arg: String): String {
            var doc: Document? = null
            try {
                doc = Jsoup.connect("$url/$curSign/$time").get()
            } catch (e: Exception) {
                return getString(R.string.missing_prediction)
            }
            title = if (doc != null) {
                var el: Elements = doc.getElementsByClass("_1dQ3")
                el[0].getElementsByTag("span").text()
            }
            else
                getString(R.string.missing_prediction)
            return title
        }


        override fun onPostExecute(s: String) {
            if (s == getString(R.string.missing_prediction)){
                source.text = getString(R.string.missing_resource)+" " +url
            }else {
                source.isClickable = true
                val policy = Html.fromHtml(getString(R.string.text_rambler))
                source.text = policy
                source.movementMethod = LinkMovementMethod.getInstance()
            }
            prediction.text = s

        }
    }

    private fun onSignChange(name: String, localeName: String) {
        var textSign: TextView = findViewById(R.id.textSign)
        textSign.text = localeName
        curSign = name
        AsyncReqExec()

    }


    private fun getTimeUrl(name: String?): String {
        when (name) {
            getString(R.string.yesterday) -> return  "yesterday/"
            getString(R.string.today) -> return ""
            getString(R.string.tomorrow) -> return "tomorrow/"
            getString(R.string.weekly) ->return "weekly/"
            getString(R.string.monthly) ->return "monthly/"
            getString(R.string.year) ->return Calendar.getInstance().get(Calendar.YEAR).toString()+"/"
        }
        return ""
    }

}
