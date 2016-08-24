package controllers;

import controllers.Enemy.EnemyController;
import models.Bullet;
import models.GameObject;
import models.GameObjectWithHp;
import views.GameDrawer;

import java.util.Objects;

/**
 * Created by Ha San~ on 8/24/2016.
 */
public class BulletController extends SingleController implements Colliable {
    public static final int SPEED = 3;
    public BulletController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dx=SPEED;
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof EnemyController) {
            Bullet bullet = (Bullet)gameObject;
            ((GameObjectWithHp)colliable.getGameObject()).decreaseHP(bullet.getDamage());
            this.getGameObject().destroy();
        }
    }
}
