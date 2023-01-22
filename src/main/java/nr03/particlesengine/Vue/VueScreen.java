package nr03.particlesengine.Vue;

import javafx.animation.AnimationTimer;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import nr03.particlesengine.Controller.ControllerClick;

import java.util.ArrayList;

public class VueScreen extends Pane {

    public ArrayList<VueParticle> particles = new ArrayList<>();

    public VueScreen() {
        this.setStyle("-fx-background-color: #000000");
        ControllerClick cC = new ControllerClick(this);
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, cC);

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (VueParticle particle : particles) {
                    update(particle);
                }
            }
        };
        animationTimer.start();
    }

    public void update(VueParticle vueParticle) {
        vueParticle.update();
        if(!vueParticle.valide){
            this.getChildren().remove(vueParticle);
        }
    }

    public void removeAll() {
        this.getChildren().removeAll(particles);
        particles.clear();
    }

    public ArrayList<VueParticle> getParticles(){
        return particles;
    }

}
