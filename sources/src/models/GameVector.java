package models;

/**
 * Created by KhacThanh on 8/6/2016.
 */
public class GameVector {
    public float dx;
    public float dy;

    public GameVector() {
        this(0, 0);
    }

    public GameVector(float dx, float dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public void increaseSpeed() {
        this.dx *= 2;
    }

    public void decreaseSpeed() {
        this.dx /= 2;
    }
}
