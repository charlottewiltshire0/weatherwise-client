package com.charlottewiltshire0.weatherwise.controllers

import com.charlottewiltshire0.weatherwise.core.utils.getCity
import com.charlottewiltshire0.weatherwise.core.weather.getTemp_c
import com.charlottewiltshire0.weatherwise.core.weather.getUV
import com.charlottewiltshire0.weatherwise.core.weather.getRain
import com.charlottewiltshire0.weatherwise.core.utils.getCurrentTimeWithAMPM
import com.charlottewiltshire0.weatherwise.core.weather.getPm25
import javafx.fxml.FXML
import javafx.scene.text.Text

class LauncherController {

    @FXML
    private lateinit var cityName: Text

    @FXML
    private lateinit var degreeC: Text

    @FXML
    private lateinit var UV: Text

    @FXML
    private lateinit var rainChange: Text

    @FXML
    private lateinit var time: Text

    @FXML
    private lateinit var aq: Text

    @FXML
    fun initialize() {
        cityName.text = getCity()

        degreeC.text = getTemp_c().toString()

        UV.text = getUV().toString()

        rainChange.text = getRain().toString()  + "%"

        time.text = getCurrentTimeWithAMPM()

        aq.text = getPm25().toString()
    }
}
