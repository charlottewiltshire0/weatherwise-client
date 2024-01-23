package com.charlottewiltshire0.weatherwise.core.weather

import com.charlottewiltshire0.weatherwise.core.utils.getCity
import com.charlottewiltshire0.weatherwise.core.utils.getLocation
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

fun getDegree(city: String = getCity()): String {
    val url = URL("http://api.weatherapi.com/v1/current.json?key=${System.getenv("WEATHERAPI_APIKEY")}&q=$city&aqi=no")
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

fun getTemp_c(response: String = getDegree()): Int {
    val jsonObject = JSONObject(response)
    val cityObject = jsonObject.getJSONObject("current")
    return cityObject.getFloat("temp_c").toInt()
}

