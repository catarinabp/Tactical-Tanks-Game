package org.example.viewer.game;

import org.example.GUI.GUI;
import org.example.model.Position;
import org.example.model.game.elements.Wall;
import org.example.viewer.game.WallViewer;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class WallViewerTest {

    @Test
    void testDraw() {
        // Arrange
        WallViewer wallViewer = new WallViewer();
        GUI mockGui = mock(GUI.class);
        Wall mockWall = mock(Wall.class);
        Position mockPosition = mock(Position.class);

        // Configurar comportamento do mockWall
        when(mockWall.getPosition()).thenReturn(mockPosition);

        // Act
        wallViewer.draw(mockWall, mockGui);

        // Assert
        // Verificar se o método drawWall da GUI foi chamado exatamente uma vez com a posição correta
        verify(mockGui, times(1)).drawWall(eq(mockPosition));
    }
}
