package controllers.gamescenes;

import controllers.BoxControllerManager;
import controllers.CollsionPool;
import controllers.FloorControllerManager;
import controllers.PlayerController;
import models.Background;
import models.GameSetting;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

/**
 * Created by Hau on 22/08/2016.
 */
public class PlayGameScene implements GameScene {
    private Background backOne;
    private Background backTwo;
    private BufferedImage back;
    private Image background;
    GameSceneListener gameSceneListener;


    public PlayGameScene() {
        backOne = new Background(0, 0);
        backTwo = new Background(GameSetting.getInstance().getScreenWidth(), 0);
        background = Utils.loadImage("Background2");
    }



    public void paint(Graphics graphics) {

        back = new BufferedImage(GameSetting.getInstance().getScreenWidth(),
                GameSetting.getInstance().getScreenHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics buffer = back.getGraphics();

        buffer.drawImage(background, backOne.getX(), backOne.getY(), null);
        buffer.drawImage(background, backTwo.getX(), backTwo.getY(), null);
        PlayerController.instance.draw(buffer);
        BoxControllerManager.instance.draw(buffer);
        FloorControllerManager.instance.draw(buffer);

        graphics.drawImage(back, 0, 0, null);
    }

    public void run() {


        backOne.update();
        backTwo.update();
        PlayerController.instance.run();
        BoxControllerManager.instance.run();
        FloorControllerManager.instance.run();
        CollsionPool.instance.run();
    }

    @Override
    public KeyListener getKeyListener() {
        return PlayerController.instance;
    }

    @Override
    public void draw(Graphics g) {
        paint(g);
    }

    @Override
    public void setGameSceneListener(GameSceneListener gameSceneListener) {
        this.gameSceneListener = gameSceneListener;
        PlayerController.instance.setGameSceneListener(this.gameSceneListener);
    }
}
