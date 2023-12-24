package org.example.states;

import org.example.controller.Controller;
import org.example.controller.menu.InstrController;
import org.example.controller.screens.GameOverController;
import org.example.model.menu.Menu;
import org.example.viewer.Viewer;
import org.example.viewer.screens.GameOverViewer;

public class GameOverState extends State<Menu> {
    public GameOverState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new GameOverViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() { return new InstrController(getModel());
    }
}
