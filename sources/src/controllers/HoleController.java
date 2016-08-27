package controllers;

import models.GameObject;
import models.Hole;
import utils.Utils;
import views.GameDrawer;

/**
 * Created by Dell latitude E6520 on 8/27/2016.
 */
public class HoleController extends SingleController implements Colliable{

    public HoleController(Hole gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollsionPool.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlayerController) {
            this.getGameObject().destroy();
          //  PlayerController.instance.decreaseHP(20);
            Utils.playSound("resources/coliable1.wav", false);
        }

    }
}
