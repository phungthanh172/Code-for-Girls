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
        if(singleControllerVector.size() == 0){
            count ++;
            if(count >= 1000) {
                count = 0;
                EnemyController enemyController = new EnemyController(
                        new Enemy(600, 0), new AnimationDrawer( Utils.loadFromSprite("resources/Enemy.png", true, 90, 200, 0),
                        false, false, 14
                )

                );
                this.add(enemyController);
            }

        }
//        if(count == 1) {
//            EnemyController enemyController = new EnemyController(
//                    new Enemy(600, 0), new AnimationDrawer( Utils.loadFromSprite("resources/Enemy.png", true, 90, 200, 0),
//                    false, false, 14
//            )
//
//            );
//            this.add(enemyController);
//        }
    }
    public void reset(){
        singleControllerVector.setSize(0);
        count = 0;
    }
}
