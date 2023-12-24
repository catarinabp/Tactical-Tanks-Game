package org.example.viewer.game;

import org.example.GUI.GUI;
import org.example.model.Position;
import org.example.states.GameState;
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
        drawElements(gui, getModel().getHoles(), new HoleViewer());
        drawElements(gui, getModel().getNPCs(), new NPCViewer());
        if(getModel().getBoxes() != null){
            drawElements(gui, getModel().getBoxes(), new BoxViewer());
        }

        drawElement(gui, getModel().getPlayerTank(), new PlayerTankViewer());
        drawElement(gui, getModel().getPacket(), new PacketViewer());
        if(getModel().getShoot() != null ){
            drawElement(gui, getModel().getShoot(), new ShootViewer());
        }


        gui.drawText(new Position(2, 0), "Lives: " + getModel().getPlayerTank().getLife(), "#FFFFFF");
        gui.drawText(new Position(12, 0), "Bullets: " + getModel().getPlayerTank().getBullets(), "#FFFFFF");
        gui.drawText(new Position(2, 21), "Time: " + GameState.displayElapsedTime() + " seconds", "#FFFFFF");
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
