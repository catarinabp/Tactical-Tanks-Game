package org.example.viewer.screens;

import org.example.GUI.GUI;
import org.example.model.Position;
import org.example.model.game.map.LoaderMapBuilder;
import org.example.model.menu.Menu;
import org.example.viewer.Viewer;

public class WinViewer extends Viewer<Menu> {
    private static final String TITLE_COLOR = "#43A6C6";
    private static final String DEFAULT_COLOR = "#FFFFFF";
    private static final int TITLE_X_POS = 9;

    private static final int TITLE_Y_POS = 3;


    public WinViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        drawTitle(gui);
        if(LoaderMapBuilder.getLevel() !=4){
            drawInstr(gui);
        }
        else{
            drawInstr2(gui);
        }
    }

    private void drawTitle(GUI gui) {
        gui.drawText(new Position(TITLE_X_POS, TITLE_Y_POS), "  YOU WON", TITLE_COLOR);
    }
    private void drawInstr(GUI gui) {
        gui.drawText(new Position(TITLE_X_POS - 9, TITLE_Y_POS + 15), "  PRESS --> TO GO TO NEXT LEVEL", TITLE_COLOR);
    }

    private void drawInstr2(GUI gui) {
        gui.drawText(new Position(TITLE_X_POS, TITLE_Y_POS+1), "  ALL LEVELS!", TITLE_COLOR);
        gui.drawText(new Position(TITLE_X_POS - 8, TITLE_Y_POS + 15), "  PRESS --> TO GO TO MENU", TITLE_COLOR);
    }

}