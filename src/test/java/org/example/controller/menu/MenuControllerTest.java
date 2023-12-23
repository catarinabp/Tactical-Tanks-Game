package org.example.controller.menu;

import org.example.GUI.GUI;
import org.example.Game;
import org.example.model.menu.Menu;
import org.example.states.GameState;
import org.example.states.InstrState;
import org.example.states.RecordState;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class MenuControllerTest {

    @Test
    public void testStepShootUp() throws IOException {
        // Criar mocks
        Game gameMock = mock(Game.class);
        Menu menuMock = mock(Menu.class);
        MenuController menuController = new MenuController(menuMock);

        // Chamar o método step com a ação de SHOOTUP
        menuController.step(gameMock, GUI.ACTION.SHOOTUP, 1000L);

        // Verificar se o método previousEntry foi chamado
        verify(menuMock).previousEntry();
        verifyNoMoreInteractions(menuMock);  // Garantir que nenhuma outra interação ocorreu no mock
    }

    @Test
    public void testStepShootDown() throws IOException {
        // Criar mocks
        Game gameMock = mock(Game.class);
        Menu menuMock = mock(Menu.class);
        MenuController menuController = new MenuController(menuMock);

        // Chamar o método step com a ação de SHOOTDOWN
        menuController.step(gameMock, GUI.ACTION.SHOOTDOWN, 1000L);

        // Verificar se o método nextEntry foi chamado
        verify(menuMock).nextEntry();
        verifyNoMoreInteractions(menuMock);  // Garantir que nenhuma outra interação ocorreu no mock
    }

    @Test
    public void testStepSelectExit() throws IOException {
        // Criar mocks
        Game gameMock = mock(Game.class);
        Menu menuMock = mock(Menu.class);
        when(menuMock.isSelectedExit()).thenReturn(true);
        MenuController menuController = new MenuController(menuMock);

        // Chamar o método step com a ação de SELECT
        menuController.step(gameMock, GUI.ACTION.SELECT, 1000L);

        // Verificar se o método setState(null) foi chamado no gameMock
        verify(gameMock).setState(null);
        verifyNoMoreInteractions(gameMock);  // Garantir que nenhuma outra interação ocorreu no mock
    }

    @Test
    public void testStepSelectGame() throws IOException {
        // Criar mocks
        Game gameMock = mock(Game.class);
        Menu menuMock = mock(Menu.class);
        when(menuMock.isSelectedGame()).thenReturn(true);
        MenuController menuController = new MenuController(menuMock);

        // Chamar o método step com a ação de SELECT
        menuController.step(gameMock, GUI.ACTION.SELECT, 1000L);

        // Verificar se o método setState(new GameState(...)) foi chamado no gameMock
        verify(gameMock).setState(any(GameState.class));
        verifyNoMoreInteractions(gameMock);  // Garantir que nenhuma outra interação ocorreu no mock
    }

    @Test
    public void testStepSelectInstr() throws IOException {
        // Criar mocks
        Game gameMock = mock(Game.class);
        Menu menuMock = mock(Menu.class);
        when(menuMock.isSelectedInstr()).thenReturn(true);
        MenuController menuController = new MenuController(menuMock);

        // Chamar o método step com a ação de SELECT
        menuController.step(gameMock, GUI.ACTION.SELECT, 1000L);

        // Verificar se o método setState(new InstrState(...)) foi chamado no gameMock
        verify(gameMock).setState(any(InstrState.class));
        verifyNoMoreInteractions(gameMock);  // Garantir que nenhuma outra interação ocorreu no mock
    }

    @Test
    public void testStepSelectRec() throws IOException {
        // Criar mocks
        Game gameMock = mock(Game.class);
        Menu menuMock = mock(Menu.class);
        when(menuMock.isSelectedRec()).thenReturn(true);
        MenuController menuController = new MenuController(menuMock);

        // Chamar o método step com a ação de SELECT
        menuController.step(gameMock, GUI.ACTION.SELECT, 1000L);

        // Verificar se o método setState(new RecordState(...)) foi chamado no gameMock
        verify(gameMock).setState(any(RecordState.class));
        verifyNoMoreInteractions(gameMock);  // Garantir que nenhuma outra interação ocorreu
    }

}