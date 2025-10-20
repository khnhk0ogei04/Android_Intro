package com.example.myapplication.utils

import android.icu.text.DecimalFormat
import com.example.myapplication.R

object CountryUtils {
    fun getDrawableResource(countryFlag: String): Int {
        val flag = countryFlag.split(".").first()
        return when (flag) {
            "china" -> R.drawable.china
            "india" -> R.drawable.india
            "united_states" -> R.drawable.united_states
            "indonesia" -> R.drawable.indonesia
            "pakistan" -> R.drawable.pakistan
            "brazil" -> R.drawable.brazil
            "nigeria" -> R.drawable.nigeria
            "bangladesh" -> R.drawable.bangladesh
            "russia" -> R.drawable.russia
            "mexico" -> R.drawable.mexico
            "japan" -> R.drawable.japan
            "ethiopia" -> R.drawable.ethiopia
            "philippines" -> R.drawable.philippines
            "egypt" -> R.drawable.egypt
            "vietnam" -> R.drawable.vietnam
            "dr_congo" -> R.drawable.dr_congo
            else -> R.drawable.vietnam
        }
    }

    fun formatNumber(number: Float): String {
        val formatter = DecimalFormat("#,###.#")
        return formatter.format(number)
    }
}