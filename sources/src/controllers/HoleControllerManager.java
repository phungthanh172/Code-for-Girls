package controllers;

import models.Hole;
import views.ImageDrawer;

/**
 * Created by Dell latitude E6520 on 8/27/2016.
 */
public class HoleControllerManager extends ControllerManager {
    public static HoleControllerManager instance = new HoleControllerManager();
    int count;
    @Override
    public void run() {
        super.run();
        if (count % 500 == 0){
//            count = 0;
            HoleController holeController = new HoleController(
                    new Hole(720, 400),
                    new ImageDrawer("hole1")
            );
            this.add(holeController);
        }
        count++;
    }

    public void reset(){
        this.singleControllerVector.setSize(0);
    }
}
