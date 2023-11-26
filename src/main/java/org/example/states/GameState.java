package org.example.states;

import org.example.controller.Controller;
import org.example.controller.game.MapController;
import org.example.model.game.map.Map;
import org.example.viewer.Viewer;
import org.example.viewer.game.GameViewer;

public class GameState extends State<Map> {
    public GameState(Map map) {
        super(map);
    }

    @Override
    protected Viewer<Map> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Map> getController() {
        return new MapController(getModel());
    }
}
