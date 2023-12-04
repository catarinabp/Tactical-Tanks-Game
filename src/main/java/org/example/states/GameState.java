package org.example.states;

import org.example.controller.Controller;
import org.example.controller.game.MapController;
import org.example.model.game.map.Map;
import org.example.viewer.Viewer;
import org.example.viewer.game.GameViewer;

public class GameState extends State<Map> {
    private static long startTime;
    private static long elapsedTime;

    public GameState(Map map) {
        super(map);
        startTime = System.nanoTime();
        elapsedTime = 0;
    }

    public static long update() {
        // Calculate the elapsed time
        long currentTime = System.nanoTime();
        elapsedTime = currentTime - startTime;
        return elapsedTime;
    }

    public static long displayElapsedTime() {
        long seconds = update() / 1_000_000_000; // Convert nanoseconds to seconds
        return seconds;
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
