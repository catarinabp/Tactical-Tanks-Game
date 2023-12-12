package org.example.model.game.elements;

import java.util.List;

public class PlayerTank extends Element {
    private int life;
    private int bullets;

    public PlayerTank(int x, int y) {
        super(x, y);
        this.life = 5;
        this.bullets = 10;
    }

    public void decreaseLife() {
        this.life--;
    }

    public void decreaseBullets() {
        this.bullets--;
    }

    public void gainBullets() {
        this.bullets++;
    }

    public int getLife() {
        return life;
    }

    public int getBullets() {
        return bullets;
    }


}
