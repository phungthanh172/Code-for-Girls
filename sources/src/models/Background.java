package models;

import utils.*;

import java.awt.*;

/**
 * Created by Hau on 06/08/2016.
 */
public class Background {
    private int x;
    private int y;
    private int speedX;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public Background(int x, int y) {
        this.x = x;
        this.y = y;
        this.speedX = 0;

    }

    public void update() {
        x += speedX;
        if (x <= -GameSetting.getInstance().getScreenWidth()) {
            x += 2 * GameSetting.getInstance().getScreenWidth();
        }
    }
}
