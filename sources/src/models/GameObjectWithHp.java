package models;

/**
 * Created by Hau on 24/08/2016.
 */
public class GameObjectWithHp extends GameObject {

    private int hp;
    private int maxHP;

    public int getMaxHP() {
        return maxHP;
    }

    public GameObjectWithHp(int x, int y, int width, int height, int maxHP) {
        super(x, y, width, height);
        this.hp = maxHP;
        this.maxHP = maxHP;
    }

    public int getHp() {
        return hp;
    }

    public void increaseHP(int amount) {
        this.hp += amount;
        if(this.hp > maxHP)
            this.hp = maxHP;
    }

    public void decreaseHP (int amount)
    {
        this.hp -= amount;
        if(this.hp <= 0) {
            destroy();
        }
    }
}
