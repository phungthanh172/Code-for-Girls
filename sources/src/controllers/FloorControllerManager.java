package controllers;

import models.*;
import models.GameObject;
import views.ImageDrawer;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by Ha San~ on 8/6/2016.
 */
public class FloorControllerManager extends ControllerManager {
    public static FloorControllerManager instance = new FloorControllerManager();
    private int changeSize;

    private FloorControllerManager() {
        super();
        int x = 0;
        //changeSize = 380;
      //  for (int i = 0; i < 1; i++) {
            FloorController floorManager = new FloorController(
                    new Floor(0, 400), new ImageDrawer("land2")
            );
       //    x += 700;
            this.add(floorManager);
       // }
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
                case LONG_HIGH:
                    this.add(new FloorController(
                            new Floor((int)(getXLastFloor() + 45), 400, floorState) , new ImageDrawer("Land2")
                    ));
                    break;
                case SHORT_HIGH:
                    this.add(new FloorController(
                            new Floor((int)(getXLastFloor() + 45), 400, floorState) , new ImageDrawer("Land2_short")
                    ));
                    break;
                case SHORT_LOW:
                    this.add(new FloorController(
                            new Floor((int)(getXLastFloor() + 45), 420, floorState) , new ImageDrawer("Land2_short")
                    ));
                    break;
                case LONG_LOW:
                    this.add(new FloorController(
                            new Floor((int)(getXLastFloor() + 45), 420, floorState) , new ImageDrawer("Land2")
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
        return 550;
    }
    public Floor getFloorValue(float xObject) {
        // TODO: CREATE FUNCTION
        //ENTER code here

        Iterator<SingleController> singleControllerIterator =
                singleControllerVector.iterator();
        while (singleControllerIterator.hasNext()) {
            SingleController singleController = singleControllerIterator.next();
            float bounderLeft = singleController.getGameObject().getX();
            float bounderRight = bounderLeft + singleController.getGameObject().getWidth();
            if (bounderLeft < xObject && bounderRight > xObject) {
                return (Floor) singleController.getGameObject();
            }
        }
        return null;
    }
    public float getXLastFloor() {
        GameObject gameObject = singleControllerVector.lastElement().getGameObject();
        return gameObject.getX() + gameObject.getWidth();
    }
    public FloorState getRandomFloorState() {
        Random r = new Random();
        int i = r.nextInt(9);
        if(i > 7) {
            return FloorState.SHORT_HIGH;
        } else if(i > 5){
            return FloorState.LONG_HIGH;
        } else if(i > 3) {
            return FloorState.LONG_LOW;
        } else {
            return FloorState.LONG_HIGH;
        }

    }
    public void reset(){
        instance = new FloorControllerManager();
    }
}