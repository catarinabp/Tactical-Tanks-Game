package org.example.states;

import org.example.controller.Controller;
import org.example.controller.screens.GameWinnerController;
import org.example.model.menu.Menu;
import org.example.states.WinState;
import org.example.viewer.Viewer;
import org.example.viewer.screens.WinViewer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class WinStateTest {

    @Test
    void testGetViewer() {
        // Arrange
        Menu mockMenu = mock(Menu.class);
        WinState winState = new WinState(mockMenu);

        // Act
        Viewer<Menu> viewer = winState.getViewer();

        // Assert
        assertEquals(WinViewer.class, viewer.getClass());
        // Add more assertions based on your specific implementations
    }

    @Test
    void testGetController() {
        // Arrange
        Menu mockMenu = mock(Menu.class);
        WinState winState = new WinState(mockMenu);

        // Act
        Controller<Menu> controller = winState.getController();

        // Assert
        assertEquals(GameWinnerController.class, controller.getClass());
        // Add more assertions based on your specific implementations
    }

    // Add more tests for other methods in WinState class
}
