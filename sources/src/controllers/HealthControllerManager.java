package controllers;

import models.Box;
import models.Health;
import views.ImageDrawer;

/**
 * Created by Ha San~ on 8/27/2016.
 */
public class HealthControllerManager extends ControllerManager {
    public final static HealthControllerManager instance = new HealthControllerManager();
    private  int count =0;
    public HealthControllerManager(){
        super();
    }

    @Override
    public void run() {
        super.run();
        if(count % 200 == 150) {
            HealthController healthController = new HealthController(
                    new Health(720, 350), new ImageDrawer("health")
            );
            this.add(healthController);
        }
        count++;
    }
    public void reset(){
        this.singleControllerVector.setSize(0);
    }
}
