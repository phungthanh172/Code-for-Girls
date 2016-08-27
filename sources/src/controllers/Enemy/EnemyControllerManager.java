package controllers.Enemy;

import controllers.BoxController;
import controllers.BoxControllerManager;
import controllers.ControllerManager;
import models.Box;
import models.Enemy;
import utils.Utils;
import views.AnimationDrawer;
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
        if(size() < 2) {
            EnemyController enemyController = new EnemyController(
                    new Enemy(600, 0), new AnimationDrawer( Utils.loadFromSprite("resources/Enemy.png", true, 90, 200, 0))
            );
            this.add(enemyController);
        }

        count++;
    }
    public void reset(){
        singleControllerVector.setSize(0);
    }
}
