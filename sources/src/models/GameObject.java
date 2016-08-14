package models;

import java.awt.*;

/**
 * Created by KhacThanh on 8/6/2016.
 */
public abstract class GameObject {

    protected float x;
    protected float y;
    protected int width;
    protected int height;

    protected boolean isAlive;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getMiddleX() {
        return this.x + this.width / 2;
    }

    public float getMiddleY() {
        return this.y + this.height / 2;
    }

    public float getBottom() {
        return  this.y + this.height;
    }

    public GameObject(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isAlive = true;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void moveTo(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void move(GameVector gameVector) {
        this.x += gameVector.dx;
        this.y += gameVector.dy;
    }

    public boolean overlap(GameObject gameObject) {
        Rectangle rect1 = this.getRect();
        Rectangle rect2 = gameObject.getRect();
        return rect1.intersects(rect2);
    }

    private Rectangle getRect() {
        return new Rectangle((int)x, (int)y, width, height);
    }

    public void destroy() {
            this.isAlive = false;
    }

    public void setY(float y) {
        this.y = y;
    }
}
