package controllers;

import models.GameObject;
import models.GameVector;
import views.GameDrawer;

import java.awt.*;

/**
 * Created by qhuydtvt on 7/30/2016.
 */
public class SingleController implements BaseController {

    public static boolean speedChange;
    protected GameObject gameObject;
    protected GameDrawer gameDrawer;
    protected GameVector gameVector;
    public  float speed = -2;

    public SingleController(GameObject gameObject, GameDrawer gameDrawer) {
        this.gameObject = gameObject;
        this.gameDrawer = gameDrawer;
        this.gameVector = new GameVector();
        if (speedChange) {
            gameVector.dx = speed * 2;
        } else {
            gameVector.dx = speed;
        }
    }

    public GameObject getGameObject() {
        return gameObject;
    }

    public GameVector getGameVector() {
        return gameVector;
    }

    @Override
    public void draw(Graphics g) {
        gameDrawer.draw(g, gameObject);
    }

    @Override
    public void run() {
        gameObject.move(this.gameVector);
        gameDrawer.run();
    }

    public void increaseSpeed() {
        gameVector.dx = speed * 2;
//        gameVector.increaseSpeed();
    }

    public void decreaseSpeed() {
        gameVector.dx = speed;
//        gameVector.decreaseSpeed();

    }
}
