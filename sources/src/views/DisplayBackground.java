package views;

import controllers.BoxControllerManager;
import controllers.CollsionPool;
import controllers.*;
import models.Background;
import models.GameSetting;
import utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Hau on 06/08/2016.
 */
public class DisplayBackground extends Canvas {
    private Background backOne;
    private Background backTwo;
    private BufferedImage back;
    private Image background;


    public DisplayBackground() {
        backOne = new Background(0, 0);
        backTwo = new Background(GameSetting.getInstance().getScreenWidth(), 0);
        background = Utils.loadImage("Background2");
    }


    public void draw(Graphics g) {
        paint(g);
//        System.out.println("As");
    }

    public void paint(Graphics graphics) {

        back = new BufferedImage(GameSetting.getInstance().getScreenWidth(),
                GameSetting.getInstance().getScreenHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics buffer = back.getGraphics();

        buffer.drawImage(background, backOne.getX(), backOne.getY(), this);
        buffer.drawImage(background, backTwo.getX(), backTwo.getY(), this);
        PlayerController.instance.draw(buffer);
        BoxControllerManager.instance.draw(buffer);
        FloorControllerManager.instance.draw(buffer);

        graphics.drawImage(back, 0, 0, null);
    }

    public void run() {


        backOne.update();
        backTwo.update();
        PlayerController.instance.run();
        BoxControllerManager.instance.run();
        FloorControllerManager.instance.run();
        CollsionPool.instance.run();
        System.out.println("as");


    }
}
