package org.example.viewer.game;

import org.example.GUI.GUI;
import org.example.model.game.elements.NPCs;

public class NPCViewer implements ElementViewer<NPCs> {
    @Override
    public void draw(NPCs npcs, GUI gui) {
        gui.drawNPC(npcs.getPosition());
    }
}
