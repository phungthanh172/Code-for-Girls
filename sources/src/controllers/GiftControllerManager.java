package controllers;

import java.util.Random;

/**
 * Created by Dell latitude E6520 on 8/27/2016.
 */
public class GiftControllerManager extends ControllerManager {
    public static  final GiftControllerManager instance = new GiftControllerManager();
    int count;

    @Override
    public void run() {
        super.run();
        count++;
        if (count >= 500){
            count = 0;
            Random r = new Random();
            int y = r.nextInt(50) + 350;
            System.out.println(y);
            GiftSpeedController giftSpeedController = GiftSpeedController.create(720, y);
            this.add(giftSpeedController);
        }
    }
    public void reset(){
        singleControllerVector.setSize(0);
    }
}
