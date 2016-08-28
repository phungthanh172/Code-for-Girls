package controllers;

import controllers.Enemy.EnemyController;
import models.Enemy;
import models.GameObject;
import models.GameObjectWithHp;
import views.GameDrawer;

/**
 * Created by qhuydtvt on 8/3/2016.
 */
public class PlayerBulletController extends SingleController implements Colliable {

    public PlayerBulletController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollsionPool.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof EnemyController){
            gameObject.destroy();
            //System.out.println("-------------------------------------------");
            ((GameObjectWithHp)(colliable.getGameObject())).decreaseHP(2);
        }
       // System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }
}
