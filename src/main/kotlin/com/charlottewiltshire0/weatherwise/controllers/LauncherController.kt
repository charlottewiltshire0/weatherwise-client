package com.charlottewiltshire0.weatherwise.controllers

import com.charlottewiltshire0.weatherwise.core.utils.getCity
import com.charlottewiltshire0.weatherwise.core.weather.getTemp_c
import javafx.fxml.FXML
import javafx.scene.text.Text

class LauncherController {

    @FXML
    private lateinit var cityName: Text
    private lateinit var degreeC: Text

    fun initialize() {
        cityName.text = getCity()

        // Convert the String to Double before assigning
        degreeC = Text(getTemp_c().toString())
    }

}