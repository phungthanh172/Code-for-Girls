package controllers;

import models.Box;
import models.Floor;
import models.GameSetting;
import views.ImageDrawer;

/**
 * Created by Ha San~ on 8/6/2016.
 */
public class BoxControllerManager extends ControllerManager {
    public final static BoxControllerManager instance = new BoxControllerManager();
    private int count = 0;
    private BoxControllerManager() {
        super();
    }
    private static final int FLOOR_CHANGE = 15;
    private static final int PLAYER_RUN_HEIGH = 75;
    @Override
    public void run() {
        super.run();
        int yScreen = GameSetting.getInstance().getScreenWidth();
        Floor lastFloor = FloorControllerManager.instance.getFloorValue(yScreen);
        if(lastFloor == null) return;
        int yBox = (int)(lastFloor.getY()) - PLAYER_RUN_HEIGH - FLOOR_CHANGE + 1 ;
        int xBox = (int)(lastFloor.getMiddleX());
        if(count % 400 == 20) {
            BoxController boxController = new BoxController(
                    new Box(xBox , yBox), new ImageDrawer("brickblock")
            );
            this.add(boxController);
        }
        count++;
    }
    //public void get
    public void reset(){
        this.singleControllerVector.setSize(0);
    }
}
