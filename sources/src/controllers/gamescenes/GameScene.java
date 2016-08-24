package controllers.gamescenes;

import java.awt.*;
import java.awt.event.KeyListener;

/**
 * Created by Hau on 22/08/2016.
 */
public interface GameScene extends Runnable {
    KeyListener getKeyListener();
    void draw(Graphics graphics);
    void setGameSceneListener(GameSceneListener gameSceneListener);
}
