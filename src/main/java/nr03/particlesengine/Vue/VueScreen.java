package nr03.particlesengine.Vue;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import nr03.particlesengine.Controller.ControllerClick;
import nr03.particlesengine.Controller.ControllerDrag;
import nr03.particlesengine.ParticleEngine;

import java.util.ArrayList;

public class VueScreen extends Pane {

    public ArrayList<VueParticle> particles = new ArrayList<>();

    public VueScreen() {
        this.setStyle("-fx-background-color: #000000");
        ControllerClick cC = new ControllerClick(this);
        ControllerDrag cD = new ControllerDrag(this);
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, cC);
        this.addEventHandler(MouseEvent.MOUSE_DRAGGED, cD);
    }

    public void update(VueParticle vueParticle) {
        vueParticle.update();
        if(!vueParticle.valide){
            this.getChildren().remove(vueParticle);
        }
    }

    public void updateAll(){
        for (VueParticle particle : particles) {
            update(particle);
        }
        this.setWidth(ParticleEngine.WIDTH);
        this.setHeight(ParticleEngine.HEIGHT);
    }

    public void removeAll() {
        this.getChildren().removeAll(particles);
        particles.clear();
    }

    public void changeInitRadius(double r){
        if(ParticleEngine.radiusBalls + r > 0){
            ParticleEngine.radiusBalls += r;
        }
    }

    public void changeRadius(double r){
        for (VueParticle particle : particles) {
            particle.changeRadius(r);
        }
    }

    public ArrayList<VueParticle> getParticles(){
        return particles;
    }

}
