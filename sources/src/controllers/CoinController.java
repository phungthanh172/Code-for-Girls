package controllers;

import controllers.gamescenes.OptionGameScene;
import models.GameObject;
import utils.Utils;
import views.GameDrawer;

import static javafx.scene.input.KeyCode.O;

/**
 * Created by Ha San~ on 8/27/2016.
 */
public class CoinController extends SingleController implements Colliable {

    public CoinController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollsionPool.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof PlayerController) {
            this.getGameObject().destroy();
            PlayerController.instance.increaseCoin(1);
            if (OptionGameScene.turnOnSound) {
                Utils.playSound("resources/coliable1.wav", false);
            }
        }
    }
}

