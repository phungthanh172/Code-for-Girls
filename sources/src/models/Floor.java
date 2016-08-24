package models;

import controllers.*;

/**
 * Created by KhacThanh on 8/6/2016.
 */
public class Floor extends GameObject {
    private static final int DEFAULT_LONG_WIDTH = 720;
    private static final int DEFAULT_SHORT_WIDTH = 180;
    private static final int DEFAULT_HEIGHT = 115;

    public Floor(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    public Floor(int x , int y){
        super(x,y,DEFAULT_LONG_WIDTH,DEFAULT_HEIGHT);
    }
    public Floor(int x , int y, FloorState floorState){
        super(x,y,0,DEFAULT_HEIGHT);
        switch (floorState){
            case LongHigh:
            case LongLow:
                width = DEFAULT_LONG_WIDTH;
                break;
            case ShortHigh:
            case ShortLow:
                width = DEFAULT_SHORT_WIDTH;
                break;
        }

    }
}
