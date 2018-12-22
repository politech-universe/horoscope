package com.product.bugnado.horoscope

import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.ScrollView
import android.widget.SearchView
import android.widget.TextView
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.io.IOException
import java.lang.Exception

class Dreamer : AppCompatActivity() {
    var date: String = "10.10.2010"
    var name: String = "Vadim"
    lateinit var url: String
    private lateinit var dreamRequest: String
    lateinit var search: SearchView
    lateinit var source: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resident_slipper)
        date = intent.getStringExtra("DATE")
        name = intent.getStringExtra("NAME")
        search = findViewById(R.id.text_search)
        search.queryHint = getString(R.string.enter_word)
        url = getString(R.string.res_rambler_slipper)

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                dreamRequest = search.query.toString()
                DreamsAsyncRequest().execute()
                source = findViewById(R.id.text_resource_slipper)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {

                return false
            }
        })



    }



    public fun onClickHoroscope(view: View) {
        val intent = Intent(this, Horoscope::class.java).apply {
            putExtra("DATE", date)
            putExtra("NAME", name)
        }
        startActivity(intent)
    }


    @SuppressLint("StaticFieldLeak")
    internal inner class DreamsAsyncRequest : AsyncTask<String, Int, String>() {
        lateinit var title: String
        override fun doInBackground(vararg arg: String): String {
            var doc: Document? = null
            try {
                doc = Jsoup.connect("$url/?book=-1&words=$dreamRequest").get()
            } catch (e: IOException) {
                return getString(R.string.missing_prediction)
            }
            title = if (doc != null) {
                var lst: Elements = doc.getElementsByClass("_359q")
                var txt: String = ""
                for (i in lst) {
                    txt += "<h2>" + i.getElementsByTag("h2").text() + "</h2>" +
                            "<p><i>" + i.getElementsByClass("_2Sj1").text().capitalize() + "</i></p>" +
                            "<p>" + i.getElementsByClass("_1dQ3").text().capitalize() + "</p><br />"
                }
                txt
            } else
                getString(R.string.missing_prediction)
            return title
        }

        override fun onPostExecute(s: String) {
            if (s == getString(R.string.missing_prediction)){
                source.text = getString(R.string.missing_resource)+" " +url
            }else {
                source.isClickable = true
                val policy = Html.fromHtml(getString(R.string.text_rambler_slipper))
                source.text = policy
                source.movementMethod = LinkMovementMethod.getInstance()
            }
            var textSign: TextView = findViewById(R.id.text_slipper)
            textSign.text = Html.fromHtml(s)

        }
    }
}


