package controllers;

import models.Floor;
import models.GameObject;
import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by Ha San~ on 8/6/2016.
 */
public class FloorController extends SingleController implements Colliable{
    public final static int SPEED =1;
    public FloorController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dx =-SPEED;
        CollsionPool.instance.add(this);
    }

    public final static FloorController instance = new FloorController(
            new Floor(0, 365), new ImageDrawer("land")
    );

    @Override
    public void run() {
        super.run();
        if(gameObject.getX() < -720 ) {
            gameObject.destroy();

        }
    }

    @Override
    public void onCollide(Colliable colliable) {

    }
}
