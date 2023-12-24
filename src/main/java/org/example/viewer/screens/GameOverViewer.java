package org.example.viewer.screens;

import org.example.GUI.GUI;
import org.example.model.Position;
import org.example.model.menu.Menu;
import org.example.viewer.Viewer;

public class GameOverViewer extends Viewer<Menu> {
    private static final String TITLE_COLOR = "#43A6C6";
    private static final String DEFAULT_COLOR = "#FFFFFF";
    private static final int TITLE_X_POS = 9;

    private static final int TITLE_Y_POS = 3;


    public GameOverViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        drawTitle(gui);
    }

    private void drawTitle(GUI gui) {
        gui.drawText(new Position(TITLE_X_POS, TITLE_Y_POS), "  GAME OVER...", TITLE_COLOR);
        gui.drawText(new Position(TITLE_X_POS - 8, TITLE_Y_POS + 15), "  PRESS Q TO GO BACK TO MENU", TITLE_COLOR);
    }

}