package controllers.gamescenes;

/**
 * Created by Hau on 22/08/2016.
 */
public interface GameSceneListener {
    void changeGameScene(GameScene gameScene, boolean addToStack);
    void back();
}
