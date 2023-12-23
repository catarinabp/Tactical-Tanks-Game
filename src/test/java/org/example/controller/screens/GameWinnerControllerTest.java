package org.example.controller.screens;

import org.example.GUI.GUI;
import org.example.Game;
import org.example.model.game.map.LoaderMapBuilder;
import org.example.model.menu.Menu;
import org.example.states.GameState;
import org.example.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;

class GameWinnerControllerTest {

    @Mock
    private Game game;

    private GameWinnerController gameWinnerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        gameWinnerController = spy(new GameWinnerController(mock(Menu.class)));
    }
}




