package nr03.particlesengine.Vue;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import nr03.particlesengine.Model.ModeleParticle;
import nr03.particlesengine.ParticleEngine;

public class VueParticle extends Circle {

    public ModeleParticle particle;
    public boolean valide;

    public VueParticle(double x, double y, double radius, double direction, double speed) {
        super(x, y, radius);
        particle = new ModeleParticle(x, y, direction, speed);
        Color color = Color.color(Math.random(), Math.random(), Math.random());
        color = color.saturate();
        this.setFill(color);
        this.valide = true;
    }

    public VueParticle(double x, double y, double radius, double direction, double speed, Color c) {
        super(x, y, radius);
        particle = new ModeleParticle(x, y, direction, speed);
        this.setFill(c);
        this.valide = true;
    }

    public void setStretch() {
        setScaleY(Math.abs(particle.speedY / 10));
        if (getScaleY() < 1) {
            setScaleY(1);
        }
        setRotate(particle.speedX);
    }

    public void setOpacityVue() {
        setOpacity(Math.abs(particle.speedX / particle.initSpeedX));
        if (getOpacity() < 0.1) {
            setOpacity(0);
            this.valide = false;
        }
    }

    public void update() {
        if (valide) {
            particle.update();
            setCenterX(particle.x);
            setCenterY(particle.y);
            setStretch();
            setOpacityVue();
        }
    }

    public void changeRadius(double r) {
        setRadius(getRadius() + r);
    }
}
