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


    //private ControllerManager bulletManager;
    private GameInput gameInput;

    public static final int SPEED = 10;
    public static final int ATK_SPEED = 3;
    private static final float GRAFITY = 0.05f;
    private static final int JUMP_SPEED = 1;
    //COUNTER
    private int count;
    private float fallingSpeed;


    //STATUS : Now 3 status Jumping/Falling/Standing and future add Attacking 1, Attacking 2, Dead, Falling with VaCham and Standing meaning Running
    private boolean jumping;
    private boolean falling;
    private boolean standing;
    //


    public PlayerController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
    }


    private PlayerController(Player player, GameDrawer gameDrawer) {
        super(player, gameDrawer);
    //    this.bulletManager = new ControllerManager();
        this.gameInput = new GameInput();
        CollsionPool.instance.add(this);
        standing = true;
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
                break;
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        // TODO : DRAW BULLET IF ATTACK
        // Enter code here

        // End
    }

    @Override
    public void run() {

        count++;

        if (gameObject.isAlive()) {
            this.gameVector.dx = 0;
            if (gameInput.keyRight) {
                this.gameVector.dx += 1;
            }
            if (gameInput.keyLeft) {
                this.gameVector.dx -= 1;
            }
        }
        if (gameInput.keySpace) {
            if (standing) {
                standing = false;
                jumping = true;
                falling = false;
                fallingSpeed = 1;
                System.out.println("JUMP");
            }
        }
        // DEBUG
        //    System.out.println("TOA DO Y CUA PLAYER : " + this.getGameObject().getY());

        // Jump
        if (jumping && !falling && !standing) {
            this.gameVector.dy = -2;

        }
        // Falling
        if (falling && !jumping && !standing) {
            fallingSpeed += GRAFITY;
            this.gameVector.dy = (int)(fallingSpeed);
            System.out.println("AAA" + fallingSpeed);
        }
        //Standing
        if (standing && !falling && !jumping) {
            this.gameVector.dy = 0;
        }
        count++;
//        // Start falling
//        if (this.getGameObject().getY() < 330) {
//            standing = false;
//            jumping = false;
//            falling = true;
//        }
        //Start falling
        if (this.getGameObject().getY() > 350 || this.getGameObject().getY() < 300) {
            standing = false;
            jumping = false;
            falling = true;

            System.out.println("AAAAAAAAAAAAAAAAAAA");
        }
        // Start standing
        if (this.getGameObject().getY() >= 350) {
            this.getGameObject().setY(350);
            standing = true;
            jumping = false;
            falling = false;
            fallingSpeed = 1;
        }

        // Fall


        // Stand


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
            new Player(150, 350),
            new ImageDrawer("player")
    );

    @Override
    public void onCollide(Colliable colliable) {

        if(colliable instanceof BoxController){
            colliable.getGameObject().destroy();
            System.out.println("DEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
        }
    }
}
