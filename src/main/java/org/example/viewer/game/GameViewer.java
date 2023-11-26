package org.example.viewer.game;

import org.example.GUI.GUI;
import org.example.model.Position;
import org.example.model.game.elements.NPCs;
import org.example.model.game.elements.PlayerTank;
import org.example.viewer.Viewer;
import org.example.model.game.elements.Element;
import org.example.model.game.map.Map;


import java.util.List;


public class GameViewer extends Viewer<Map> {
    public GameViewer(Map map) {
        super(map);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElements(gui, getModel().getNPCs(), new NPCViewer());
        drawElement(gui, getModel().getPlayerTank(), new PlayerTankViewer());

        gui.drawText(new Position(0, 0), "Energy: " + getModel().getPlayerTank().getEnergy(), "#FFD700");
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
