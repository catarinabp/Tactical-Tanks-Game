package org.example.controller.screens;

import org.example.GUI.GUI;
import org.example.Game;
import org.example.controller.Controller;
import org.example.model.menu.Menu;
import org.example.states.MenuState;

import java.io.IOException;

public class GameOverController extends Controller<String> {
    public GameOverController(Menu model) {
        super(model.toString());
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if(action == GUI.ACTION.QUIT){
            game.setState(new MenuState(new Menu()));
        }
    }
}
