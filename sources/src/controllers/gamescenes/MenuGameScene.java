package controllers.gamescenes;

import models.GameSetting;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Hau on 22/08/2016.
 */
public class MenuGameScene implements GameScene, KeyListener, MouseListener {
    private static final String TAG = MenuGameScene.class.toString();
    private GameSceneListener gameSceneListener;
    private Image background;

    private Rectangle playButton;
    private Rectangle optionButton;
    private Rectangle quitButton;

    private final int WIDTH_BUTTON = 200;
    private final int HEIGHT_BUTTON = 50;

    public MenuGameScene() {
        background = Utils.loadImage("MENU");
        playButton = new Rectangle(GameSetting.getInstance().getScreenWidth() / 4 + 70, 200, WIDTH_BUTTON, HEIGHT_BUTTON);
        optionButton = new Rectangle(GameSetting.getInstance().getScreenWidth() / 4 + 70, 300, WIDTH_BUTTON, HEIGHT_BUTTON);
        quitButton = new Rectangle(GameSetting.getInstance().getScreenWidth() / 4 + 70, 400, WIDTH_BUTTON, HEIGHT_BUTTON);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(background, 0, 0, null);
        /*TODO: Draw menu */
        Font font = new Font("arial", Font.BOLD, 50);
        g.setFont(font);
        g.setColor(Color.BLACK);
//        g.drawString("SPACE GAME", GameSetting.getInstance().getScreenWidth() / 4, 150);
        Font font1 = new Font("arial", Font.BOLD, 30);
        g.setFont(font1);
//        g.drawString("Play", playButton.x + 67, playButton.y + 35);
//        g.drawString("Option", optionButton.x + 54, optionButton.y + 35);
//        g.drawString("Quit", quitButton.x + 67, quitButton.y + 35);
//        g2d.draw(playButton);
//        g2d.draw(optionButton);
//        g2d.draw(quitButton);


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
    public MouseListener getMouseListener() {
        return this;
    }

    @Override
    public void run() {
        /*TODO: Run menu */
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (gameSceneListener != null)
                gameSceneListener.changeGameScene(new StoryGameScene(), true);
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
        int mx = e.getX();
        int my = e.getY();

        // Play button
        if (mx >= GameSetting.getInstance().getScreenWidth() / 4 + 70 && mx <= GameSetting.getInstance().getScreenWidth() / 4 + 70 + WIDTH_BUTTON) {
            if (my >= 200 && my <= 200 + HEIGHT_BUTTON) {
                if (gameSceneListener != null)
                    gameSceneListener.changeGameScene(new StoryGameScene(), true);
                else {
                    System.out.println(String.format(
                            "%s : gameSceneListener is not set",
                            TAG
                    ));
                }
                System.out.println("1212");
            }
        }

        // Option button
        if (mx >= GameSetting.getInstance().getScreenWidth() / 4 + 70 && mx <= GameSetting.getInstance().getScreenWidth() / 4 + 70 + WIDTH_BUTTON) {
            if (my >= 300 && my <= 300 + HEIGHT_BUTTON) {
                if (gameSceneListener != null)
                    gameSceneListener.changeGameScene(new OptionGameScene(), true);
                else {
                    System.out.println(String.format(
                            "%s : gameSceneListener is not set",
                            TAG
                    ));
                }
                System.out.println("1212");
            }
        }

        // Quit button
        if (mx >= GameSetting.getInstance().getScreenWidth() / 4 + 70 && mx <= GameSetting.getInstance().getScreenWidth() / 4 + 70 + WIDTH_BUTTON) {
            if (my >= 400 && my <= 400 + HEIGHT_BUTTON) {
                System.exit(0);
            }
        }
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
