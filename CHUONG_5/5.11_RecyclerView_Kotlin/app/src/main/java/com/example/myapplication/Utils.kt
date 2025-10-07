package com.example.myapplication

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Utils {
    private const val DATE_FORMAT = "dd/MM/yyyy"
    private val dateFormatter = SimpleDateFormat(DATE_FORMAT, Locale.US)

    fun getAvatar(gender: String): Int {
        return when (gender.lowercase()) {
            "nam" -> R.drawable.ic_man
            else -> R.drawable.ic_woman
        }
    }

    fun stringToDate(value: String): Date {
        return try {
            dateFormatter.parse(value) ?: Date()
        } catch (e: Exception) {
            Date()
        }
    }
}