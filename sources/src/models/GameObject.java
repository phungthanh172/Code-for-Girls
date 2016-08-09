package models;

import java.awt.*;

/**
 * Created by KhacThanh on 8/6/2016.
 */
public abstract class GameObject {

    protected int x;
    protected int y;
    protected int width;
    protected int height;

    protected boolean isAlive;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getMiddleX() {
        return this.x + this.width / 2;
    }

    public int getMiddleY() {
        return this.y + this.height / 2;
    }

    public int getBottom() {
        return  this.y + this.height;
    }

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isAlive = true;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void moveTo(int x, int y) {
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
        return new Rectangle(x, y, width, height);
    }

    public void destroy() {
            this.isAlive = false;
    }

    public void setY(int y) {
        this.y = y;
    }
}
