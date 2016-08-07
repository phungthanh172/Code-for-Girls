package controllers;

import models.Floor;
import views.ImageDrawer;

/**
 * Created by Ha San~ on 8/6/2016.
 */
public class FloorManager extends ControllerManager {
    public final static FloorManager instance = new FloorManager();

    private FloorManager() {
        super();
        int x = 0;
        for(int i = 0 ; i < 1 ; i++) {
            FloorController floorManager = new FloorController(
                    new Floor(x, 400), new ImageDrawer("land")
            );
        x += 700;
            this.add(floorManager);
        }
    }

    @Override
    public void run() {
        super.run();
        System.out.println(this.size());

        if(this.size() < 3) {
            this.add(new FloorController(
                    new Floor( 720 , 400), new ImageDrawer("land")
            ));
        }
    }
}
