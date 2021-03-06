package controllers.gamescenes;

import controllers.BoxControllerManager;
import controllers.CollsionPool;
import controllers.*;
import controllers.BulletControllerManager;
import controllers.Enemy.EnemyControllerManager;
import models.*;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

/**
 * Created by Hau on 22/08/2016.
 */
public class PlayGameScene implements GameScene, MouseListener {
    protected Background backOne;
    protected Background backTwo;
    protected BufferedImage back;
    protected Image background;
    protected GameSceneListener gameSceneListener;
    private int count;
    private boolean checkSound = true;

    public PlayGameScene() {
        reset();

    }

    public PlayGameScene(boolean resetPlayer) {
        if (resetPlayer) {
            reset();
        } else {
            resetWithOutPlayer();

        }
        //Utils.playSound("resources/music.wav", true);
    }

    public void paint(Graphics graphics) {

        back = new BufferedImage(GameSetting.getInstance().getScreenWidth(),
                GameSetting.getInstance().getScreenHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics buffer = back.getGraphics();

        buffer.drawImage(background, backOne.getX(), backOne.getY(), null);
        buffer.drawImage(background, backTwo.getX(), backTwo.getY(), null);
        healthBarDraw(buffer);
        scoreDraw(buffer);
        EnemyControllerManager.instance.draw(buffer);
        FloorControllerManager.instance.draw(buffer);
        BoxControllerManager.instance.draw(buffer);
        PlayerController.instance.draw(buffer);
        HealthControllerManager.instance.draw(buffer);
        GiftControllerManager.instance.draw(buffer);
        BulletControllerManager.instance.draw(buffer);

         HoleControllerManager.instance.draw(buffer);
        graphics.drawImage(back, 0, 0, null);
    }


    protected void reset() {
        backOne = new Background(0, 0);
        backTwo = new Background(GameSetting.getInstance().getScreenWidth(), 0);
        background = Utils.loadImage("Background2");
        SingleController.speedChange = false;
        PlayerController.instance.reset();
        HealthControllerManager.instance.reset();
        FloorControllerManager.instance.reset();
        BoxControllerManager.instance.reset();
        CollsionPool.instance.reset();
        EnemyControllerManager.instance.reset();
        BulletControllerManager.instance.reset();
        HoleControllerManager.instance.reset();
        GiftControllerManager.instance.reset();
        CollsionPool.instance.add(PlayerController.instance);
    }

    protected void resetWithOutPlayer() {
        backOne = new Background(0, 0);
        backTwo = new Background(GameSetting.getInstance().getScreenWidth(), 0);
        background = Utils.loadImage("Background2");
        //PlayerController.instance.reset();
        SingleController.speedChange = false;
        HealthControllerManager.instance.reset();
        FloorControllerManager.instance.reset();
        BoxControllerManager.instance.reset();
          BulletControllerManager.instance.reset();
        CollsionPool.instance.reset();
        EnemyControllerManager.instance.reset();
        EnemyControllerManager.instance.reset();
          HoleControllerManager.instance.reset();
        GiftControllerManager.instance.reset();
        CollsionPool.instance.add(PlayerController.instance);


    }

    protected void scoreDraw(Graphics g) {
        Font font = new Font("arial", Font.TYPE1_FONT, 20);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("Score: " + ((Player) PlayerController.instance.getGameObject()).getScore(), 600, 65);
        g.drawString("Coin: " + ((Player) PlayerController.instance.getGameObject()).getCoin(), 450, 65);
    }

    protected void healthBarDraw(Graphics g) {
        GameObject gameObject = PlayerController.instance.getGameObject();
        float health = ((GameObjectWithHp) gameObject).getHp();
        float maxHealth = 50;
        float healthScale = health / maxHealth;
        Color healthBarColor = Color.GREEN;
        int healthBarX = 50;
        int healthBarY = 50;
        int healthBarWidth = 250;
        int healthBarHeight = 20;
        g.setColor(healthBarColor);
        g.fillRect(healthBarX, healthBarY, (int) (healthBarWidth * healthScale), healthBarHeight);
    }

    public void run() {
        count++;
        if (count >= 100) {
            count = 0;
            if (OptionGameScene.turnOnSound) {
                if(checkSound) {
                    Utils.playSound("resources/music.wav", false);
                    checkSound = false;
                }
            }
        }
        backOne.update();
        backTwo.update();
        PlayerController.instance.run();
        EnemyControllerManager.instance.run();
        BoxControllerManager.instance.run();
        FloorControllerManager.instance.run();
        BulletControllerManager.instance.run();
        CollsionPool.instance.run();
        GiftControllerManager.instance.run();
        HealthControllerManager.instance.run();
        HoleControllerManager.instance.run();
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

    @Override
    public MouseListener getMouseListener() {
        return this;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
