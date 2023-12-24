package org.example.controller.menu;

import org.example.GUI.GUI;
import org.example.Game;
import org.example.controller.Controller;
import org.example.model.game.map.LoaderMapBuilder;
import org.example.model.menu.Menu;
import org.example.states.GameState;
import org.example.states.InstrState;
import org.example.states.MenuState;

import java.io.IOException;

public class InstrController extends Controller<Menu> {
    public InstrController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if(action == GUI.ACTION.QUIT){
            game.setState(new MenuState(new Menu()));
        }
    }
}
