package org.example.controller.screens;

import org.example.GUI.GUI;
import org.example.Game;
import org.example.controller.screens.GameOverController;
import org.example.model.menu.Menu;
import org.example.states.MenuState;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

class GameOverControllerTest {

    @Test
    void testStepQuitAction() throws IOException {
        // Criar mock do Game
        Game gameMock = mock(Game.class);

        // Criar mock do Menu
        Menu menuMock = mock(Menu.class);

        // Criar GameOverController usando o mock do Menu
        GameOverController controller = new GameOverController(menuMock);

        // Chamar o método step com a ação de QUIT
        controller.step(gameMock, GUI.ACTION.QUIT, 1000L);

        // Verificar se o método setState foi chamado com qualquer instância de MenuState
        verify(gameMock).setState(any(MenuState.class));
    }

    @Test
    void testStepOtherAction() throws IOException {
        // Criar mock do Game
        Game gameMock = mock(Game.class);

        // Criar mock do Menu
        Menu menuMock = mock(Menu.class);

        // Criar GameOverController usando o mock do Menu
        GameOverController controller = new GameOverController(menuMock);

        // Chamar o método step com uma ação diferente de QUIT
        controller.step(gameMock, GUI.ACTION.UP, 1000L);

        // Verificar se o método setState NÃO foi chamado
        verify(gameMock, never()).setState(any());
    }
}
