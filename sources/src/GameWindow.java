import controllers.PlayerController;
import controllers.gamescenes.GameScene;
import controllers.gamescenes.GameSceneListener;
import controllers.gamescenes.MenuGameScene;
import controllers.gamescenes.PlayGameScene;
import models.GameSetting;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.Stack;


public class GameWindow extends Frame implements Runnable, GameSceneListener{
    BufferedImage bufferedImage;
    Graphics graphicsBufferImage;
    Thread thread;
    GameSetting gameSetting;
    GameScene currentGameScene;
    private Stack<GameScene> stack;



    public GameWindow() {
        configUI();
        stack = new Stack<>();
        changeGameScene(new MenuGameScene(), false);
//         add key to controller player
        this.addKeyListener(PlayerController.instance);
        bufferedImage = new BufferedImage(gameSetting.getScreenWidth(), gameSetting.getScreenHeight(), BufferedImage.TYPE_INT_ARGB);
        graphicsBufferImage = bufferedImage.getGraphics();
        thread = new Thread(this);
        thread.start();

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    GameWindow.this.back();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    private void configUI() {
        gameSetting = GameSetting.getInstance();
        this.setSize(gameSetting.getScreenWidth(), gameSetting.getScreenHeight());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    @Override
    public void update(Graphics g) {
        currentGameScene.draw(graphicsBufferImage);
        g.drawImage(bufferedImage, 0, 0, null);
    }

    @Override
    public void run() {
        while (true) {
            try {
                currentGameScene.run();
                Thread.sleep(gameSetting.getThreadDelay());
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void changeGameScene(GameScene gameScene, boolean addToStack) {
        if(currentGameScene != null && addToStack) {
            this.removeKeyListener(currentGameScene.getKeyListener());
//            this.removeMouseListener(currentGameScene.getMouseListener());
            this.stack.push(currentGameScene);
        }
        currentGameScene = gameScene;
        currentGameScene.setGameSceneListener(this);
        this.addKeyListener(currentGameScene.getKeyListener());
        this.addMouseListener(currentGameScene.getMouseListener());

    }

    @Override
    public void back() {
        if(!stack.isEmpty()) {
            this.removeKeyListener(currentGameScene.getKeyListener());
            this.removeMouseListener(currentGameScene.getMouseListener());
            currentGameScene = stack.pop();
            currentGameScene.setGameSceneListener(this);
            this.addKeyListener(currentGameScene.getKeyListener());
        } else {
            //System.exit(0);
        }
    }
}
