package nr03.particlesengine.Model;

import nr03.particlesengine.ParticleEngine;

public class ModeleParticle {

    public double x;
    public double y;
    public double speedX;
    public double speedY;

    public double initSpeedX;
    public double initSpeedY;

    public static double GRAVITY = 1;
    public static final double AIR_RESISTANCE = 0.99;

    public ModeleParticle(double x, double y, double direction, double speed) {
        this.x = x;
        this.y = y;
        this.speedX = speed * Math.cos(direction);
        this.speedY = speed * Math.sin(direction);
        this.initSpeedX = speedX;
        this.initSpeedY = speedY;
    }

    public void update() {
        bounce();
        x += speedX;
        y += speedY;
        speedY += GRAVITY;
        speedY *= AIR_RESISTANCE;
        speedX *= AIR_RESISTANCE;
    }

    public boolean bounce() {
        boolean bounced = false;
        if (x < 0 || x > ParticleEngine.WIDTH) {
            speedX = -speedX + 1;
            bounced = true;
        }
        if (y < 0 || y > ParticleEngine.HEIGHT) {
            speedY = -speedY + 1;
            bounced = true;
        }
        return bounced;
    }

}
