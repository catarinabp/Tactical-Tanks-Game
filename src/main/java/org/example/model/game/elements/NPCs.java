package org.example.model.game.elements;

public class NPCs extends Element {
    private int life;

    public NPCs(int x, int y) {
        super(x, y);
        this.life = 5;
    }

    public void decreaseLife() {
        this.life--;
    }

    public int getLife() {
        return life;
    }

}
