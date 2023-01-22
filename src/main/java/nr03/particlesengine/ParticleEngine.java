package nr03.particlesengine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nr03.particlesengine.Vue.VueScreen;

import java.io.IOException;

public class ParticleEngine extends Application {

    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    @Override
    public void start(Stage stage) throws IOException {
        VueScreen particleScreen = new VueScreen();
        Scene scene = new Scene(particleScreen, WIDTH, HEIGHT);;
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}