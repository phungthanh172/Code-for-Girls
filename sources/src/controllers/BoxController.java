package controllers;

import controllers.gamescenes.OptionGameScene;
import models.GameObject;
import utils.Utils;
import views.GameDrawer;

/**
 * Created by Ha San~ on 8/6/2016.
 */
public class BoxController extends SingleController implements Colliable {


    public BoxController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollsionPool.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof PlayerController) {
            this.getGameObject().destroy();
            PlayerController.instance.decreaseHP(20);
            if (OptionGameScene.turnOnSound) {
                Utils.playSound("resources/coliable1.wav", false);
            }
        }
    }
}
