package org.example.controller.game;

import org.example.GUI.GUI;
import org.example.Game;
import org.example.model.game.elements.*;
import org.example.model.game.map.Map;
import org.example.states.GameOverState;
import org.example.states.WinState;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class MapControllerTest {

    @Test
    public void testStepQuitAction() throws IOException {
        // Criar mock do Game
        Game gameMock = mock(Game.class);

        // Criar mock do Map
        Map mapMock = mock(Map.class);
        when(mapMock.getPlayerTank()).thenReturn(mock(PlayerTank.class));

        // Criar MapController usando o mock do Map
        MapController mapController = new MapController(mapMock);

        // Chamar o método step com a ação de QUIT
        mapController.step(gameMock, GUI.ACTION.QUIT, 1000L);

        // Verificar se o método setState foi chamado com a instância correta de GameOverState
        verify(gameMock).setState(ArgumentMatchers.any(GameOverState.class));
    }

    @Test
    public void testStepPlayerTankLifeZero() throws IOException {
        // Create mocks
        Game gameMock = mock(Game.class);
        Map mapMock = mock(Map.class);
        PlayerTank playerTankMock = mock(PlayerTank.class);
        GUI.ACTION quitAction = GUI.ACTION.UP;  // Any action other than QUIT
        long time = 1000L;

        // Configure behavior for the mocks
        when(mapMock.getPlayerTank()).thenReturn(playerTankMock);
        when(playerTankMock.getLife()).thenReturn(0);

        // Create the object under test
        MapController mapController = new MapController(mapMock);

        // Call the method under test
        mapController.step(gameMock, quitAction, time);

        // Verify that the expected methods are called
        verify(gameMock).setState(any(GameOverState.class));
        verifyNoMoreInteractions(gameMock);  // Ensure that no other interactions occurred
    }

    @Test
    public void testStepEmptyNPCs() throws IOException {
        // Create mocks
        Game gameMock = mock(Game.class);
        Map mapMock = mock(Map.class);
        PlayerTank playerTankMock = mock(PlayerTank.class);
        GUI.ACTION quitAction = GUI.ACTION.UP;  // Any action other than QUIT
        long time = 1000L;

        // Configure behavior for the mocks
        when(mapMock.getPlayerTank()).thenReturn(playerTankMock);
        when(playerTankMock.getLife()).thenReturn(1);
        when(mapMock.getNPCs()).thenReturn(new ArrayList<>());

        // Create the object under test
        MapController mapController = new MapController(mapMock);

        // Call the method under test
        mapController.step(gameMock, quitAction, time);

        // Verify that the expected methods are called
        verify(gameMock).setState(any(WinState.class));
        verifyNoMoreInteractions(gameMock);  // Ensure that no other interactions occurred
    }

}


