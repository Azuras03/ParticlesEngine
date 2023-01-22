package nr03.particlesengine.Vue;

import javafx.animation.AnimationTimer;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class VueClick extends Circle {

    public double opacity;

    public VueClick(double x, double y, Color c){
        this.setFill(c);
        this.setCenterX(x);
        this.setCenterY(y);
        this.setRadius(30);
        this.opacity = 100;
        AnimationTimer an = new AnimationTimer() {
            @Override
            public void handle(long now) {
                opacity = opacity - 5;
                setOpacityClick();
            }
        };
        an.start();
    }

    public void setOpacityClick(){
        this.setOpacity(opacity/100);
    }

}
