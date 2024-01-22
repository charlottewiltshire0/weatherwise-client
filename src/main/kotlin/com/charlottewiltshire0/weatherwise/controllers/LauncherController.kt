package com.charlottewiltshire0.weatherwise.controllers

import javafx.fxml.FXML
import javafx.stage.Stage
import javafx.scene.control.Label

class LauncherController {

    @FXML
    private lateinit var label: Label

    fun initialize() {
        // Добавление слушателя событий перемещения окна
        stage.xProperty().addListener { _, _, newValue ->
            updateLabelText(newValue.toDouble(), stage.y)
        }

        stage.yProperty().addListener { _, _, newValue ->
            updateLabelText(stage.x, newValue.toDouble())
        }
    }

    private fun updateLabelText(x: Double, y: Double) {
        label.text = "Coordinates: X=$x, Y=$y"
    }

    companion object {
        lateinit var stage: Stage
    }
}