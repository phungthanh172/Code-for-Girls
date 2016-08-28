package controllers;

import models.GameSetting;
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
        if (GameSetting.getInstance().toSeconds(count) >= 100000){
            count = 0;
            HoleController holeController = new HoleController(
                    new Hole(720, 350),
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
