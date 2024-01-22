package com.charlottewiltshire0.weatherwise.core.utils

import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

fun getLocation(): String {
    val url = URL("https://api.geoapify.com/v1/ipinfo?apiKey=${System.getenv("GEOAPIFY_APIKEY")}")
    val connection = url.openConnection() as HttpURLConnection

    try {
        val reader = BufferedReader(InputStreamReader(connection.inputStream))
        val response = StringBuilder()

        var line: String?
        while (reader.readLine().also { line = it } != null) {
            response.append(line)
        }

        val jsonResponse = response.toString()

        return jsonResponse

    } finally {
        connection.disconnect()
    }
}

fun getCity(response: String): String {
    val jsonObject = JSONObject(response)
    val cityObject = jsonObject.getJSONObject("city")
    return cityObject.getString("name")
}

fun getCountry(response: String): String {
    val jsonObject = JSONObject(response)
    val cityObject = jsonObject.getJSONObject("country")
    return cityObject.getString("name")
}