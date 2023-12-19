package org.example.strategy;

import org.example.model.game.elements.PlayerTank;

public interface PacketStrategy {
    void applyStrategy(PlayerTank player);
}
