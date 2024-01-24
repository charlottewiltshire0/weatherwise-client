package com.charlottewiltshire0.weatherwise

import com.charlottewiltshire0.weatherwise.core.*
import com.charlottewiltshire0.weatherwise.core.weather.getForecast
import javafx.application.Application

fun main(args: Array<String>) {
    println(getForecast())
    Application.launch(Launcher::class.java, *args)
}