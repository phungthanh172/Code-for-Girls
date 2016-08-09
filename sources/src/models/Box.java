package models;

/**
 * Created by KhacThanh on 8/6/2016.
 */
public class Box extends GameObject {
    private static final int DEFAULT_WIDTH = 30;
    private static final int DEFAULT_HEIGHT = 30;


    public Box(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    public Box(int x, int y) {
        super(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

}
