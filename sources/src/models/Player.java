package models;

/**
 * Created by KhacThanh on 8/6/2016.
 */
public class Player extends GameObject{
    private static final int DEFAULT_WIDTH = 40;
    private static final int DEFAULT_HEIGHT = 80;

    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    public Player(int x, int y) {
        super(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }


}
