package models;

/**
 * Created by KhacThanh on 8/6/2016.
 */
public class Player extends GameObjectWithHp{
    private static final int DEFAULT_WIDTH = 70;
    private static final int DEFAULT_HEIGHT = 75;
    private static final int HP_DEFAULT = 100;
    public Player(int x, int y, int width, int height, int hp) {
        super(x, y, width, height, hp);
    }
    public Player(int x, int y) {
        super(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT, HP_DEFAULT);
    }



}
