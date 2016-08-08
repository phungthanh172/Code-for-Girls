package models;

import utils.*;

import java.awt.*;

/**
 * Created by Hau on 06/08/2016.
 */
public class Background {
    private Image image;
    private int x;
    private int y;

    public Background() {
        this(0, 0);
    }

    public Background(int x, int y) {
        this.x = x;
        this.y = y;
        image =  Utils.loadImage("Background2");

    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void draw(Graphics g) {
        g.drawImage(image, getX(), getY(), image.getWidth(null), image.getHeight(null), null);

        this.x -= 2;

        if(this.x <= -1 * image.getWidth(null)) {
            this.x = this.x + image.getWidth(null) * 2;
        }
    }

    public int getImageWidth() {
        return image.getWidth(null);
    }
}
