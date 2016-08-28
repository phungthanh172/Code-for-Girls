package controllers;

/**
 * Created by qhuydtvt on 8/3/2016.
 */
public class BulletControllerManager extends ControllerManager {

    public static final BulletControllerManager instance =
            new BulletControllerManager();
    public void reset(){
        singleControllerVector.setSize(0);
    }
}
