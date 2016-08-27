package models;

/**
 * Created by Ha San~ on 8/27/2016.
 */
public class Coin extends GameObject {

    private static final int DEFAULT_WIDTH = 30 ;
    private static final int DEFAULT_HEIGHT = 30 ;

    public Coin(float x, float y, int width, int height) {
        super(x, y, width, height);
    }
    public Coin(float x, float y){
        super(x,y,DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }

}
