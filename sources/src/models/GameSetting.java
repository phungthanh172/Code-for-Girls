package models;

import controllers.SceneState;

/**
 * Created by Hau on 22/08/2016.
 */
public class GameSetting {
    private static final int THREAD_DELAY = 17;
    private static final int WIDTH_DEFAULT = 720;
    private static final int HEIGHT_DEFAUT = 480;
    private int screenWidth;
    private int screenHeight;
    private int threadDelay;
    public static SceneState sceneState;
    public GameSetting(int screenWidth, int screenHeight, int threadDelay) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.threadDelay = threadDelay;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public int getThreadDelay() {
        return threadDelay;
    }

    public void setThreadDelay(int threadDelay) {
        this.threadDelay = threadDelay;
    }

    private static GameSetting instance = null;

    public int toSeconds(int countThread) {
        return (countThread * THREAD_DELAY);
    }

    public static GameSetting getInstance() {
        if (instance == null) {
            instance = new GameSetting(WIDTH_DEFAULT, HEIGHT_DEFAUT, THREAD_DELAY);
        }
        return instance;
    }
}
