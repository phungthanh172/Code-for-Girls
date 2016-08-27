package controllers;

import controllers.gamescenes.OptionGameScene;
import models.GameObject;
import utils.Utils;
import views.GameDrawer;

/**
 * Created by Ha San~ on 8/27/2016.
 */
public class HealthController extends SingleController implements Colliable {
    public HealthController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollsionPool.instance.add(this);
        System.out.println(gameVector.dx);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlayerController) {
            this.getGameObject().destroy();
            PlayerController.instance.increaseHP(10);
            if (OptionGameScene.turnOnSound) {
                Utils.playSound("resources/coliable1.wav", false);
            }
            //Utils.playSound("resources/coliable1.wav", false);
        }
    }
}
