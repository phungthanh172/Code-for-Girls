package controllers;

import models.GameSetting;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by qhuydtvt on 7/30/2016.
 */
public class ControllerManager implements BaseController {

    protected Vector<SingleController> singleControllerVector;
    private int count;
    private boolean point;

    public ControllerManager() {
        singleControllerVector = new Vector<SingleController>();
        GameControllerManager.instance.add(this);
    }

    public void add(SingleController singleController) {
        this.singleControllerVector.add(singleController);
    }

    @Override
    public void draw(Graphics g) {
        synchronized (this.singleControllerVector) {
            Iterator<SingleController> singleControllerIterator =
                    this.singleControllerVector.iterator();
            while(singleControllerIterator.hasNext()) {
                SingleController singleController = singleControllerIterator.next();
                if(singleController.getGameObject().isAlive()) {
                    singleController.draw(g);
                }
            }
        }
    }
    public int size() {

        return singleControllerVector.size();
    }

    @Override
    public void run() {
        if (point) {
            count++;
        }
        if (GameSetting.getInstance().toSeconds(count) >= 1000) {
            count = 0;
            System.out.println("TANG");
            decreaseSpeed();
            SingleController.speedChange = false;
        }
        synchronized (this.singleControllerVector) {
            Iterator<SingleController> singleControllerIterator =
                    this.singleControllerVector.iterator();
            while(singleControllerIterator.hasNext()) {
                SingleController singleController = singleControllerIterator.next();
                if(!singleController.getGameObject().isAlive()) {
                    singleControllerIterator.remove();
                } else {
                    singleController.run();
                }
            }
        }
    }

    void increaseSpeed() {
        synchronized (this.singleControllerVector) {
            Iterator<SingleController> singleControllerIterator =
                    this.singleControllerVector.iterator();
            while(singleControllerIterator.hasNext()) {
                SingleController singleController = singleControllerIterator.next();
                if(singleController.getGameObject().isAlive()) {
                    singleController.increaseSpeed();
//                    singleController
                }
            }
                    point = true;
        }
    }

    void decreaseSpeed() {
        synchronized (this.singleControllerVector) {
            Iterator<SingleController> singleControllerIterator =
                    this.singleControllerVector.iterator();
            while(singleControllerIterator.hasNext()) {
                SingleController singleController = singleControllerIterator.next();
                if(singleController.getGameObject().isAlive()) {
                    singleController.decreaseSpeed();
                }
            }
                point = false;
        }
    }
}
