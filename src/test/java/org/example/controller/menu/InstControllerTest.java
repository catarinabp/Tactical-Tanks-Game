package org.example.controller.menu;

import org.example.GUI.GUI;
import org.example.Game;
import org.example.model.menu.Menu;
import org.example.states.MenuState;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class InstControllerTest {

    @Test
    void testStepQuit() throws IOException {
        Game game = mock(Game.class);
        Menu menu = mock(Menu.class);
        InstrController instrController = new InstrController(menu);
        instrController.step(game, GUI.ACTION.QUIT, 100);
        verify(game, times(1)).setState(argThat(state -> state instanceof MenuState));
    }
}
