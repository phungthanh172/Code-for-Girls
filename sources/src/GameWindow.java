import controllers.PlayerController;
import views.DisplayBackground;

import javax.swing.*;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class GameWindow extends JFrame {
    Image background;
    Thread thread;
    DisplayBackground scrollingBackground;


    public GameWindow() {
        System.out.println("Game window constructor");
        this.setSize(720, 480);
        this.setLocation(0, 0);
        scrollingBackground = new DisplayBackground();
        getContentPane().add(scrollingBackground);
        this.setVisible(true);
        // Add window listener
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");
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
        // add key to controller player
        this.addKeyListener(PlayerController.instance);

//        this.addMouseMotionListener(new MouseMotionListener() {
//            @Override
//            public void mouseDragged(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseMoved(MouseEvent e) {
//                plane1.moveTo(e.getX() - plane2Width / 2,
//                        e.getY() - plane2Height / 2);
//
//            }
//
//        });

    }


}
