package controllers;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ScrollingBackground extends Canvas implements Runnable {

    // Two copies of the background image to scroll
    private Background backOne;
    private Background backTwo;

    private BufferedImage back;

    public ScrollingBackground() {
        backOne = new Background();
        backTwo = new Background(backOne.getImageWidth(), 0);
        back = new BufferedImage(720,480, BufferedImage.TYPE_INT_ARGB);
        new Thread(this).start();
        setVisible(true);
    }

    @Override
    public void run() {
//        try {
//            while (true) {
//                Thread.currentThread().sleep(100);
                repaint();
//            }
        }
//        catch (Exception e) {}
//    }

    @Override
    public void update(Graphics window) {
        draw(window);
    }

    public void draw(Graphics window) {
        Graphics2D twoD = (Graphics2D)window;

        if (back == null)
            back = (BufferedImage)(createImage(getWidth(), getHeight()));

        // Create a buffer to draw to
        Graphics buffer = back.createGraphics();

        // Put the two copies of the background image onto the buffer
        backOne.draw(buffer);
        backTwo.draw(buffer);

        // Draw the image onto the window
        twoD.drawImage(back, null, 0, 0);

    }

    public BufferedImage getBack() {
        return back;
    }
}