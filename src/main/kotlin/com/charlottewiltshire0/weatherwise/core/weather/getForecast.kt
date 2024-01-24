package com.charlottewiltshire0.weatherwise.core.weather

import com.charlottewiltshire0.weatherwise.core.utils.getCity
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

fun getForecast(city: String = getCity()): String {
    val url = URL("http://api.weatherapi.com/v1/forecast.json?key=${System.getenv("WEATHERAPI_APIKEY")}&q=$city&aqi=no&days=1&aqi=no&alerts=no")
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

fun getRain(response: String = getForecast()): Int {
    val jsonObject = JSONObject(response)
    val forecastArray = jsonObject.getJSONObject("forecast").getJSONArray("forecastday")
    val firstForecast = forecastArray.getJSONObject(0)  // Assuming you want the first day's forecast
    return firstForecast.getJSONObject("day").getInt("daily_chance_of_rain")
}
