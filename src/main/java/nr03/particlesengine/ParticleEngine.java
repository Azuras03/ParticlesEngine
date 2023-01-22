package nr03.particlesengine;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import nr03.particlesengine.Vue.VueScreen;

import java.io.IOException;

public class ParticleEngine extends Application {

    public static int WIDTH = 1280;
    public static int HEIGHT = 720;

    public static final double countTextInitOpacity = 150;
    public static double countTextCurrOpacity = countTextInitOpacity;
    public static double radiusBalls = 5;

    @Override
    public void start(Stage stage) throws IOException {

        StackPane root = new StackPane();

        VueScreen rootScreen = new VueScreen();

        Scene scene = new Scene(root, WIDTH, HEIGHT);;
        stage.setTitle("Particles Engine ✨");
        stage.setScene(scene);
        root.getChildren().add(rootScreen);
        stage.show();
        Text text = new Text("Bienvenue dans le moteur de particules ! \nCréé par Nicolas R. \n\nCliquez ou faites glisser pour créer des particules !");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setStyle("-fx-font: 24 arial;");
        text.setFill(Color.WHITE);
        root.getChildren().add(text);
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                WIDTH = (int) scene.getWidth();
                HEIGHT = (int) scene.getHeight();
                rootScreen.updateAll();
                countTextCurrOpacity--;
                text.setOpacity(countTextCurrOpacity/countTextInitOpacity);
            }
        };
        animationTimer.start();

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case ESCAPE:
                    rootScreen.removeAll();
                    text.setText("Tout a été retiré. Pouf !");
                    break;
                case UP:
                    rootScreen.changeInitRadius(5);
                    text.setText("Rayon des particules augmenté de 5px ("+ radiusBalls +"px). Huge !");
                    break;
                case DOWN:
                    rootScreen.changeInitRadius(-5);
                    text.setText("Rayon des particules diminué de 5px ("+ radiusBalls +"px). Smol !");
                    break;
            }
            countTextCurrOpacity = countTextInitOpacity;
        });

    }

    public static void main(String[] args) {
        launch();
    }
}