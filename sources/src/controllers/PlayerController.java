package controllers;

import controllers.gamescenes.GameOverGameScene;
import controllers.gamescenes.GameSceneListener;
import models.GameObject;
import models.GameObjectWithHp;
import models.Player;
import utils.Utils;
import views.AnimationDrawer;
import views.GameDrawer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Thành Đẹp Trai on Một ngày đẹp trời.
 */
public class PlayerController extends SingleController
        implements KeyListener, Colliable {

    private GameInput gameInput;
    private static final int JUMP_SIZE = 70;

    private static final int FLOOR_CHANGE = 13;

    public static final int SPEED = 10;
    public static final int ATK_SPEED = 3;
    private static final float GRAFITY = 0.15f;
    private static final int JUMP_SPEED = 1;

    private float floor = 400;

    GameSceneListener gameSceneListener;
    private float walkX = 0;

    public GameSceneListener getGameSceneListener() {
        return gameSceneListener;
    }

    public void setGameSceneListener(GameSceneListener gameSceneListener) {
        this.gameSceneListener = gameSceneListener;
    }

    //COUNTER
    private int count;
    private float fallingSpeed;
    private float jumpingSpeed;
    private float speedX= 0.5f;

    //STATUS : Now 3 status Jumping/Falling/Standing and future add Attacking 1, Attacking 2, Dead, Falling with VaCham and Standing meaning Running
    private boolean jumping;
    private boolean falling;
    private boolean standing;
    //
    private PlayerStatus playerStatus;

    public PlayerController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
    }


    private PlayerController(Player player, GameDrawer gameDrawer) {
        super(player, gameDrawer);
    //    this.bulletManager = new ControllerManager();
        this.gameInput = new GameInput();
        CollsionPool.instance.add(this);
        //standing = true;
        playerStatus = PlayerStatus.STANDING;
        floor = 400;
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
            case KeyEvent.VK_S:
                gameSceneListener.changeGameScene(new GameOverGameScene(), false);
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
        // Enter code here

        // End
    }
    private void setDefaultGrafitySpeed() {
        fallingSpeed = 1f;
        jumpingSpeed = 2f;
    }
    @Override
    public void run() {
        //  Call function int getFloorValue(GameObject) Creat function in FloorController.instance
        // Enter code here
        // Tìm khi nào đưa gia trị Của Player Controller / Other Object xem vị trí nền của nó ở đâu trả về floor.getY()
        floor = FloorControllerManager.instance.getFloorValue(this.gameObject);

        //End
        // Check floor


        //End
        count++;

        if (gameObject.isAlive()) {
            this.gameVector.dx = speedX;
            if (gameInput.keyRight) {
                speedX = 1;
            }
            if (gameInput.keyLeft) {
                speedX = -1;
            }
        }

        if (gameInput.keySpace) {
            if(playerStatus == PlayerStatus.STANDING) {
                playerStatus = PlayerStatus.JUMPING;
                setDefaultGrafitySpeed();
               // System.out.println("JUMP");
            }
        }

        // STATUS DOING
        switch (playerStatus) {
            case JUMPING:
                jumpingSpeed += GRAFITY;
            this.gameVector.dy = (int)(-jumpingSpeed);
                speedX = 1;
                break;
            case FALLING:
                fallingSpeed += GRAFITY;

                this.gameVector.dy = (int)(fallingSpeed);
                break;
            case STANDING:

                this.gameVector.dy = 0;
                break;
        }
        count++;
        float maxHighJump = 300;
        if(floor <= 480) {
            maxHighJump = floor - this.getGameObject().getHeight() + FLOOR_CHANGE - JUMP_SIZE;
        }
        //CHANGE STATUS
        //Start falling
        //this.getGameObject().getY() > FLOOR - this.getGameObject().getHeight() + FLOOR_CHANGE /* 350 */||
        if (this.getGameObject().getY() < maxHighJump /* 300 */) {
            playerStatus = PlayerStatus.FALLING;
            //speedX = 0.5f;
        }
        // Start standing

        if (this.getGameObject().getY() >= floor - this.getGameObject().getHeight() + FLOOR_CHANGE  /* 350 */) {
            this.getGameObject().setY(floor - this.getGameObject().getHeight() + FLOOR_CHANGE);
            playerStatus = PlayerStatus.STANDING;
            setDefaultGrafitySpeed();
            //speedX = 0;
        }

//        if(gameObject.getX() > 480 - gameObject.getHeight()){
////            gameSceneListener.changeGameScene(new GameOverGameScene(), false);
//            gameObject.destroy();
//        }

        super.run();

    }

    public final static PlayerController instance = new PlayerController(
            new Player(150, 350),
            new AnimationDrawer(
                    Utils.loadFromSprite("resources/spritePlayerFinal.png", true, 90, 160, 1)
            )

//            new ImageDrawer(Utils.loadImage("player"))
    );

    @Override
    public void onCollide(Colliable colliable) {

//        if(colliable instanceof BoxController){
//            colliable.getGameObject().destroy();
//        }
//        else if(colliable instanceof FloorController) {
//            floor = (int)colliable.getGameObject().getY();
//        }
    }

    public void decreaseHP(int amount) {
        ((GameObjectWithHp)gameObject).decreaseHP(amount);
    }
}
