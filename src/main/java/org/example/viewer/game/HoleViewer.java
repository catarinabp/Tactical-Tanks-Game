package org.example.viewer.game;

import org.example.GUI.GUI;
import org.example.model.game.elements.Hole;

public class HoleViewer implements ElementViewer<Hole> {
    @Override
    public void draw(Hole hole, GUI gui) {
        gui.drawHole(hole.getPosition());
    }
}
