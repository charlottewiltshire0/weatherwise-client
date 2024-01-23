package com.charlottewiltshire0.weatherwise

import com.charlottewiltshire0.weatherwise.core.*
import com.charlottewiltshire0.weatherwise.core.weather.getDegree
import com.charlottewiltshire0.weatherwise.core.weather.getTemp_c
import javafx.application.Application

fun main(args: Array<String>) {
    println(getTemp_c())
    Application.launch(Launcher::class.java, *args)
}