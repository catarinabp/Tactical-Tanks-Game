package org.example.states;

import org.example.controller.Controller;
import org.example.controller.menu.InstrController;
import org.example.model.menu.Menu;
import org.example.states.RecordState;
import org.example.viewer.Viewer;
import org.example.viewer.menu.RecordViewer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class RecordStateTest {

    @Test
    void testGetViewer() {
        // Arrange
        Menu mockMenu = mock(Menu.class);
        RecordState recordState = new RecordState(mockMenu);

        // Act
        Viewer<Menu> viewer = recordState.getViewer();

        // Assert
        assertEquals(RecordViewer.class, viewer.getClass());
        // Add more assertions based on your specific implementations
    }

    @Test
    void testGetController() {
        // Arrange
        Menu mockMenu = mock(Menu.class);
        RecordState recordState = new RecordState(mockMenu);

        // Act
        Controller<Menu> controller = recordState.getController();

        // Assert
        assertEquals(InstrController.class, controller.getClass());
        // Add more assertions based on your specific implementations
    }

    // Add more tests for other methods in RecordState class
}
