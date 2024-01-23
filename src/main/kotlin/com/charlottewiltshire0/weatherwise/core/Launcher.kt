package com.charlottewiltshire0.weatherwise

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import javafx.stage.Screen
import javafx.stage.StageStyle
import javafx.geometry.Rectangle2D
import java.io.IOException

class Launcher : Application() {

    // Константы для ширины и высоты окна
    private inline val WINDOW_WIDTH get() = 360.0
    private inline val WINDOW_HEIGHT get() = 380.0

    override fun start(primaryStage: Stage) {
        try {
            // Загрузка FXML
            val fxmlLoader = FXMLLoader(Launcher::class.java.getResource("views/Launcher.fxml"))
            val scene = Scene(fxmlLoader.load(), WINDOW_WIDTH, WINDOW_HEIGHT)

            // Получаем размеры экрана
            val screenBounds: Rectangle2D = Screen.getPrimary().bounds

            // Конфигурация Stage с использованием with
            with(primaryStage) {
                title = "WeatherWise"
                this.scene = scene
                initStyle(StageStyle.UNDECORATED)

                // Размещение окна в правом нижнем углу экрана над панелью задач
                val x = screenBounds.maxX - WINDOW_WIDTH
                val y = screenBounds.maxY - WINDOW_HEIGHT + getTaskbarHeight()
                this.x = x
                this.y = y
                width = WINDOW_WIDTH
                height = WINDOW_HEIGHT
            }

            /* Подключаем CSS */
            val weatherCssUrl = javaClass.classLoader.getResource("style/css/weather.css")

            if (weatherCssUrl != null) {
                scene.stylesheets.addAll(weatherCssUrl.toExternalForm())
            }

            // Отображение Stage
            primaryStage.show()

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    // Функция для получения высоты панели задачи
    private fun getTaskbarHeight(): Double {
        val screenBounds: Rectangle2D = Screen.getPrimary().visualBounds
        return screenBounds.height - Screen.getPrimary().bounds.height
    }
}