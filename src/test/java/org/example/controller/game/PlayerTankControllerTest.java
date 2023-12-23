package org.example.controller.game;

import org.example.model.Position;
import org.example.model.game.elements.PlayerTank;
import org.example.model.game.map.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class PlayerTankControllerTest {

    @Mock
    private Map mockMap;

    @Mock
    private PlayerTank mockPlayerTank;

    private PlayerTankController playerTankController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(mockMap.getPlayerTank()).thenReturn(mockPlayerTank);
        playerTankController = new PlayerTankController(mockMap);
    }

    @Test
    public void testMovePlayerLeft() {
        // Mocking necessary methods for movement and checking position
        Position currentPosition = new Position(5, 5);
        when(mockPlayerTank.getPosition()).thenReturn(currentPosition);
        when(mockMap.isEmpty(new Position(4, 5))).thenReturn(true);

        // Call the movePlayerLeft method
        playerTankController.movePlayerLeft();

        // Verify that the expected methods were called
        verify(mockPlayerTank, times(1)).getPosition();
        verify(mockMap, times(1)).isEmpty(new Position(4, 5));

        // Add assertions or further verifications as needed based on your application's logic
    }
    @Test
    public void testMovePlayerRight() {

        Position currentPosition = new Position(5, 5);
        when(mockMap.getPlayerTank().getPosition()).thenReturn(currentPosition);
        when(mockMap.isEmpty(any(Position.class))).thenReturn(true);

        // Call the movePlayerLeft method
        playerTankController.movePlayerRight();

        // Verify that the expected methods were called
        verify(mockMap.getPlayerTank(), times(1)).getPosition();
        verify(mockMap, times(1)).isEmpty(new Position(6, 5)); // Assuming move left changes X coordinate

        // Add assertions or further verifications as needed based on your application's logic
    }

    @Test
    public void testMovePlayerUp() {

        Position currentPosition = new Position(5, 5);
        when(mockMap.getPlayerTank().getPosition()).thenReturn(currentPosition);
        when(mockMap.isEmpty(any(Position.class))).thenReturn(true);

        // Call the movePlayerLeft method
        playerTankController.movePlayerUp();

        // Verify that the expected methods were called
        verify(mockMap.getPlayerTank(), times(1)).getPosition();
        verify(mockMap, times(1)).isEmpty(new Position(5, 4)); // Assuming move left changes X coordinate

        // Add assertions or further verifications as needed based on your application's logic
    }

    @Test
    public void testMovePlayerDown() {

        Position currentPosition = new Position(5, 5);
        when(mockMap.getPlayerTank().getPosition()).thenReturn(currentPosition);
        when(mockMap.isEmpty(any(Position.class))).thenReturn(true);

        // Call the movePlayerLeft method
        playerTankController.movePlayerDown();

        // Verify that the expected methods were called
        verify(mockMap.getPlayerTank(), times(1)).getPosition();
        verify(mockMap, times(1)).isEmpty(new Position(5, 6)); // Assuming move left changes X coordinate

        // Add assertions or further verifications as needed based on your application's logic
    }

}
