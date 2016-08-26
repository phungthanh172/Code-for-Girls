package controllers.gamescenes;

import models.GameSetting;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Created by Hau on 27/08/2016.
 */
public class OptionGameScene implements GameScene, KeyListener {
    private static final int WIDTH_BUTTON = 30;
    private static final int HEIGHT_BUTTON = 30;
    private final Rectangle soundButton;
    Image background;
    static Image tick;
    public static boolean turnOnSound;
    GameSceneListener gameSceneListener;
    @Override
    public KeyListener getKeyListener() {
        return this;
    }

    public OptionGameScene() {
        this.turnOnSound = false;
        this.background = Utils.loadImage("Background");
        soundButton = new Rectangle(GameSetting.getInstance().getScreenWidth() / 4 + 200, 200, WIDTH_BUTTON, HEIGHT_BUTTON);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(background, 0, 0, null);
        Font font = new Font("arial", Font.TYPE1_FONT, 50);
        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString("Sound", soundButton.x - 200, soundButton.y + 28);
        g.drawImage(tick, soundButton.x, soundButton.y, 50, 30, null);
        g2d.draw(soundButton);
    }

    @Override
    public void setGameSceneListener(GameSceneListener gameSceneListener) {
        this.gameSceneListener = gameSceneListener;
    }

    @Override
    public MouseListener getMouseListener() {
        return null;
    }

    @Override
    public void run() {
        if (tick == null) {
            turnOnSound = false;
        } else {
            turnOnSound = true;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (tick == null) {
                tick = Utils.loadImage("tick");
            } else {
                tick = null;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
