package controllers.Enemy;

import controllers.BoxController;
import controllers.BoxControllerManager;
import controllers.ControllerManager;
import models.Box;
import models.Enemy;
import views.ImageDrawer;

/**
 * Created by Ha San~ on 8/24/2016.
 */
public class EnemyControllerManager extends ControllerManager {
    public final static EnemyControllerManager instance = new EnemyControllerManager();
    private int count = 0;
    private EnemyControllerManager() {
        super();
    }

    @Override
    public void run() {
        super.run();
        if(count % 500 == 0) {
            EnemyController enemyController = new EnemyController(
                    new Enemy(740, 200), new ImageDrawer("boss")
            );
            this.add(enemyController);
        }
        count++;
    }
}
