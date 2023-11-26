package org.example.viewer.game;

import org.example.GUI.GUI;
import org.example.model.game.elements.Box;

public class BoxViewer implements ElementViewer<Box> {
    @Override
    public void draw(Box box, GUI gui) {
        gui.drawBox(box.getPosition());
    }
}
