package models;

/**
 * Created by Ha San~ on 8/24/2016.
 */
public class Enemy extends GameObjectWithHp {
    private static final int DEFAULT_WIDTH = 108;
    private static final int DEFAULT_HEIGHT = 240;
    private static final int DEFAULT_HP = 5;
    public Enemy(int x, int y, int width, int height, int maxHP) {
        super(x, y, width, height, maxHP);
    }
    public Enemy(int x, int y){
        super(x,y,DEFAULT_WIDTH,DEFAULT_HEIGHT,DEFAULT_HP);
    }

}
