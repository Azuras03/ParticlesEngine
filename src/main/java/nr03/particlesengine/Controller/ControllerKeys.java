package nr03.particlesengine.Controller;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import nr03.particlesengine.Model.ModeleParticle;
import nr03.particlesengine.ParticleEngine;
import nr03.particlesengine.Vue.VueScreen;
import nr03.particlesengine.Vue.VueText;

public class ControllerKeys implements EventHandler<KeyEvent> {

    private final VueScreen rootScreen;
    private final AnimationTimer animationTimer;
    private boolean ZA_WARUDO = false;

    private final VueText text;

    public ControllerKeys(VueScreen rootScreen, VueText text, AnimationTimer an) {
        this.rootScreen = rootScreen;
        this.text = text;
        this.animationTimer = an;
    }

    @Override
    public void handle(KeyEvent event) {
        text.setStartAnimation();
        switch (event.getCode()) {
            case ESCAPE:
                rootScreen.removeAll();
                text.setText("Tout a été retiré. Pouf !");
                break;
            case RIGHT:
                rootScreen.changeInitRadius(5);
                text.setText("Rayon des particules augmenté de 5px (" + ParticleEngine.radiusBalls + "px). Huge !");
                break;
            case LEFT:
                rootScreen.changeInitRadius(-5);
                text.setText("Rayon des particules diminué de 5px (" + ParticleEngine.radiusBalls + "px). Smol !");
                break;
            case UP:
                ModeleParticle.GRAVITY--;
                text.setText("Gravité diminuée de 1 (" + ModeleParticle.GRAVITY + "). Gravity is a myth !");
                break;
            case DOWN:
                ModeleParticle.GRAVITY++;
                text.setText("Gravité augmentée de 1 (" + ModeleParticle.GRAVITY + "). Gravity is real !");
                break;
            case SPACE:
                if (ZA_WARUDO) {
                    ZA_WARUDO = false;
                    animationTimer.start();
                    text.setText("ZA WARUDO a été désactivé. Time is back to normal.");
                } else {
                    ZA_WARUDO = true;
                    animationTimer.stop();
                    text.setText("Animation arrêtée. C'est la fin du monde !");
                }
                break;
        }    }
}
