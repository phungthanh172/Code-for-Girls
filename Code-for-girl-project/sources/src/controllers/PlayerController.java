package controllers;

import models.GameObject;
import models.Player;
import views.GameDrawer;
import views.ImageDrawer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by qhuydtvt on 7/30/2016.
 */
public class PlayerController extends SingleController
        implements KeyListener, Colliable {

    public static final int SPEED = 10;
    public static final int ATK_SPEED = 3;
    private int count;
    private boolean jumping;
    private boolean falling;
    private boolean standing;


    private ControllerManager bulletManager;
    private GameInput gameInput;

    public PlayerController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
    }


    private PlayerController(Player player, GameDrawer gameDrawer) {
        super(player, gameDrawer);
        this.bulletManager = new ControllerManager();
        this.gameInput = new GameInput();
        CollsionPool.instance.add(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                this.gameInput.keyUp = true;
                break;
            case KeyEvent.VK_DOWN:
                this.gameInput.keyDown = true;
                break;
            case KeyEvent.VK_LEFT:
                this.gameInput.keyLeft = true;
                break;
            case KeyEvent.VK_RIGHT:
                this.gameInput.keyRight = true;
                break;
            case KeyEvent.VK_SPACE:
                //jumping = true;
                this.gameInput.keySpace = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                this.gameInput.keyUp = false;
                break;
            case KeyEvent.VK_DOWN:
                this.gameInput.keyDown = false;
                break;
            case KeyEvent.VK_LEFT:
                this.gameInput.keyLeft = false;
                break;
            case KeyEvent.VK_RIGHT:
                this.gameInput.keyRight = false;
                break;
            case KeyEvent.VK_SPACE:
                this.gameInput.keySpace = false;
                //jumping = false;
                break;
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);

    }

    @Override
    public void run() {

        count++;
//        this.gameVector.dx = 0;
//        this.gameVector.dy = 0;
//
//        if(gameInput.keyDown && !gameInput.keyUp) {
//            this.gameVector.dy = SPEED;
//        } else if(!gameInput.keyDown && gameInput.keyUp) {
//            this.gameVector.dy = -SPEED;
//        }
//
//        if(gameInput.keyLeft && !gameInput.keyRight) {
//            this.gameVector.dx = -SPEED;
//        } else if(!gameInput.keyLeft && gameInput.keyRight) {
//            this.gameVector.dx = SPEED;
//        }
//        if(gameInput.keyUp) {
//            this.gameVector.dy = SPEED;
//        if (this.getGameObject().isAlive()) {
//            this.gameVector.dx = 0;
//        }


        if (gameInput.keySpace) {

            standing = false;
            jumping = true;
            falling = false;
            System.out.println("JUMP");
            System.out.println(count);
                
        }

        // Jump
        if (jumping == true && !falling && !standing) {
            this.gameVector.dy = -1;
            if (count % 5 == 0) {
                falling = true;
                jumping = false;
                standing = false;
                System.out.println("Change status falling");
            }

        }
        if (falling == true && !jumping && !standing) {
            this.gameVector.dy = 1;
            if (count % 5 == 0) {
                falling = false;
                jumping = false;
                standing = true;
                System.out.println("Change status jumping");
            }
        }
        if (standing && !falling && !jumping) {
            this.gameVector.dy = 0;


        }
        count++;


        // Fall


        // Stand


//        if (!falling && !jumping) {
//            this.gameVector.dy = 0;
//
//        }
//        if (jumping && !falling) {
//            this.gameVector.dy = -3;
//            if (count % 5 == 0) {
//                falling = true;
//                jumping = false;
//            }
//            System.out.println("Jumping");
//        } else if (falling && !jumping) {
//            this.gameVector.dy = 3;
//            if (count % 5 == 0) {
//                falling = false;
//                jumping = false;
//            }
//            System.out.println("Falling");
//        }


//            if(count > ATK_SPEED) {
////                BulletController bulletController = new BulletController(
////                        new Bullet(this.gameObject.getMiddleX() - Bullet.WIDTH / 2, this.gameObject.getY()),
////                        new ImageDrawer("resources/bullet.png")
//                );
//                bulletManager.add(bulletController);
//                count = 0;
//            }


        //       }
//        if(input.isKeyDown(Input.KEY_RIGHT)){
//            character = moveRight;
//            charX += 0.1f*delta;
//            playerPoly.setX(charX);
//            if(entityCollision()){
//                charX -= 0.1f*delta;
//                playerPoly.setX(charX);
//            }
//        }
//        if(input.isKeyDown(Input.KEY_LEFT)){
//            character = moveLeft;
//            charX -= 0.1f*delta;
//            playerPoly.setX(charX);
//            if(entityCollision()){
//                charX += 0.1f*delta;
//                playerPoly.setX(charX);
//            }
//            else{
//                isFalling = true;
//            }
//        }
//
//        if(input.isKeyPressed(Input.KEY_UP) && isFalling == false){
//            isJumping = true;
//            jumpVelocity = -0.6f;
//        }
//        if(isJumping){
//            charY += jumpVelocity*delta;
//            jumpVelocity += 0.01f;
//            playerPoly.setY(charY);
//
//            if(jumpVelocity >= 0){ //Switches to fall mode
//                isFalling = true;
//                isJumping = false;
//                fallVelocity = 0.1f;
//                gravity = 0.01f;
//            }
//        }
//
//        if(isFalling){
//            fallVelocity += gravity;
//            charY += fallVelocity*delta;
//            playerPoly.setY(charY);
//            if(entityCollision()){
//                float i = collisionBlock.blockPoly.getMinY();
//                fallVelocity = 0;
//                gravity = 0;
//                charY = (i)-playerPoly.getHeight();
//                playerPoly.setY(charY);
//                isFalling = false;
//            }
//
//        }
//    }
//    public boolean entityCollision() throws SlickException{
//        for(int i = 0; i < TestMap.blocks.size(); i++){
//            Block entity = (Block)TestMap.blocks.get(i);
//            if(playerPoly.intersects(entity.blockPoly)){
//                collisionBlock = (Block)TestMap.blocks.get(i);
//                return true;
//            }
//        }
//        return false;
//    }


        super.run();

    }

    public final static PlayerController instance = new PlayerController(
            new Player(250, 250),
            new ImageDrawer("player")
    );

    @Override
    public void onCollide(Colliable colliable) {

    }
}
