package controllers;

import models.GameObject;

/**
 * Created by qhuydtvt on 7/31/2016.
 */
public interface Colliable {
    GameObject getGameObject();
    void onCollide(Colliable colliable);
}
