package controllers.gamescenes;

import controllers.*;
import models.*;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

/**
 * Created by KhacThanh on 8/27/2016.
 */
public class PlayGameScene3 implements GameScene,MouseListener {
    protected Background backOne;
    protected Background backTwo;
    protected BufferedImage back;
    protected Image background;
    protected GameSceneListener gameSceneListener;
    private int count;

    public PlayGameScene3(){
        reset();

    }
    public PlayGameScene3(boolean resetPlayer) {
        if(resetPlayer){
            reset();} else {
            resetWithOutPlayer();

        }       // Utils.playSound("resources/music.wav", true);
    }

    protected void resetWithOutPlayer() {
        backOne = new Background(0, 0);
        backTwo = new Background(GameSetting.getInstance().getScreenWidth(), 0);
        background = Utils.loadImage("Background2");
        System.out.println("dddddddddddddddddddd");
        FloorControllerManager2.instance.reset();
        CoinControllerManager.instance.reset();
        CollsionPool.instance.reset();
    }


    public void paint(Graphics graphics) {

        back = new BufferedImage(GameSetting.getInstance().getScreenWidth(),
                GameSetting.getInstance().getScreenHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics buffer = back.getGraphics();

        buffer.drawImage(background, backOne.getX(), backOne.getY(), null);
        buffer.drawImage(background, backTwo.getX(), backTwo.getY(), null);
        healthBarDraw(buffer);
        scoreDraw(buffer);
        FloorControllerManager.instance.draw(buffer);
//        BoxControllerManager.instance.draw(buffer);
        PlayerController.instance.draw(buffer);
//        HealthControllerManager.instance.draw(buffer);
//        GiftControllerManager.instance.draw(buffer);
        HoleControllerManager.instance.draw(buffer);
        graphics.drawImage(back, 0, 0, null);
    }
    protected void reset(){
        backOne = new Background(0, 0);
        backTwo = new Background(GameSetting.getInstance().getScreenWidth(), 0);
        PlayerController.instance.reset();
        background = Utils.loadImage("Background2");
        System.out.println("dddddddddddddddddddd");
        FloorControllerManager2.instance.reset();
        CoinControllerManager.instance.reset();
        CollsionPool.instance.reset();
    }
    protected void scoreDraw(Graphics g) {
        Font font = new Font("arial", Font.TYPE1_FONT, 20);
        g.setFont(font);
        g.setColor(Color.red);
        g.drawString("Score: " + ((Player)PlayerController.instance.getGameObject()).getScore(), 600, 65);
        g.drawString("Coin: " + ((Player)PlayerController.instance.getGameObject()).getCoin(), 450, 65);
    }
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
