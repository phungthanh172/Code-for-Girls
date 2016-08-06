package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by KhacThanh on 8/3/2016.
 */
public class Utils {
    public static Image loadImage(String url) {
        try {
            return ImageIO.read(new File(getResourceUrl(url)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getResourceUrl(String url) {
        return "resources/" + url + ".png";
    }
}
