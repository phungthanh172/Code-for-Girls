package controllers;

import models.GameSetting;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Hau on 27/08/2016.
 */
public class GameControllerManager implements BaseController {
    Vector<ControllerManager> controllerManagerVector;
    public static int count;
    private boolean point;
    public final static int TIME_INCREASE_SPEED = 5;

    public GameControllerManager() {
        this.controllerManagerVector = new Vector<>();
        point = false;
    }

    public void add(ControllerManager controllerManager) {
        controllerManagerVector.add(controllerManager);
    }

    @Override
    public void draw(Graphics g) {
        synchronized (this.controllerManagerVector) {
            Iterator<ControllerManager> controllerManagerIterator =
                    this.controllerManagerVector.iterator();
            while (controllerManagerIterator.hasNext()) {
                ControllerManager controllerManager = controllerManagerIterator.next();
                controllerManager.draw(g);
            }
        }
    }

    @Override
    public void run() {
        if (point) {
            count++;
        }
        if (GameSetting.getInstance().toSeconds(count) >= TIME_INCREASE_SPEED) {
            count = 0;
            decreaseSpeed();
        }
        synchronized (this.controllerManagerVector) {

            Iterator<ControllerManager> controllerManagerIterator =
                    this.controllerManagerVector.iterator();
            while (controllerManagerIterator.hasNext()) {
                ControllerManager controllerManager = controllerManagerIterator.next();
                controllerManager.run();
            }
        }
    }

    public void increaseSpeed() {
        synchronized (this.controllerManagerVector) {
            Iterator<ControllerManager> controllerManagerIterator =
                    this.controllerManagerVector.iterator();
            while (controllerManagerIterator.hasNext()) {
                ControllerManager controllerManager = controllerManagerIterator.next();
                controllerManager.increaseSpeed();
            }
            point = true;
        }
    }

    public void decreaseSpeed() {
        synchronized (this.controllerManagerVector) {
            Iterator<ControllerManager> controllerManagerIterator =
                    this.controllerManagerVector.iterator();
            while (controllerManagerIterator.hasNext()) {
                ControllerManager controllerManager = controllerManagerIterator.next();
                controllerManager.decreaseSpeed();
            }
            point = false;
        }
    }

    public static final GameControllerManager instance = new GameControllerManager();
}
