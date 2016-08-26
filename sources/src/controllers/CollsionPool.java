package controllers;

import models.GameObject;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by qhuydtvt on 7/31/2016.
 */
public class CollsionPool implements BaseController {

    private Vector<Colliable> colliableVector;

    private CollsionPool() {
        colliableVector = new Vector<Colliable>();
    }

    public void add(Colliable colliable) {
        this.colliableVector.add(colliable);
    }


    @Override
    public void run() {
        for(int i = 0; i < colliableVector.size() - 1; i ++) {
            for(int j = i + 1; j < colliableVector.size(); j++) {
                Colliable ci = colliableVector.get(i);
                Colliable cj = colliableVector.get(j);

                GameObject gi = ci.getGameObject();
                GameObject gj = cj.getGameObject();

                if(gi.overlap(gj)) {
                    ci.onCollide(cj);
                    cj.onCollide(ci);
                }
            }
        }

        Iterator<Colliable> colliableIterator = colliableVector.iterator();
        while(colliableIterator.hasNext()) {
            Colliable colliable = colliableIterator.next();
            if(!colliable.getGameObject().isAlive())
                colliableIterator.remove();
        }
    }

    @Override
    public void draw(Graphics g) {

    }

    public static final CollsionPool instance = new CollsionPool();
    public void reset(){
        colliableVector.clear();
    }
}
