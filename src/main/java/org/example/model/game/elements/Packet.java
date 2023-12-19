package org.example.model.game.elements;

import org.example.strategy.PacketStrategy;

public class Packet extends Element{
    private PacketStrategy strategy;
    public Packet(int x, int y, PacketStrategy strategy) {
        super(x, y);
        this.strategy = strategy;
    }

    public void applyStrategy(PlayerTank player) {
        if (strategy != null) {
            strategy.applyStrategy(player);
        }
    }

    public PacketStrategy getStrategy() {
        return this.strategy;
    }
}
