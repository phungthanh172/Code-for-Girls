package controllers;

import models.GameObject;
import views.GameDrawer;

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
        }
    }
}

