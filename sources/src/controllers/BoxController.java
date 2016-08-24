package controllers;

import models.GameObject;
import views.GameDrawer;

/**
 * Created by Ha San~ on 8/6/2016.
 */
public class BoxController extends SingleController implements Colliable {


    public static final int SPEED = 1;

    public BoxController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dx = -SPEED;
        CollsionPool.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlayerController) {
            this.getGameObject().destroy();
            PlayerController.instance.decreaseHP(1);
        }
    }
}
