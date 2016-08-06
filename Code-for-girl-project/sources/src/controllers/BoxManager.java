package controllers;

import models.Box;
import views.ImageDrawer;

/**
 * Created by Ha San~ on 8/6/2016.
 */
public class BoxManager extends ControllerManager {
    public final static BoxManager instance = new BoxManager();
    private int count = 0;
    private BoxManager() {
        super();



    }

    @Override
    public void run() {
        super.run();
        if(count % 500 == 0) {
            BoxController boxController = new BoxController(
                    new Box(720, 320), new ImageDrawer("brickblock")
            );
            this.add(boxController);
        }
        count++;
    }
}
