package controllers.gamescenes;

import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Hau on 22/08/2016.
 */
public class MenuGameScene implements GameScene, KeyListener {

    private static final String TAG = MenuGameScene.class.toString();
    private GameSceneListener gameSceneListener;
    private Image background;

    public MenuGameScene() {
        background = Utils.loadImage("Background");
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(background, 0, 0, null);
        /*TODO: Draw menu */
    }

    @Override
    public KeyListener getKeyListener() {
        return this;
    }

    @Override
    public void setGameSceneListener(GameSceneListener gameSceneListener) {
        this.gameSceneListener = gameSceneListener;
    }

    @Override
    public void run() {
        /*TODO: Run menu */
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            if(gameSceneListener != null)
                gameSceneListener.changeGameScene(new PlayGameScene(), true);
            else {
                System.out.println(String.format(
                        "%s : gameSceneListener is not set",
                        TAG
                ));
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
