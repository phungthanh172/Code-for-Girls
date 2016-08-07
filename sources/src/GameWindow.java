import controllers.PlayerController;
import controllers.ScrollingBackground;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


/**
 * Created by qhuydtvt on 7/24/2016.
 */
public class GameWindow extends JFrame {
    Image background;

//    BufferedImage bufferedImage;
//    Graphics bufferImageGraphic;
    Thread thread;
    ScrollingBackground scrollingBackground;
//    PlaneController planeController1;

    public GameWindow() {
        System.out.println("Game window constructor");
        this.setSize(720, 480);
        this.setLocation(0, 0);
        scrollingBackground = new ScrollingBackground();
        getContentPane().add(scrollingBackground);
        this.setVisible(true);
        //background = Utils.loadImage("Background");
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

        //background =  Utils.loadImage("background");


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
//        CollsionPool.instance.add(PlayerController.instance);
//        this.bufferedImage = new BufferedImage(720, 480, BufferedImage.TYPE_INT_ARGB);
//        this.bufferImageGraphic = bufferedImage.getGraphics();
        //thread = new Thread(this);
        //thread.start();
    }

//    @Override
//    public void update(Graphics g) {
//       // bufferImageGraphic.drawImage(background, 0, 0, null);
////        PlayerController.instance.draw(bufferImageGraphic);
////        BoxManager.instance.draw(bufferImageGraphic);
////        FloorManager.instance.draw(bufferImageGraphic);
////        g.drawImage(bufferedImage, 0, 0, null);
//
//    }
//
//    @Override
//    public void run() {
//
////        while (true) {
////            try {
////                scrollingBackground.run();
////                PlayerController.instance.run();
////                BoxManager.instance.run();
////                FloorManager.instance.run();
////                Thread.sleep(17);
////                repaint();
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
////        }
//    }
}
