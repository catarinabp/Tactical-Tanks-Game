package org.example.viewer.menu;

import org.example.GUI.GUI;
import org.example.model.Position;
import org.example.model.menu.Menu;
import org.example.viewer.Viewer;

public class InstrViewer extends Viewer<Menu> {
    private static final String TITLE_COLOR = "#43A6C6";
    private static final String DEFAULT_COLOR = "#FFFFFF";
    private static final int TITLE_X_POS = 9;

    private static final int Instr_X_POS = 1;

    private static final int TITLE_Y_POS = 3;


    public InstrViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        drawTitle(gui);
        drawInstructions(gui);
    }

    private void drawTitle(GUI gui) {
        gui.drawText(new Position(TITLE_X_POS, TITLE_Y_POS), "Tactical Tanks", TITLE_COLOR);
    }

    private void drawInstructions(GUI gui) {
        gui.drawText(new Position(Instr_X_POS, TITLE_Y_POS + 5), "Move by W A S D", DEFAULT_COLOR);
        gui.drawText(new Position(Instr_X_POS, TITLE_Y_POS + 7), "Shoot by UP,DOWN,LEFT,UP ARROWS", DEFAULT_COLOR);
        gui.drawText(new Position(Instr_X_POS, TITLE_Y_POS + 9), "You have 5 lifes", DEFAULT_COLOR);
        gui.drawText(new Position(Instr_X_POS -1 , TITLE_Y_POS + 11), "In a hole you will die instantly", DEFAULT_COLOR);
        gui.drawText(new Position(Instr_X_POS, TITLE_Y_POS + 13), "You win if you kill all npcs", DEFAULT_COLOR);
        gui.drawText(new Position(Instr_X_POS -1 , TITLE_Y_POS + 15), "And you will go to another level. ", DEFAULT_COLOR);
    }
}
