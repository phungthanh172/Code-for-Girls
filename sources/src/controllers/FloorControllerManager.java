package controllers;

import models.*;
import models.GameObject;
import models.Player;
import views.ImageDrawer;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by Ha San~ on 8/6/2016.
 */
public class FloorControllerManager extends ControllerManager {
    public final static FloorControllerManager instance = new FloorControllerManager();
    private int changeSize;

    private FloorControllerManager() {
        super();
        int x = 0;
        //changeSize = 380;
        for (int i = 0; i < 1; i++) {
            FloorController floorManager = new FloorController(
                    new Floor(x, 400), new ImageDrawer("land2")
            );
            x += 700;
            this.add(floorManager);
        }
    }

    @Override
    public void run() {
        super.run();

//        if (this.size() < 3) {
//            this.add(new FloorController(
//                    new Floor(700, 450), new ImageDrawer("land2")
//            ));
//        }
        if(getXLastFloor() < 700) {

            FloorState floorState = getRandomFloorState();
            switch (floorState){
                case LongHigh:
                    this.add(new FloorController(
                            new Floor((int)(getXLastFloor() + 50), 420, floorState) , new ImageDrawer("Land2")
                    ));
                    break;
                case ShortHigh:
                    this.add(new FloorController(
                            new Floor((int)(getXLastFloor() + 50), 420, floorState) , new ImageDrawer("Land2_short")
                    ));
                    break;
            }
        }
    }

    public float getFloorValue(GameObject gameObject) {
        // TODO: CREATE FUNCTION
        //ENTER code here
        float xPlayer = gameObject.getMiddleX();
        Iterator<SingleController> singleControllerIterator =
                singleControllerVector.iterator();
        while (singleControllerIterator.hasNext()) {
            SingleController singleController = singleControllerIterator.next();
            float bounderLeft = singleController.getGameObject().getX();
            float bounderRight = bounderLeft + singleController.getGameObject().getWidth();
            if (bounderLeft < xPlayer && bounderRight > xPlayer) {
                return singleController.getGameObject().getY();
            }
        }
        return 500;
    }
    public float getXLastFloor() {
        GameObject gameObject = singleControllerVector.lastElement().getGameObject();
        return gameObject.getX() + gameObject.getWidth();
    }
    public FloorState getRandomFloorState() {
        Random r = new Random();
        int i = r.nextInt(5);
        //if(i > 3) {
            return FloorState.ShortHigh;
        //} else {
        //    return FloorState.LongHigh;
        //}

    }
}