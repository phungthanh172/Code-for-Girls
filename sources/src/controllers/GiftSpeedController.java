package controllers;

import models.GameObject;
import models.Gift;
import utils.Utils;
import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by Dell latitude E6520 on 8/27/2016.
 */
public class GiftSpeedController extends SingleController implements Colliable {

    public GiftSpeedController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollsionPool.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlayerController) {
            this.getGameObject().destroy();
//            GameControllerManager.instance.increaseSpeed();
            FloorControllerManager.instance.increaseSpeed();
            BoxControllerManager.instance.increaseSpeed();
            GiftControllerManager.instance.increaseSpeed();
            SingleController.speedChange = true;
            Utils.playSound("resources/coliable1.wav", false);
        }
    }

    public static GiftSpeedController create(int x, int y){
        return new GiftSpeedController(new Gift(x, y), new ImageDrawer("gift_speed"));
    }

}
