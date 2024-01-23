package com.charlottewiltshire0.weatherwise

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import javafx.stage.Screen
import javafx.stage.StageStyle
import javafx.geometry.Rectangle2D

public class Launcher : Application() {
    override fun start(primaryStage: Stage) {
        val fxmlLoader = FXMLLoader(Launcher::class.java.getResource("views/Launcher.fxml"))
        val scene = Scene(fxmlLoader.load(), 375.0, 812.0)
        val screenBounds: Rectangle2D = Screen.getPrimary().bounds
        primaryStage.title = "WeatherWise"
        primaryStage.scene = scene

        val width = 375.0 // Установите требуемую ширину окна
        val height = 812.0 // Установите требуемую высоту окна

        // Установите координаты так, чтобы окно открывалось справа снизу
        val x = screenBounds.maxX - width
        val y = screenBounds.maxY - height

        primaryStage.x = x
        primaryStage.y = y
        primaryStage.width = width
        primaryStage.height = height

        // Установка стиля окна без декораций
        primaryStage.initStyle(StageStyle.UNDECORATED)

        /* Подключаем CSS */
        val weatherCssUrl = javaClass.classLoader.getResource("style/css/weather.css")
        val fontsCssUrl = javaClass.classLoader.getResource("style/css/fonts.css")

        if (weatherCssUrl != null && fontsCssUrl != null) {
            scene.stylesheets.addAll(
                weatherCssUrl.toExternalForm(),
                fontsCssUrl.toExternalForm()
            )
        }

        primaryStage.show()
    }
}