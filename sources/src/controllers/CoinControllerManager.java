package controllers;

import models.Coin;
import views.ImageDrawer;

/**
 * Created by Ha San~ on 8/27/2016.
 */
public class CoinControllerManager extends ControllerManager {
    public final static CoinControllerManager instance = new CoinControllerManager();
    private int count = 0;
    private final static int CHANGE_SIZE = 45;
    private CoinControllerManager() {
        super();
        int xCoin = 300;
        int yCoin = 250;

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 3; j++) {
                CoinController coinController = new CoinController(
                        new Coin(xCoin, yCoin), new ImageDrawer("coin")
                );
                this.add(coinController);
                yCoin += CHANGE_SIZE;
            }
            xCoin += CHANGE_SIZE*2;
            yCoin = 250;
        }
    }

    @Override
    public void run() {
        super.run();

        if (count % 1000 == 250) {
            int xCoin = 300;
            int yCoin = 250;
            for (int i = 0; i < 10; i++){
                for (int j = 0; j < 3; j++) {
                    CoinController coinController = new CoinController(
                            new Coin(xCoin, yCoin), new ImageDrawer("coin")
                    );
                    this.add(coinController);
                    yCoin += CHANGE_SIZE;
                }
                xCoin += CHANGE_SIZE*2;
                yCoin = 250;
            }
        }
        count++;
    }

    public void reset() {
        this.singleControllerVector.setSize(0);
    }
}
