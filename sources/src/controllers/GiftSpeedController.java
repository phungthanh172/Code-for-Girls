package controllers;

import controllers.gamescenes.*;
import models.GameObject;
import models.*;
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
        speed = -2;

    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlayerController) {
            this.getGameObject().destroy();
            FloorControllerManager.instance.increaseSpeed();
            BoxControllerManager.instance.increaseSpeed();
            GiftControllerManager.instance.increaseSpeed();
            HealthControllerManager.instance.increaseSpeed();
            HoleControllerManager.instance.increaseSpeed();
            SingleController.speedChange = true;
            if (OptionGameScene.turnOnSound) {
                Utils.playSound("resources/coliable1.wav", false);
            }
           // Utils.playSound("resources/coliable1.wav", false);
        }
    }

    public static GiftSpeedController create(int x, int y){
        return new GiftSpeedController(new Gift(x, y), new ImageDrawer("gift_speed"));
    }

}
