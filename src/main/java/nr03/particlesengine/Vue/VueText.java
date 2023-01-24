package nr03.particlesengine.Vue;

import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import static nr03.particlesengine.ParticleEngine.countTextInitOpacity;

public class VueText extends Text {

    private static double countTextCurrOpacity = countTextInitOpacity;
    AnimationTimer animationText;
    public VueText(){
        this.setText("Bienvenue dans le moteur de particules ! \nCréé par Nicolas R. \n\nCliquez ou faites glisser pour créer des particules !");
        this.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        this.setStyle("-fx-font: 24 arial;");
        this.setFill(Color.WHITE);
        animationText = new AnimationTimer() {
            @Override
            public void handle(long now) {
                countTextCurrOpacity--;
                setOpacity(countTextCurrOpacity / countTextInitOpacity);
                if(countTextCurrOpacity <= 0){
                    this.stop();
                }
            }
        };
        setStartAnimation();
    }

    public void setStartAnimation(){
        animationText.start();
        countTextCurrOpacity = countTextInitOpacity;
    }

}
