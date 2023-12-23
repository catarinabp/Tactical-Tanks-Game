package org.example.states;

import org.example.controller.Controller;
import org.example.model.game.map.Map;
import org.example.states.GameState;
import org.example.viewer.Viewer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class GameStateTest {

    @Test
    void testUpdate() {
        // Arrange
        Map mockMap = mock(Map.class);
        GameState gameState = new GameState(mockMap);

        // Act
        long result = gameState.update();

        // Assert
        assertTrue(result >= 0);
    }

    @Test
    void testDisplayElapsedTime() {
        // Arrange
        Map mockMap = mock(Map.class);
        GameState gameState = new GameState(mockMap);

        // Act
        long result = gameState.displayElapsedTime();

        // Assert
        assertTrue(result >= 0);
    }



    @Test
    void testGetViewer() {
        // Arrange
        Map mockMap = mock(Map.class);
        GameState gameState = new GameState(mockMap);

        // Act
        Viewer<Map> viewer = gameState.getViewer();

        // Assert
        assertNotNull(viewer);
    }

    @Test
    void testGetController() {
        // Arrange
        Map mockMap = mock(Map.class);
        GameState gameState = new GameState(mockMap);

        // Act
        Controller<Map> controller = gameState.getController();

        // Assert
        assertNotNull(controller);
    }
}
