package org.example.states;

import org.example.controller.Controller;
import org.example.model.menu.Menu;
import org.example.states.GameOverState;
import org.example.viewer.Viewer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameOverStateTest {

    @Test
    void testGetViewer() {
        // Arrange
        Menu mockMenu = mock(Menu.class);
        GameOverState gameOverState = new GameOverState(mockMenu);

        // Act
        Viewer<Menu> viewer = gameOverState.getViewer();

        // Assert
        assertNotNull(viewer);
        // Add more assertions based on your specific implementations
    }

    @Test
    void testGetController() {
        // Arrange
        Menu mockMenu = mock(Menu.class);
        GameOverState gameOverState = new GameOverState(mockMenu);

        // Act
        Controller<Menu> controller = gameOverState.getController();

        // Assert
        assertNotNull(controller);
        // Add more assertions based on your specific implementations
    }
}
