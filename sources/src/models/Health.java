package models;

/**
 * Created by Ha San~ on 8/27/2016.
 */
public class Health extends GameObject {

    private static final int DEFAULT_WIDTH = 20 ;
    private static final int DEFAULT_HEIGHT = 20;

    public Health(float x, float y, int width, int height) {
        super(x, y, width, height);
    }

    public Health(int x, int y){
        super(x,y,DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }

}
