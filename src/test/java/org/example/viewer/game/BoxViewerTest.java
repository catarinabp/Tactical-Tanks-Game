package org.example.viewer.game;

import org.example.GUI.GUI;
import org.example.model.Position;
import org.example.model.game.elements.Box;
import org.example.viewer.game.BoxViewer;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class BoxViewerTest {

    @Test
    void testDraw() {
        // Arrange
        BoxViewer boxViewer = new BoxViewer();
        GUI mockGui = mock(GUI.class);
        Box mockBox = mock(Box.class);
        Position mockPosition = mock(Position.class);

        // Configurar comportamento do mockBox
        when(mockBox.getPosition()).thenReturn(mockPosition);

        // Act
        boxViewer.draw(mockBox, mockGui);

        // Assert
        // Verificar se o método drawBox da GUI foi chamado exatamente uma vez com a posição correta
        verify(mockGui, times(1)).drawBox(eq(mockPosition));
    }
}
