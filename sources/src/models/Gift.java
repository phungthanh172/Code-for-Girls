package models;

/**
 * Created by Dell latitude E6520 on 8/27/2016.
 */
public class Gift extends GameObject {
    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;

    public Gift(float x, float y, int width, int height) {
        super(x, y, width, height);
    }

    public Gift(float x, float y) {
        super(x, y, WIDTH, HEIGHT);
    }
}
