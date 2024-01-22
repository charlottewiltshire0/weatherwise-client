package com.charlottewiltshire0.weatherwise

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import javafx.stage.StageStyle

public class Launcher : Application() {
    override fun start(primaryStage: Stage) {
        val fxmlLoader = FXMLLoader(Launcher::class.java.getResource("views/Launcher.fxml"))
        val scene = Scene(fxmlLoader.load(), 375.0, 812.0)

        primaryStage.title = "WeatherWise"
        primaryStage.scene = scene

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
        primaryStage.setX(200.0);
        primaryStage.setY(200.0);

        primaryStage.show()
    }
}