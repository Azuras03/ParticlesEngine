package nr03.particlesengine;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nr03.particlesengine.Vue.VueScreen;

import java.io.IOException;

public class ParticleEngine extends Application {

    public static int WIDTH = 1280;
    public static int HEIGHT = 720;
    @Override
    public void start(Stage stage) throws IOException {
        VueScreen particleScreen = new VueScreen();
        Scene scene = new Scene(particleScreen, WIDTH, HEIGHT);;
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                WIDTH = (int) scene.getWidth();
                HEIGHT = (int) scene.getHeight();
                particleScreen.updateAll();
            }
        };
        animationTimer.start();

    }

    public static void main(String[] args) {
        launch();
    }
}