package controllers.gamescenes;

import controllers.*;
import models.*;
import utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by KhacThanh on 8/27/2016.
 */
public class PlayGameScene2 extends PlayGameScene {
    private int count;

    public PlayGameScene2(boolean resetPlayer) {
        if (resetPlayer) {
            reset();
        } else {
            resetWithOutPlayer();
            System.out.println("aaaaaaaaaaaaaaaaaaaaa");
        }


    }

    @Override
    protected void reset() {
        backOne = new Background(0, 0);
        backTwo = new Background(GameSetting.getInstance().getScreenWidth(), 0);
        PlayerController.instance.reset();
        background = Utils.loadImage("Background2");
        System.out.println("dddddddddddddddddddd");
        FloorControllerManager2.instance.reset();
        CoinControllerManager.instance.reset();
        CollsionPool.instance.reset();
    }

    @Override
    protected void resetWithOutPlayer() {
        backOne = new Background(0, 0);
        backTwo = new Background(GameSetting.getInstance().getScreenWidth(), 0);
        background = Utils.loadImage("Background2");
        System.out.println("dddddddddddddddddddd");
        FloorControllerManager2.instance.reset();
        CoinControllerManager.instance.reset();
        CollsionPool.instance.reset();
    }

    @Override
    public void paint(Graphics graphics) {
        background = Utils.loadImage("Background");
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
        if (GameSetting.getInstance().toSeconds(count) >= 5000) {
            count = 0;
            gameSceneListener.changeGameScene(new PlayGameScene(false), false);
        }

        backOne.update();
        backTwo.update();
        PlayerController.instance.run();
        CoinControllerManager.instance.run();
        CollsionPool.instance.run();
        FloorControllerManager2.instance.run();
    }

    @Override
    protected void scoreDraw(Graphics g) {
        Font font = new Font("arial", Font.TYPE1_FONT, 20);
        g.setFont(font);
        g.setColor(Color.red);
        g.drawString("Score: " + ((Player)PlayerController.instance.getGameObject()).getScore(), 600, 65);
        g.drawString("Coin: " + ((Player)PlayerController.instance.getGameObject()).getCoin(), 450, 65);
    }

    //    protected void scoreDraw(Graphics g) {
//        Font font = new Font("arial", Font.TYPE1_FONT, 20);
//        g.setFont(font);
//        g.setColor(Color.red);
//        g.drawString("Score: " + ((Player)PlayerController.instance.getGameObject()).getScore(), 600, 65);
//        g.drawString("Coin: " + ((Player)PlayerController.instance.getGameObject()).getCoin(), 450, 65);
//    }

    @Override
    protected void healthBarDraw(Graphics g) {
        GameObject gameObject = PlayerController.instance.getGameObject();
        float health = ((GameObjectWithHp) gameObject).getHp();
        float maxHealth = 50;
        float healthScale = health / maxHealth;
        Color healthBarColor = Color.green;
        int healthBarX = 50;
        int healthBarY = 50;
        int healthBarWidth = 200;
        int healthBarHeight = 20;
        g.setColor(healthBarColor);
        g.fillRect(healthBarX, healthBarY, (int) (healthBarWidth * healthScale), healthBarHeight);
    }
}
