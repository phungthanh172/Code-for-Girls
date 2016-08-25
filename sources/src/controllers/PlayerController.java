package controllers;

import controllers.gamescenes.GameOverGameScene;
import controllers.gamescenes.GameSceneListener;
import models.GameObject;
import models.GameObjectWithHp;
import models.GameSetting;
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
    private static final float GRAFITY = 0.17f;
    private float floor = 400;

    GameSceneListener gameSceneListener;


    //COUNTER
    private int count;
    private int countScore;

    // Speed for fall and jump with grafity
    private float fallingSpeed;
    private float jumpingSpeed;

    // STATUS JUMPING, FALLING, STANDING
    private PlayerStatus playerStatus;
    private ImagePlayerStatus imagePlayerStatus;

    public PlayerController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
    }

    public GameSceneListener getGameSceneListener() {
        return gameSceneListener;
    }

    public void setGameSceneListener(GameSceneListener gameSceneListener) {
        this.gameSceneListener = gameSceneListener;
    }

    private PlayerController(Player player, GameDrawer gameDrawer) {
        super(player, gameDrawer);
        //    this.bulletManager = new ControllerManager();
        this.gameInput = new GameInput();
        CollsionPool.instance.add(this);
        playerStatus = PlayerStatus.STANDING;
        imagePlayerStatus = ImagePlayerStatus.RUN;
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
            case KeyEvent.VK_C:

                gameDrawer = new AnimationDrawer(
                        Utils.loadFromSprite("resources/down_final.png", true, 120, 120, 1), false, true
                );
                gameObject = new Player((int) (getGameObject().getX()), (int) (getGameObject().getY()), ImagePlayerStatus.SLIDE, ((GameObjectWithHp) (gameObject)).getHp());
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

        // TODO when change Image STT GameDraw and GameObject will be change
        //  Call function int getFloorValue(GameObject) Creat function in FloorController.instance
        // Enter code here
        // Tìm khi nào đưa gia trị Của Player Controller / Other Object xem vị trí nền của nó ở đâu trả về floor.getY()
        floor = FloorControllerManager.instance.getFloorValue(this.gameObject);

        //End
        // Check floor


        //End
        count++;
        countScore++;
        if (countScore >= 10) {
            countScore = 0;
           increaseScore();
        }


//        if (gameObject.isAlive()) {
//            this.gameVector.dx = 0;
//            if (gameInput.keyRight) {
//                speedX = 1;
//            }
//            if (gameInput.keyLeft) {
//                speedX = -1;
//            }
//        }
        float maxHighJump = 300;

        // If Space and Standing then Jump and set maxHighJump
        if (gameInput.keySpace) {
            if (playerStatus == PlayerStatus.STANDING) {
                playerStatus = PlayerStatus.JUMPING;
                setDefaultGrafitySpeed();
                maxHighJump = floor - this.getGameObject().getHeight() + FLOOR_CHANGE - JUMP_SIZE;
                // System.out.println("JUMP");
//                System.out.println("maxHighJump : " + maxHighJump);
            }
        }
        // System.out.println("Floor  : " + floor);
        // STATUS DOING
        switch (playerStatus) {
            case JUMPING:
                jumpingSpeed += GRAFITY;
                this.gameVector.dy = (int) (-jumpingSpeed);
                break;
            case FALLING:
                fallingSpeed += GRAFITY;
                this.gameVector.dy = (int) (fallingSpeed);
                break;
            case STANDING:

                this.gameVector.dy = 0;
                break;
        }


        //CHANGE STATUS
        float floorForPlayer = floor - this.getGameObject().getHeight() + FLOOR_CHANGE;
        //Start falling
        //this.getGameObject().getY() > FLOOR - this.getGameObject().getHeight() + FLOOR_CHANGE /* 350 */||
        if (this.getGameObject().getY() < maxHighJump /* 300 */) {
            playerStatus = PlayerStatus.FALLING;
            //speedX = 0.5f;
        }
        if (playerStatus != PlayerStatus.JUMPING && this.getGameObject().getY() < floorForPlayer) {
            playerStatus = PlayerStatus.FALLING;
        }
        // Start standing

        if (this.getGameObject().getY() >= floorForPlayer && this.getGameObject().getY() < floorForPlayer + FLOOR_CHANGE /* 350 */) {
            this.getGameObject().setY(floorForPlayer);
            playerStatus = PlayerStatus.STANDING;
            setDefaultGrafitySpeed();
        }

        if (checkFallDeep()) {
            gameSceneListener.changeGameScene(new GameOverGameScene(), false);
            gameObject.destroy();
        }

        super.run();

    }

    public boolean checkFallDeep() {
        if (getGameObject().getY() > 480) return true;
        return false;
    }

    public final static PlayerController instance = new PlayerController(
            new Player(150, 350),
            new AnimationDrawer(
                    Utils.loadFromSprite("resources/spritePlayerFinal.png", true, 90, 160, 1)
            )
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

    public void increaseScore() {
        ((Player) gameObject).increaseScore();
    }

    public void decreaseHP(int amount) {
        ((GameObjectWithHp) gameObject).decreaseHP(amount);
    }
}
