package controllers.gamescenes;

import models.GameSetting;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Hau on 22/08/2016.
 */
public class GameOverGameScene implements GameScene, KeyListener {
    private Image backgroundImage;
    private GameSceneListener gameSceneListener;

    public GameOverGameScene() {
        backgroundImage = Utils.loadImage("brickblock");
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, GameSetting.getInstance().getScreenWidth(),
                GameSetting.getInstance().getScreenHeight(), null);
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

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
