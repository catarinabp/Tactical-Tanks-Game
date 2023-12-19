package org.example.controller.screens;

import org.example.GUI.GUI;
import org.example.Game;
import org.example.controller.Controller;
import org.example.model.game.map.LoaderMapBuilder;
import org.example.model.menu.Menu;
import org.example.states.GameState;
import org.example.states.MenuState;

import java.io.IOException;

public class GameWinnerController extends Controller<Menu> {
    public GameWinnerController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if(action == GUI.ACTION.SHOOTRIGHT){
            game.setState(new GameState(new LoaderMapBuilder(LoaderMapBuilder.getLevel()+1).createMap()));
        }
        if(action == GUI.ACTION.SHOOTRIGHT && LoaderMapBuilder.getLevel() == 4){
            game.setState(new MenuState(new Menu()));
        }
    }
}
