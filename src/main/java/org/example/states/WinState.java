package org.example.states;

import org.example.controller.Controller;
import org.example.controller.menu.InstrController;
import org.example.controller.screens.GameOverController;
import org.example.model.menu.Menu;
import org.example.viewer.Viewer;
import org.example.viewer.screens.GameOverViewer;
import org.example.viewer.screens.WinViewer;

public class WinState extends State<Menu> {
    public WinState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new WinViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() { return new InstrController(getModel());
    }
}