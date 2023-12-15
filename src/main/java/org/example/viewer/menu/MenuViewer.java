package org.example.viewer.menu;

import org.example.GUI.GUI;
import org.example.model.Position;
import org.example.model.menu.Menu;
import org.example.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {
    private static final String TITLE_COLOR = "#FFFFFF";
    private static final String SELECTED_COLOR = "#43A6C6";
    private static final String DEFAULT_COLOR = "#FFFFFF";
    private static final int TITLE_X_POS = 9;

    private static final int TITLE_Y_POS = 3;
    private static final int ENTRY_START_Y_POS = 10;

    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        drawTitle(gui);
        drawEntries(gui);
    }

    private void drawTitle(GUI gui) {
        gui.drawText(new Position(TITLE_X_POS, TITLE_Y_POS), "Tactical Tanks", TITLE_COLOR);
    }

    private void drawEntries(GUI gui) {
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            int yPos = ENTRY_START_Y_POS + i + (i * 2); // Adjust the vertical spacing between entries
            gui.drawText(
                    new Position(TITLE_X_POS, yPos),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? SELECTED_COLOR : DEFAULT_COLOR
            );
        }
    }
}
