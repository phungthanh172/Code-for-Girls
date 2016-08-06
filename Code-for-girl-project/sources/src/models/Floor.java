package models;

/**
 * Created by KhacThanh on 8/6/2016.
 */
public class Floor extends GameObject {
    private static final int DEFAULT_WIDTH = 720;
    private static final int DEFAULT_HEIGHT = 115;

    public Floor(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    public Floor(int x , int y){
        super(x,y,DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}
