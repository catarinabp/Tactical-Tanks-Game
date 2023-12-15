package org.example.states;

import org.example.controller.Controller;
import org.example.controller.menu.InstrController;
import org.example.controller.menu.MenuController;
import org.example.model.menu.Menu;
import org.example.viewer.Viewer;
import org.example.viewer.menu.InstrViewer;
import org.example.viewer.menu.MenuViewer;
import org.example.viewer.menu.RecordViewer;

public class RecordState extends State<Menu> {
    public RecordState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new RecordViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() { return new InstrController(getModel());
    }
}
