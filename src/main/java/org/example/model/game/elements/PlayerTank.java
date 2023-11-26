package org.example.model.game.elements;

public class PlayerTank extends Element {
    private int energy;

    public PlayerTank(int x, int y) {
        super(x, y);
        this.energy = 5;
    }

    public void decreaseEnergy() {
        this.energy--;
    }

    public int getEnergy() {
        return energy;
    }
}
