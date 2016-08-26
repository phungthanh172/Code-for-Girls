package controllers;

import models.GameObject;
import utils.Utils;
import views.GameDrawer;

/**
 * Created by Ha San~ on 8/27/2016.
 */
public class HealthController extends SingleController implements Colliable {
    public static final int SPEED = 2;
    public HealthController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dx = -SPEED;
        CollsionPool.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlayerController) {
            this.getGameObject().destroy();
            PlayerController.instance.increaseHP(20);
            Utils.playSound("resources/coliable1.wav", false);
        }
    }
}
