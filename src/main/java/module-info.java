module nr03.particlesengine {
    requires javafx.controls;
    requires javafx.fxml;


    opens nr03.particlesengine to javafx.fxml;
    exports nr03.particlesengine;
}