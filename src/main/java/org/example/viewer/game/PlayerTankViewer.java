package org.example.viewer.game;

import org.example.GUI.GUI;
import org.example.model.game.elements.PlayerTank;

public class PlayerTankViewer implements ElementViewer<PlayerTank> {
    @Override
    public void draw(PlayerTank playerTank, GUI gui) {
        gui.drawPlayerTank(playerTank.getPosition());
    }
}
