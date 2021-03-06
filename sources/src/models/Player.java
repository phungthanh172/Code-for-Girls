package models;

import controllers.ImagePlayerStatus;

/**
 * Created by KhacThanh on 8/6/2016.
 */
public class Player extends GameObjectWithHp{
    private static final int DEFAULT_RUN_WIDTH = 45;
    private static final int DEFAULT_RUN_HEIGHT = 75;
    private static final int DEFAULT_SLIDE_WIDTH = 70;
    private static final int DEFAULT_SLIDE_HEIGHT = 70;
    private static final int DEFAULT_DEAD_WIDTH = 75;
    private static final int DEFAULT_DEAD_HEIGHT = 75;
    private static final int HP_DEFAULT = 50;
    public int getScore() {
        return score;
    }
    private int coin;

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public void increaseCoin(int amount) {
        this.coin += amount;
    }
    private int score;
    public Player(int x, int y, int width, int height, int hp, int score,int coin) {
        super(x, y, width, height, hp);
        this.score = score;
        this.coin = coin;
    }
    public Player(int x, int y, int score) {
        super(x, y, DEFAULT_RUN_WIDTH, DEFAULT_RUN_HEIGHT, HP_DEFAULT);
        this.score = score;
    }
    public Player(int x, int y, ImagePlayerStatus imagePlayerStatus, int hp, int score,int coin) {
        super(x, y, DEFAULT_RUN_WIDTH, DEFAULT_RUN_HEIGHT, hp);
        switch (imagePlayerStatus) {
            case RUN:
                width = DEFAULT_RUN_WIDTH;
                height = DEFAULT_RUN_HEIGHT;
                break;
            case SLIDE:
                width = DEFAULT_SLIDE_WIDTH;
                height = DEFAULT_SLIDE_HEIGHT;
                break;
            case DEAD:
                width = DEFAULT_DEAD_WIDTH;
                height = DEFAULT_DEAD_HEIGHT;
                break;
        }
        this.score = score;
        this.coin=coin;
    }
    public void increaseScore() {
        this.score++;
    }

}
