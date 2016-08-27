package controllers.gamescenes;

import controllers.*;
import models.Background;
import models.GameSetting;
import models.Player;
import utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by KhacThanh on 8/27/2016.
 */
public class PlayGameScene2 extends PlayGameScene {
    private int count;

    public PlayGameScene2(){
        backOne = new Background(0, 0);
        backTwo = new Background(GameSetting.getInstance().getScreenWidth(), 0);
        background = Utils.loadImage("Background2");
        System.out.println("dddddddddddddddddddd");
    }

    @Override
    public void paint(Graphics graphics) {
        background = Utils.loadImage("Background3");
//        back = new BufferedImage(GameSetting.getInstance().getScreenWidth(),
//                GameSetting.getInstance().getScreenHeight(), BufferedImage.TYPE_INT_ARGB);
//        Graphics buffer = back.getGraphics();
        graphics.drawImage(background, backOne.getX(), backOne.getY(), null);
        graphics.drawImage(background, backTwo.getX(), backTwo.getY(), null);
        //graphics.drawImage(background, 0, 0, null);

        healthBarDraw(graphics);
        scoreDraw(graphics);
        CoinControllerManager.instance.draw(graphics);
        FloorControllerManager2.instance.draw(graphics);
        PlayerController.instance.draw(graphics);
    }
    @Override
    public void draw(Graphics g) {
        paint(g);
    }
    @Override
    public void run() {
        count++;
        if(GameSetting.getInstance().toSeconds(count) >= 5){
            count = 0;
            gameSceneListener.changeGameScene(new PlayGameScene2(),false);
        }

            backOne.update();
        backTwo.update();
        CoinControllerManager.instance.run();
        CollsionPool.instance.run();
        PlayerController.instance.run();
        FloorControllerManager2.instance.run();
    }
}
