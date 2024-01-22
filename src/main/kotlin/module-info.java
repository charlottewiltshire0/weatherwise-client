module com.charlottewiltshire0.weatherwise {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires org.json;


    opens com.charlottewiltshire0.weatherwise to javafx.fxml;
    opens com.charlottewiltshire0.weatherwise.controllers to javafx.fxml;

    exports com.charlottewiltshire0.weatherwise;
    exports com.charlottewiltshire0.weatherwise.controllers;

}