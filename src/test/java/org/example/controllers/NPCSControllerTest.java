package org.example.controllers;

import org.example.GUI.GUI;
import org.example.Game;
import org.example.controller.game.NPCController;
import org.example.model.Position;
import org.example.model.game.elements.NPCs;
import org.example.model.game.elements.PlayerTank;
import org.example.model.game.map.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class NPCSControllerTest {

    @Mock
    private Map mockMap;

    @Mock
    private Game mockGame;

    @Mock
    private NPCs mockNPC1;

    @Mock
    private NPCs mockNPC2;

    @Mock
    private GUI.ACTION mockAction;

    @Mock
    private PlayerTank mockPlayerTank; // Assuming Tank is the type of getPlayerTank()

    private NPCController npcController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        List<NPCs> npcsList = new ArrayList<>();
        npcsList.add(mockNPC1);
        npcsList.add(mockNPC2);

        when(mockMap.getNPCs()).thenReturn(npcsList);
        when(mockMap.getPlayerTank()).thenReturn(mockPlayerTank);

        npcController = new NPCController(mockMap);
    }

    @Test
    public void testNPCMovement() throws IOException {
        // Set up the player position
        Position playerPosition = new Position(5, 5);
        when(mockPlayerTank.getPosition()).thenReturn(playerPosition);

        // Set up the initial NPC positions
        when(mockNPC1.getPosition()).thenReturn(new Position(3, 3));
        when(mockNPC2.getPosition()).thenReturn(new Position(7, 7));

        // Set up the model to consider the spot as empty
        when(mockMap.isSpotEmpty(any(Position.class))).thenReturn(true);

        // Call the step method with a time greater than the threshold (1000)
        npcController.step(mockGame, mockAction, 1500);

        // Verify that step triggers the movement of NPCs (indirectly)
        verify(mockNPC1, times(1)).setPosition(any(Position.class));
        verify(mockNPC2, times(1)).setPosition(any(Position.class));

        // Add assertions or further verifications as needed based on your application's logic
    }
}
