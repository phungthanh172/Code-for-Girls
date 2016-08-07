package controllers;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Hau on 06/08/2016.
 */
public class ScrollingBackground extends Canvas implements Runnable {
    private Background backOne;
    private Background backTwo;
    private BufferedImage back;


    public ScrollingBackground() {
        backOne = new Background();
        backTwo = new Background(backOne.getImageWidth(), 0);

        new Thread(this).start();
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }
    public void paint(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        if (back == null)
            back = (BufferedImage) (createImage(getWidth(), getHeight()));

        Graphics buffer = back.createGraphics();
        backOne.draw(buffer);
        backTwo.draw(buffer);
//        System.out.println("a");

        PlayerController.instance.draw(buffer);
        BoxManager.instance.draw(buffer);
        FloorManager.instance.draw(buffer);

        g2d.drawImage(back, null, 0, 0);
    }

    @Override
    public void run() {

        while (true) {
            try {

                PlayerController.instance.run();
                BoxManager.instance.run();
                FloorManager.instance.run();
                Thread.sleep(17);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
