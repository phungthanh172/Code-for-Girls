package controllers.gamescenes;

import controllers.BoxControllerManager;
import controllers.CollsionPool;
import controllers.*;
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
public class PlayGameScene implements GameScene,MouseListener {
    private Background backOne;
    private Background backTwo;
    private BufferedImage back;
    private Image background;
    GameSceneListener gameSceneListener;


    public PlayGameScene() {
        reset();
        Utils.playSound("resources/music.wav", true);
    }



    public void paint(Graphics graphics) {

        back = new BufferedImage(GameSetting.getInstance().getScreenWidth(),
                GameSetting.getInstance().getScreenHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics buffer = back.getGraphics();

        buffer.drawImage(background, backOne.getX(), backOne.getY(), null);
        buffer.drawImage(background, backTwo.getX(), backTwo.getY(), null);
        healthBarDraw(buffer);
        scoreDraw(buffer);
        PlayerController.instance.draw(buffer);
        BoxControllerManager.instance.draw(buffer);
        FloorControllerManager.instance.draw(buffer);

        graphics.drawImage(back, 0, 0, null);
    }
    private void reset(){
        backOne = new Background(0, 0);
        backTwo = new Background(GameSetting.getInstance().getScreenWidth(), 0);
        background = Utils.loadImage("Background2");
        PlayerController.instance.reset();
        FloorControllerManager.instance.reset();
        CollsionPool.instance.reset();
        CollsionPool.instance.add(PlayerController.instance);
    }
    private void scoreDraw(Graphics g) {
        Font font = new Font("arial", Font.TYPE1_FONT, 20);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("Score: " + ((Player)PlayerController.instance.getGameObject()).getScore(), 600, 65);
    }
    private void healthBarDraw(Graphics g) {
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
