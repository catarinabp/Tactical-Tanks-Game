package org.example.states;

import org.example.controller.Controller;
import org.example.controller.menu.InstrController;
import org.example.controller.menu.MenuController;
import org.example.model.menu.Menu;
import org.example.viewer.Viewer;
import org.example.viewer.menu.InstrViewer;
import org.example.viewer.menu.MenuViewer;

public class InstrState extends State<Menu> {
    public InstrState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new InstrViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() { return new InstrController(getModel());
    }
}
