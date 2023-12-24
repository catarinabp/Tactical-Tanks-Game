package org.example.viewer.menu;

import org.example.GUI.GUI;
import org.example.model.Position;
import org.example.model.menu.Menu;
import org.example.viewer.menu.InstrViewer;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class InstrViewerTest {

    @Test
    void testDrawElements() {
        // Arrange
        InstrViewer instrViewer = new InstrViewer(mock(Menu.class));
        GUI mockGui = mock(GUI.class);

        // Act
        instrViewer.drawElements(mockGui);

        // Assert
        // Verifique se os métodos drawText da GUI foram chamados com as posições e textos corretos
        verify(mockGui, times(1)).drawText(eq(new Position(9, 3)), eq("Tactical Tanks"), eq("#43A6C6"));
        verify(mockGui, times(1)).drawText(eq(new Position(0, 8)), eq("Move by W A S D"), eq("#FFFFFF"));
        verify(mockGui, times(1)).drawText(eq(new Position(0, 10)), eq("Shoot by UP,DOWN,LEFT,RIGHT arrow"), eq("#FFFFFF"));
        verify(mockGui, times(1)).drawText(eq(new Position(0, 12)), eq("You have 5 lives"), eq("#FFFFFF"));
        verify(mockGui, times(1)).drawText(eq(new Position(0, 14)), eq("In a hole you will die instantly"), eq("#FFFFFF"));
        verify(mockGui, times(1)).drawText(eq(new Position(0, 16)), eq("You win if you kill all npcs"), eq("#FFFFFF"));
        verify(mockGui, times(1)).drawText(eq(new Position(0, 18)), eq("And you will go to another level."), eq("#FFFFFF"));
    }
}
