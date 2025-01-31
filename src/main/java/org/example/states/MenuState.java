package org.example.states;

import org.example.controller.Controller;
import org.example.controller.menu.MenuController;
import org.example.model.menu.Menu;
import org.example.viewer.Viewer;
import org.example.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
