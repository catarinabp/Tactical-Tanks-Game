package org.example.strategy;

import org.example.model.game.elements.PlayerTank;

public class OrangePacketStrategy implements PacketStrategy {
    @Override
    public void applyStrategy(PlayerTank player) {
        player.addBullets(3); // Assuming gainBullets method exists
    }
}
