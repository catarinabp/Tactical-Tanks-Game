package org.example.controller.menu;

import org.example.GUI.GUI;
import org.example.Game;
import org.example.controller.Controller;
import org.example.model.game.map.LoaderMapBuilder;
import org.example.model.menu.Menu;
import org.example.states.GameState;
import org.example.states.InstrState;
import org.example.states.RecordState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedGame()) game.setState(new GameState(new LoaderMapBuilder(1).createMap()));
                if (getModel().isSelectedInstr()) game.setState(new InstrState(new Menu()));
                if (getModel().isSelectedRec()) game.setState(new RecordState(new Menu()));
        }
    }
}
