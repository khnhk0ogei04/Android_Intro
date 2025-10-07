package com.example.myapplication

import android.content.Context
import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.StringWriter
import java.nio.charset.StandardCharsets

class LocalDataSource(
    private val context: Context
) {
    fun loadStudents(): List<Student> {
        val jsonString = getJsonFromFile()
        var mapper = jacksonObjectMapper()
        try {
            return mapper.readValue(jsonString, Array<Student>::class.java).toList()
        } catch (_: JsonParseException) {
            return emptyList()
        }
    }

    private fun getJsonFromFile(): String {
        val writer = StringWriter()
        val buffer = CharArray(1024)
        try {
            context.resources.openRawResource(R.raw.student).use{ inputStream ->
                val reader = BufferedReader(InputStreamReader(inputStream, StandardCharsets.UTF_8))
                var size: Int
                while (reader.read(buffer).also { size = it } != -1) {
                    writer.write(buffer, 0, size)
                }
            }
        } catch (_: IOException) {}
        return writer.toString()
    }
}
