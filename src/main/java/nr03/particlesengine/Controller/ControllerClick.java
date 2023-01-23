package nr03.particlesengine.Controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import nr03.particlesengine.ParticleEngine;
import nr03.particlesengine.Vue.VueClick;
import nr03.particlesengine.Vue.VueParticle;
import nr03.particlesengine.Vue.VueScreen;

public class ControllerClick implements EventHandler<MouseEvent> {

    private final VueScreen vS;

    public ControllerClick(VueScreen v){
        this.vS = v;
    }
    @Override
    public void handle(MouseEvent event) {
        Color color = Color.color(Math.random(), Math.random(), Math.random());
        vS.getChildren().add(new VueClick(event.getX(), event.getY(), color));
        color = color.brighter();
        for (int i = 0; i < ParticleEngine.NB_PARTICLES_CLICK; i++) {
            VueParticle vueParticle = new VueParticle(event.getX(), event.getY(), ParticleEngine.radiusBalls, Math.random() * 2 * Math.PI, Math.random() * 10, color);
            vS.getChildren().add(vueParticle);
            vS.getParticles().add(vueParticle);
        }
    }
}
