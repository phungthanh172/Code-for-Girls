package controllers.gamescenes;

import controllers.PlayerController;
import models.GameSetting;
import models.Player;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Hau on 22/08/2016.
 */
public class GameOverGameScene implements GameScene, KeyListener, MouseListener {
    private Image backgroundImage;
    private GameSceneListener gameSceneListener;

    public GameOverGameScene() {
        backgroundImage = Utils.loadImage("brickblock");
    }

    @Override
    public void draw(Graphics g) {
//        g.drawImage(backgroundImage, 0, 0, GameSetting.getInstance().getScreenWidth(),
//                GameSetting.getInstance().getScreenHeight(), null);
        int x = GameSetting.getInstance().getScreenWidth() / 4 + 120;
        int y = GameSetting.getInstance().getScreenHeight() / 2;
        Font font = new Font("arial", Font.TYPE1_FONT, 50);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("Score" , x , y - 70);
        g.drawString("" + ((Player) PlayerController.instance.getGameObject()).getScore(), x + 35, y);
    }

    @Override
    public MouseListener getMouseListener() {
        return null;
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
}
