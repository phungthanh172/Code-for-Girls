package controllers.Enemy;
import controllers.*;
/**
 * Created by qhuydtvt on 8/3/2016.
 */
public class EnemyBulletControllerManager extends ControllerManager {

    public static final EnemyBulletControllerManager instance =
            new EnemyBulletControllerManager();
    public void reset(){
        singleControllerVector.setSize(0);
    }
}
