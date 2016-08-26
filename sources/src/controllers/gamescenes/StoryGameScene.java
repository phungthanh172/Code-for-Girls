package controllers.gamescenes;

import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Ha San~ on 8/27/2016.
 */
public class StoryGameScene implements GameScene, KeyListener, MouseListener {
    private static final String TAG = StoryGameScene.class.toString();
    private GameSceneListener gameSceneListener;
    private Image background;

    public StoryGameScene() {
        background = Utils.loadImage("Story");

    }

    @Override
    public KeyListener getKeyListener() {
        return this;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(background, 0, 0, null);
    }

    @Override
    public void setGameSceneListener(GameSceneListener gameSceneListener) {
        this.gameSceneListener = gameSceneListener;
    }

    @Override
    public MouseListener getMouseListener() {
        return this;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (gameSceneListener != null)
                gameSceneListener.changeGameScene(new TutorialGameScene(), false);
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

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void run() {

    }
}
