package controllers;

import models.GameObject;
import models.*;
import utils.Utils;
import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by Dell latitude E6520 on 8/27/2016.
 */
public class GiftSpeedController extends SingleController implements Colliable {
    public static final int SPEED = 2;

    public GiftSpeedController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dx = -SPEED;
        CollsionPool.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlayerController) {
            this.getGameObject().destroy();
//            PlayerController.instance.decreaseHP(20);
            Utils.playSound("resources/coliable1.wav", false);
        }
    }

    public static GiftSpeedController create(int x, int y){
        return new GiftSpeedController(new Gift(x, y), new ImageDrawer("gift_speed"));
    }

}
