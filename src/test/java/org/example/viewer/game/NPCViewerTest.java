package org.example.viewer.game;

import org.example.GUI.GUI;
import org.example.model.Position;
import org.example.model.game.elements.NPCs;
import org.example.viewer.game.NPCViewer;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class NPCViewerTest {

    @Test
    void testDraw() {
        // Arrange
        NPCViewer npcViewer = new NPCViewer();
        GUI mockGui = mock(GUI.class);
        NPCs mockNPC = mock(NPCs.class);
        Position mockPosition = mock(Position.class);

        // Configurar comportamento do mockNPC
        when(mockNPC.getPosition()).thenReturn(mockPosition);

        // Act
        npcViewer.draw(mockNPC, mockGui);

        // Assert
        // Verificar se o método drawNPC da GUI foi chamado exatamente uma vez com a posição correta
        verify(mockGui, times(1)).drawNPC(eq(mockPosition));
    }
}
