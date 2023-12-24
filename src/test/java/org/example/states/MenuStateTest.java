package org.example.states;

import org.example.controller.Controller;
import org.example.controller.menu.MenuController;
import org.example.model.menu.Menu;
import org.example.states.MenuState;
import org.example.viewer.Viewer;
import org.example.viewer.menu.MenuViewer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class MenuStateTest {

    @Test
    void testGetViewer() {
        // Arrange
        Menu mockMenu = mock(Menu.class);
        MenuState menuState = new MenuState(mockMenu);

        // Act
        Viewer<Menu> viewer = menuState.getViewer();

        // Assert
        assertEquals(MenuViewer.class, viewer.getClass());
        // Add more assertions based on your specific implementations
    }

    @Test
    void testGetController() {
        // Arrange
        Menu mockMenu = mock(Menu.class);
        MenuState menuState = new MenuState(mockMenu);

        // Act
        Controller<Menu> controller = menuState.getController();

        // Assert
        assertEquals(MenuController.class, controller.getClass());
        // Add more assertions based on your specific implementations
    }

    // Add more tests for other methods in MenuState class
}
