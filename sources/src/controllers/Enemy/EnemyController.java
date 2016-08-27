package controllers.Enemy;

import controllers.Colliable;
import controllers.CollsionPool;
import controllers.PlayerController;
import controllers.SingleController;
import models.Enemy;
import models.EnemyBullet;
import models.GameSetting;
import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by Ha San~ on 8/24/2016.
 */
public class EnemyController extends SingleController implements Colliable {
    private int count;
    private static final int SHOT_SPEED = 3000;
    private static final int BULLET_SPEED = 5;

    public EnemyController(Enemy gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);

 //       this.gameVector.dx = -SPEED;
        CollsionPool.instance.add(this);
    }

    @Override
    public void run() {
        this.gameVector.dx = -0;
        super.run();
        count ++;
        if (GameSetting.getInstance().toSeconds(count) >= SHOT_SPEED) {
            count = 0 ;
            EnemyBulletController enemyBulletController =
                    new EnemyBulletController(
                            new EnemyBullet( (int)(this.gameObject.getMiddleX() - EnemyBullet.SIZE / 2), (int) (this.gameObject.getBottom())),
                            new ImageDrawer("bullet")
                    );
            float dx = PlayerController.instance.getGameObject().getX() - PlayerController.instance.getGameObject().getHeight() - gameObject.getX() + gameObject.getHeight();
            float dy = PlayerController.instance.getGameObject().getY() - gameObject.getBottom();
//            float dx = 150;
//            float dy = 300;
            System.out.println("Dx " + dx);
            if (dy > 0) {
                double ratio = Math.sqrt(dx * dx + dy * dy) / BULLET_SPEED;

                enemyBulletController.getGameVector().dy = (int)(dy / ratio);
                enemyBulletController.getGameVector().dx = (int)(dx / ratio);

                EnemyBulletControllerManager.instance.add(enemyBulletController);
            }

        }

    }

    @Override
    public void onCollide(Colliable colliable) {
//        if(colliable instanceof BulletController){
//            this.getGameObject().destroy();
//        }
    }

}
