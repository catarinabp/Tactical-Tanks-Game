package org.example.viewer.game;

import org.example.GUI.GUI;
import org.example.model.game.elements.Hole;
import org.example.model.game.elements.Shoot;

public class ShootViewer implements ElementViewer<Shoot> {
    @Override
    public void draw(Shoot shoot, GUI gui) {
        gui.drawShoot(shoot.getPosition());
    }
}
