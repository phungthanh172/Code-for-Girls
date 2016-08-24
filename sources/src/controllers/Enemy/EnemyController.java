package controllers.Enemy;

import controllers.Colliable;
import controllers.CollsionPool;
import controllers.SingleController;
import models.Enemy;
import views.GameDrawer;

/**
 * Created by Ha San~ on 8/24/2016.
 */
public class EnemyController extends SingleController implements Colliable {
    private static final int SPEED = 1;

    public EnemyController(Enemy gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);

        this.gameVector.dx = -SPEED;
        CollsionPool.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {
//        if(colliable instanceof BulletController){
//            this.getGameObject().destroy();
//        }
    }

}
