package views;

import models.GameObject;
import models.GameSetting;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Hau on 22/08/2016.
 */
public class AnimationDrawer implements GameDrawer {

    private Vector<Image> imageVector;
    private int imageIndex;
    private int timeCounter;
    private boolean detroyOnReachEnd;
    private boolean keepLastImage;
    private int countPeriod;
    private int countChangeImage;

    public AnimationDrawer(Vector<Image> imageVector, boolean detroyOnReachEnd, boolean keepLastImage, int countChangeImage) {
        this.imageVector = imageVector;
        this.imageIndex = 0;
        this.detroyOnReachEnd = detroyOnReachEnd;
        this.keepLastImage = keepLastImage;
        this.countChangeImage = countChangeImage;
        countPeriod = 0;

    }

    public AnimationDrawer(Vector<Image> imageVector) {
        this(imageVector, false, false, 7);
    }

    @Override
    public void draw(Graphics g, GameObject gameObject) {
        Image image;

        if(countPeriod >= 1 && keepLastImage) {
            if(imageIndex % 2 == 0){
                image = imageVector.get(imageVector.size()-1);
            } else {
                image = imageVector.get(imageVector.size()-2);
            }
        } else {
            image = imageVector.get(imageIndex);
            //System.out.println(imageIndex);
        }

        /*Draw the image */
        g.drawImage(image,
                (int)gameObject.getX(),
                (int)gameObject.getY(),
                gameObject.getWidth(),
                gameObject.getHeight(), null);

        timeCounter++;

        if(timeCounter >= 7) {
            timeCounter = 0;
            imageIndex++;
            if(imageIndex >= imageVector.size()) {
                imageIndex = 0;
                countPeriod++;
            }

            if(imageIndex == imageVector.size() - 1 && detroyOnReachEnd) {
                gameObject.destroy();
            }
        }
    }

    @Override
    public void run() {

    }
}
