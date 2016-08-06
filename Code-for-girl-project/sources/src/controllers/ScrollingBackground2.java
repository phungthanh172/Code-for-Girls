package controllers;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Hau on 06/08/2016.
 */
public class ScrollingBackground2 extends Canvas implements Runnable {
    private Background backOne;
    private Background backTwo;

    public BufferedImage getBack() {
        return back;
    }


    private BufferedImage back;

    public ScrollingBackground2() {
        backOne = new Background();
        backTwo = new Background(backOne.getImageWidth(), 0);

        new Thread(this).start();
    }

    @Override
    public void update(Graphics g) {
        g.drawImage(back, 0, 0,
                1440, 480, null);

    }

    @Override
    public void run() {
        repaint();
    }
}
