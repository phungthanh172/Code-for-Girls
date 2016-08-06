package models;

/**
 * Created by KhacThanh on 8/6/2016.
 */
public class GameVector {
    public int dx;
    public int dy;

    public GameVector() {
        this(0, 0);
    }

    public GameVector(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

}
