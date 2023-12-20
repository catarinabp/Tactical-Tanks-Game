package org.example.viewer;

import org.example.GUI.GUI;
import org.example.model.Position;
import org.example.model.game.elements.*;
import org.example.model.game.map.Map;
import org.example.states.GameState;
import org.example.viewer.Viewer;
import org.example.viewer.game.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class MapViewerTest {

    @Test
    public void testDrawElements() {
        // Create mock objects
        Map mockMap = mock(Map.class);
        GUI mockGUI = mock(GUI.class);

        // Create some mock elements
        PlayerTank mockPlayerTank = mock(PlayerTank.class);
        Packet mockPacket = mock(Packet.class);
        Shoot mockShoot = mock(Shoot.class);
        List<Wall> walls = new ArrayList<>();
        List<Hole> holes = new ArrayList<>();
        List<NPCs> npcsList = new ArrayList<>();
        List<Box> boxes = new ArrayList<>();

        // Configure behavior for the mock map
        when(mockMap.getWalls()).thenReturn(walls);
        when(mockMap.getHoles()).thenReturn(holes);
        when(mockMap.getNPCs()).thenReturn(npcsList);
        when(mockMap.getBoxes()).thenReturn(boxes);
        when(mockMap.getPlayerTank()).thenReturn(mockPlayerTank);
        when(mockMap.getPacket()).thenReturn(mockPacket);
        when(mockMap.getShoot()).thenReturn(mockShoot);

        // Instantiate the GameViewer with the mocked Map
        GameViewer gameViewer = new GameViewer(mockMap);

        // Test the drawElements method
        gameViewer.drawElements(mockGUI);

        // Verify the interactions with the mock elements (e.g., draw calls)
        verify(mockGUI, times(1)).drawText(any(Position.class), eq("Lives: 0"), eq("#FFFFFF"));
        verify(mockGUI, times(1)).drawText(any(Position.class), eq("Bullets: 0"), eq("#FFFFFF"));
        verify(mockGUI, times(1)).drawText(any(Position.class), startsWith("Time: "), eq("#FFFFFF"));

        // Verify the interactions with the mock elements without relying on direct 'draw' method invocation
        verify(mockPlayerTank, times(1)).getLife();
        verify(mockPlayerTank, times(1)).getBullets();

        // Add more assertions/verifications as needed for the specific behavior of the drawElements method
    }

}
