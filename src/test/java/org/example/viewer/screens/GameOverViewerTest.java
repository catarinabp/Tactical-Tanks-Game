package org.example.viewer.screens;

import org.example.GUI.GUI;
import org.example.model.Position;
import org.example.model.menu.Menu;
import org.example.viewer.screens.GameOverViewer;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GameOverViewerTest {

    @Test
    void testDrawElements() {
        // Arrange
        Menu mockMenu = mock(Menu.class);
        GameOverViewer gameOverViewer = new GameOverViewer(mockMenu);
        GUI mockGui = mock(GUI.class);

        // Act
        gameOverViewer.drawElements(mockGui);

        // Assert
        // Verify that the drawText method is called with the correct parameters
        verify(mockGui, times(1)).drawText(eq(new Position(9, 3)), eq("  GAME OVER..."), eq("#43A6C6"));
        verify(mockGui, times(1)).drawText(eq(new Position(1, 18)), eq("  PRESS Q TO GO BACK TO MENU"), eq("#43A6C6"));
    }
}
