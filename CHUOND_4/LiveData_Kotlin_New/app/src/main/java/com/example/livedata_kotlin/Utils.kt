package com.example.livedata_kotlin

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

object Utils {
    private const val format = "dd/MM/yyyy"
    private val dateFormat = SimpleDateFormat(format)
    fun stringToDate(dateStr: String): Date {
        return try {
            dateFormat.parse(dateStr)!!
        } catch (_: ParseException){
            Date()
        }
    }
    fun dateToString(date: Date): String{
        return dateFormat.format(date)
    }
}