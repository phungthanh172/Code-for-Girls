package views;

import models.GameObject;
import utils.Utils;

import java.awt.*;

/**
 * Created by qhuydtvt on 7/30/2016.
 */
public class ImageDrawer implements GameDrawer {

    private Image img;

    public ImageDrawer(Image img) {
        this.img = img;
    }

    public ImageDrawer(String url) {
        this.img = Utils.loadImage(url);
    }

    @Override
    public void draw(Graphics g, GameObject gameObject) {
        g.drawImage(img, (int)gameObject.getX(), (int)gameObject.getY(),
                gameObject.getWidth(), gameObject.getHeight(), null);
    }
}
