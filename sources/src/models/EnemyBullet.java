package models;

/**
 * Created by Ha San~ on 8/24/2016.
 */
public class EnemyBullet extends GameObject {
    private static final int DEFAULT_WIDTH = 20;
    private static final int DEFAULT_HEIGHT = 20;

    public EnemyBullet(float x, float y, int width, int height) {
        super(x, y, width, height);
    }

    public EnemyBullet(float x, float y) {
        super(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
