package controllers;

import models.Box;
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

    @Override
    public void run() {
        super.run();
        if(count % 500 == 0) {
            BoxController boxController = new BoxController(
                    new Box(720, 300), new ImageDrawer("brickblock")
            );
            this.add(boxController);
        }
        count++;
    }
}
