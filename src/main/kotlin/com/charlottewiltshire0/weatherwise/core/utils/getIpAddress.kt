package com.charlottewiltshire0.weatherwise.core.utils

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import org.json.JSONObject

fun getIpAddress(): String {
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
        val jsonObject = JSONObject(jsonResponse)

        return jsonObject.getString("ip")
    } finally {
        connection.disconnect()
    }
}