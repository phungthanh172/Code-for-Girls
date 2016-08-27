package controllers;

import controllers.gamescenes.GameOverGameScene;
import controllers.gamescenes.GameSceneListener;
import controllers.gamescenes.PlayGameScene2;
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
    private static final int JUMP_SIZE = 70 ;
    private static final int FLOOR_CHANGE = 15;
    private static final float GRAFITY = 0.1f;
    private float floor = 400;
    private boolean changeStatus;
    GameSceneListener gameSceneListener;
    private float maxHighJump = 300;
    //COUNTER
    private int count;

    // Speed for fall and jump with grafity
    private float fallingSpeed;
    private float jumpingSpeed;

    // STATUS JUMPING, FALLING, STANDING
    private PlayerStatus playerStatus;
    private ImagePlayerStatus imagePlayerStatus;
    private int countScore;
    private int countDie;

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
                if(imagePlayerStatus == ImagePlayerStatus.RUN) {
                    gameDrawer = new AnimationDrawer(
                            Utils.loadFromSprite("resources/down_final.png", true, 120, 120, 1), false, true
                            , 14);
                    gameObject = new Player((int) (getGameObject().getX()), (int) (getGameObject().getY()), ImagePlayerStatus.SLIDE, ((GameObjectWithHp) (gameObject)).getHp(), ((Player) (gameObject)).getScore(), ((Player)(gameObject)).getCoin());
                    imagePlayerStatus = ImagePlayerStatus.SLIDE;
                }

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

                if(imagePlayerStatus == ImagePlayerStatus.SLIDE) {
                    gameDrawer = new AnimationDrawer(
                            Utils.loadFromSprite("resources/spritePlayerFinal.png", true, 90, 160, 1)
                    );
                    gameObject = new Player((int) (getGameObject().getX()), (int) (getGameObject().getY()), ImagePlayerStatus.RUN, ((GameObjectWithHp) (gameObject)).getHp(), ((Player)(gameObject)).getScore(), ((Player)(gameObject)).getCoin());
                    imagePlayerStatus = ImagePlayerStatus.RUN;
                }

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
        fallingSpeed = 3f;
        jumpingSpeed = 4.5f;
    }
    void showmess(){
        for (int i = 0; i <20; i ++){
            if(i==19){
                gameSceneListener.changeGameScene(new GameOverGameScene(), false);
            }
        }
//        countDie++;
//        System.out.println(countDie);
//        if (countDie >= 5) {
//            gameSceneListener.changeGameScene(new GameOverGameScene(), false);
//        }
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
        gameVector.dx = 0;
        count++;
        countScore++;
        if (countScore >= 10) {
            countScore = 0;
            increaseScore();
        }
        //System.out.println(imagePlayerStatus);
        if(imagePlayerStatus == ImagePlayerStatus.DEAD){
            countDie++;
            System.out.println(countDie);
            if (countDie >= 40) {
            gameSceneListener.changeGameScene(new GameOverGameScene(), false);
        }

        }
        if (!gameObject.isAlive()) {
            die();
            //showmess();
            //gameSceneListener.changeGameScene(new GameOverGameScene(), false);
            return;
        }

        if(gameObject.isAlive() && gameInput.keyDown){

        }


        // If Space and Standing then Jump and set maxHighJump
        if (gameInput.keySpace) {
            System.out.println("Height : " + this.getGameObject().getHeight());
            System.out.println("floor : " + floor);
            System.out.println("maxHighJump : " + maxHighJump);
            if(playerStatus == PlayerStatus.STANDING) {
                maxHighJump = floor - this.getGameObject().getHeight() + FLOOR_CHANGE - JUMP_SIZE;
                playerStatus = PlayerStatus.JUMPING;
                setDefaultGrafitySpeed();
                Utils.playSound("resources/jump.wav", false);
                // System.out.println("JUMP");
            }
        }
       // System.out.println("Floor  : " + floor);
        // STATUS DOING
        switch (playerStatus) {
            case JUMPING:
                jumpingSpeed -= GRAFITY/3;
            this.gameVector.dy = (int)(-jumpingSpeed);
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


        //CHANGE STATUS
        float floorForPlayer = floor - this.getGameObject().getHeight() + FLOOR_CHANGE;
        //Start falling
        //this.getGameObject().getY() > FLOOR - this.getGameObject().getHeight() + FLOOR_CHANGE /* 350 */||
        if (this.getGameObject().getY() < maxHighJump /* 300 */) {
            playerStatus = PlayerStatus.FALLING;
            //speedX = 0.5f;
        }
        if(playerStatus != PlayerStatus.JUMPING && this.getGameObject().getY() < floorForPlayer){
            playerStatus = PlayerStatus.FALLING;
        }
        // Start standing

        if (this.getGameObject().getY() >= floorForPlayer && this.getGameObject().getY() < floorForPlayer + FLOOR_CHANGE /* 350 */) {
            this.getGameObject().setY(floorForPlayer);
            playerStatus = PlayerStatus.STANDING;
            setDefaultGrafitySpeed();
        }

        if(checkFallDeep()){
            gameSceneListener.changeGameScene(new GameOverGameScene(), false);
            gameObject.destroy();
        }

        super.run();

    }
    public boolean checkFallDeep(){
    if(getGameObject().getY() > 430) return true;
        return false;
    }

    public static PlayerController instance = new PlayerController(
            new Player(150,350,0),
            new AnimationDrawer(
                    Utils.loadFromSprite("resources/spritePlayerFinal.png", true, 90, 160, 1)
            )
    );

    @Override
    public void onCollide(Colliable colliable) {

//        if(colliable instanceof FloorController) {
//            if(CollsionPool.vaChamChet(this, colliable)){
//                this.gameVector.dx = -1;
//            }
//        }
        if(colliable instanceof HoleController){
            gameSceneListener.changeGameScene(new PlayGameScene2(),false);
        }
    }

    public void decreaseHP(int amount) {
        ((GameObjectWithHp)gameObject).decreaseHP(amount);
    }
    public void increaseHP(int amount){
        ((GameObjectWithHp)gameObject).increaseHP(amount);
    }
    public void increaseScore() {
        ((Player) gameObject).increaseScore();
    }
    public static void reset(){
        instance = new PlayerController(
                new Player(150,350,0),
                new AnimationDrawer(Utils.loadFromSprite("resources/spritePlayerFinal.png", true, 90, 160, 1)));
    }
    private void die() {
        AnimationDrawer animationDrawer = new AnimationDrawer(
                Utils.loadFromSprite("resources/dead_final.png", true, 160, 160, 1), false, true, 14
        );
        gameObject = new Player((int) (getGameObject().getX()), (int) (getGameObject().getY()), ImagePlayerStatus.DEAD, 0, ((Player)(gameObject)).getScore(), ((Player)(gameObject)).getCoin());
        gameDrawer = animationDrawer;
        imagePlayerStatus = ImagePlayerStatus.DEAD;
    }
    public void increaseCoin(int amount){
        ((Player)gameObject).increaseCoin(amount);
    }
}
