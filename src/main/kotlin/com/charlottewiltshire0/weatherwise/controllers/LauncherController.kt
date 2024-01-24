package com.charlottewiltshire0.weatherwise.controllers

import com.charlottewiltshire0.weatherwise.core.utils.getCity
import com.charlottewiltshire0.weatherwise.core.weather.getTemp_c
import com.charlottewiltshire0.weatherwise.core.weather.getUV
import com.charlottewiltshire0.weatherwise.core.weather.getRain
import com.charlottewiltshire0.weatherwise.core.utils.getCurrentTimeWithAMPM
import javafx.fxml.FXML
import javafx.scene.text.Text
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

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

    private val scheduler: ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()

    @FXML
    fun initialize() {
        // Schedule the update task to run every 1 minute
        scheduler.scheduleAtFixedRate(::updateData, 0, 1, TimeUnit.MINUTES)
    }

    private fun updateData() {
        cityName.text = getCity()
        degreeC.text = getTemp_c().toString()
        UV.text = getUV().toString()
        rainChange.text = getRain().toString() + "%"
        time.text = getCurrentTimeWithAMPM()
    }

    // Remember to shutdown the scheduler when the application closes
    fun onClose() {
        scheduler.shutdown()
    }
}
