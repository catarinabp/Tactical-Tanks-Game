package org.example.viewer.game;

import org.example.GUI.GUI;
import org.example.model.Position;
import org.example.model.game.elements.Hole;
import org.example.viewer.game.HoleViewer;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class HoleViewerTest {

    @Test
    void testDraw() {
        // Arrange
        HoleViewer holeViewer = new HoleViewer();
        GUI mockGui = mock(GUI.class);
        Hole mockHole = mock(Hole.class);
        Position mockPosition = mock(Position.class);

        // Configurar comportamento do mockHole
        when(mockHole.getPosition()).thenReturn(mockPosition);

        // Act
        holeViewer.draw(mockHole, mockGui);

        // Assert
        // Verificar se o método drawHole da GUI foi chamado exatamente uma vez com a posição correta
        verify(mockGui, times(1)).drawHole(eq(mockPosition));
    }
}
