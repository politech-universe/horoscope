package com.product.bugnado.horoscope

import android.annotation.SuppressLint


class Zodiac {
    @SuppressLint("SimpleDateFormat")

    companion object {
        fun getSignByDate(date: String?): String {
            var arr = date?.split(".")
            var s = HashMap<String,String>()
            return zodiacSign(arr!![0].toInt(), arr!![1].toInt())
        }

        fun getSignId(name: String?): Int {
            return getId(name)
        }



        private fun getId(name: String?): Int {
            when (name) {
                "aries" -> return R.string.name_aries
                "taurus" -> return R.string.name_taurus
                "gemini" -> return R.string.name_gemini
                "cancer" -> return R.string.name_cancer
                "leo" -> return R.string.name_leo
                "virgo" -> return R.string.name_virgo
                "libra" -> return R.string.name_libra
                "scorpio" -> return R.string.name_scorpio
                "sagittarius" -> return R.string.name_sagittarius
                "capricorn" -> return R.string.name_capricorn
                "aquarius" -> return R.string.name_aquarius
                "pisces" -> return R.string.name_pisces
            }
            return R.string.name_aries
        }


        private fun zodiacSign(day: Int, month: Int): String {


            var astro_sign = ""

            // checks month and date within the
            // valid range of a specified zodiac
            if (month == 12) {
                if (day < 22)
                    astro_sign = "sagittarius"
                else
                    astro_sign = "capricorn"
            } else if (month == 1) {
                if (day < 20)
                    astro_sign = "capricorn"
                else
                    astro_sign = "aquarius"
            } else if (month == 2) {
                if (day < 19)
                    astro_sign = "aquarius"
                else
                    astro_sign = "pisces"
            } else if (month == 3) {
                if (day < 21)
                    astro_sign = "pisces"
                else
                    astro_sign = "aries"
            } else if (month == 4) {
                if (day < 20)
                    astro_sign = "aries"
                else
                    astro_sign = "taurus"
            } else if (month == 5) {
                if (day < 21)
                    astro_sign = "taurus"
                else
                    astro_sign = "gemini"
            } else if (month == 6) {
                if (day < 21)
                    astro_sign = "gemini"
                else
                    astro_sign = "cancer"
            } else if (month == 7) {
                if (day < 23)
                    astro_sign = "cancer"
                else
                    astro_sign = "leo"
            } else if (month == 8) {
                if (day < 23)
                    astro_sign = "leo"
                else
                    astro_sign = "virgo"
            } else if (month == 9) {
                if (day < 23)
                    astro_sign = "virgo"
                else
                    astro_sign = "libra"
            } else if (month == 10) {
                if (day < 23)
                    astro_sign = "libra"
                else
                    astro_sign = "scorpio"
            } else if (month == 11) {
                if (day < 22)
                    astro_sign = "scorpio"
                else
                    astro_sign = "sagittarius"
            }

            return (astro_sign)
        }


    }
}
