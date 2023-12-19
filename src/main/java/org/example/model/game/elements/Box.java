package org.example.model.game.elements;

public class Box extends Element{
    private int life;
    public Box(int x, int y) {
        super(x, y);
        this.life = 2;
    }

    public void decreaseLife() {
        this.life--;
    }

    public int getLife() {
        return life;
    }
}
