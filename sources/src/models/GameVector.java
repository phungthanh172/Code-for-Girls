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

}
