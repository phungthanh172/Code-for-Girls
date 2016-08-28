package controllers.Enemy;

import controllers.*;
import models.GameObject;
import models.Player;
import views.GameDrawer;

/**
 * Created by qhuydtvt on 8/3/2016.
 */
public class EnemyBulletController extends SingleController implements Colliable {

    public EnemyBulletController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollsionPool.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {

    }
}
