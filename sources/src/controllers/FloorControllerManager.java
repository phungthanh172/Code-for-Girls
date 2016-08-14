package controllers;

import models.Floor;
import models.GameObject;
import views.ImageDrawer;

/**
 * Created by Ha San~ on 8/6/2016.
 */
public class FloorControllerManager extends ControllerManager {
    public final static FloorControllerManager instance = new FloorControllerManager();
    private int changeSize;
    private FloorControllerManager() {
        super();
        int x = 0;
        //changeSize = 380;
        for(int i = 0 ; i < 1 ; i++) {
            FloorController floorManager = new FloorController(
                    new Floor(x, 400), new ImageDrawer("land2")
            );
        x += 700;
            this.add(floorManager);
        }
    }

    @Override
    public void run() {
        super.run();

        if(this.size() < 3) {
            this.add(new FloorController(
                    new Floor( 720 , 400), new ImageDrawer("land2")
            ));
        }
    }
    public static int GetFloorValue(GameObject gameObject) {
        // TODO: CREATE FUNCTION
        //ENTER code here

        //End
        return 0;
    }
}
