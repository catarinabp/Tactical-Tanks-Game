package org.example.strategy;

import org.example.model.game.elements.PlayerTank;

public class GreyPacketStrategy implements PacketStrategy {
    @Override
    public void applyStrategy(PlayerTank player) {
        player.addBullets(1); // Assuming gainBullets method exists
    }
}

