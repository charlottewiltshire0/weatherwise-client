package com.charlottewiltshire0.weatherwise.core.weather

import com.charlottewiltshire0.weatherwise.core.utils.getCity
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

fun getCurrent(city: String = getCity()): String {
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

fun getTemp_c(response: String = getCurrent()): Int {
    val jsonObject = JSONObject(response)
    val cityObject = jsonObject.getJSONObject("current")
    return cityObject.getFloat("temp_c").toInt()
}

fun getUV(response: String = getCurrent()): Int {
    val jsonObject = JSONObject(response)
    val cityObject = jsonObject.getJSONObject("current")
    return cityObject.getFloat("uv").toInt()
}

fun getPm25(response: String = getCurrent()): Double {
    val jsonObject = JSONObject(response)
    val pm25Value = jsonObject.getJSONObject("current").getJSONObject("air_quality").getDouble("pm2_5")
    return pm25Value
}
