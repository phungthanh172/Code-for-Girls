package models;

/**
 * Created by Ha San~ on 8/24/2016.
 */
public class Bullet extends GameObject {
    public static final int DEFAULT_WIDTH = 20;
    public static final int DEFAULT_HEIGHT = 20;

    private int damage;
    public Bullet(float x, float y, int width, int height) {
        super(x, y, width, height);
    }

    public Bullet(int x, int y) {
        super(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
    public int getDamage() {
        return damage;
    }
}
