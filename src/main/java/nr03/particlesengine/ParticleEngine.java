package nr03.particlesengine;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import nr03.particlesengine.Controller.ControllerKeys;
import nr03.particlesengine.Vue.VueScreen;
import nr03.particlesengine.Vue.VueText;

import java.io.IOException;

public class ParticleEngine extends Application {

    // Set the initial resolution hehe !
    public static int WIDTH = 1280;
    public static int HEIGHT = 720;

    // Set the counter for the text to be shown :)
    public static final double countTextInitOpacity = 150;

    // Set the initial radius as the particles, called here  b a l l s
    public static double radiusBalls = 5;

    // Set the number of particles you will make when you click
    public static int NB_PARTICLES_CLICK = 50;

    // Set the number of particles you will make when you drag your mouse
    public static int NB_PARTICLES_DRAG = 5;

    // Set the key bindings :]
    public static final KeyCode REMOVE_ALL_PARTICLES = KeyCode.ESCAPE;
    public static final KeyCode INCREASE_RADIUS_BALLS = KeyCode.RIGHT;
    public static final KeyCode DECREASE_RADIUS_BALLS = KeyCode.LEFT;
    public static final KeyCode DECREASE_GRAVITY = KeyCode.UP;
    public static final KeyCode INCREASE_GRAVITY = KeyCode.DOWN;
    public static final KeyCode PAUSE = KeyCode.SPACE;

    @Override
    public void start(Stage stage) throws IOException {

        StackPane root = new StackPane();

        VueScreen rootScreen = new VueScreen();

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        ;
        stage.setTitle("Particles Engine ✨");
        stage.setScene(scene);
        root.getChildren().add(rootScreen);
        stage.show();
        VueText text = new VueText();
        root.getChildren().add(text);

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                WIDTH = (int) scene.getWidth();
                HEIGHT = (int) scene.getHeight();
                rootScreen.updateAll();
            }
        };
        animationTimer.start();

        ControllerKeys cK = new ControllerKeys(rootScreen, text, animationTimer);
        stage.addEventHandler(KeyEvent.KEY_PRESSED, cK);

    }

    public static void main(String[] args) {
        launch();
    }
}