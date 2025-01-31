package org.example.controller.game;

import org.example.GUI.GUI;
import org.example.Game;
import org.example.model.game.map.LoaderMapBuilder;
import org.example.model.game.map.Map;
import org.example.model.menu.GameOver;
import org.example.model.menu.Win;
import org.example.states.GameOverState;
import org.example.states.GameState;
import org.example.states.WinState;

import java.io.IOException;


public class MapController extends GameController {
    private final ShootController shootController;
    private final PlayerTankController playerTankController;
    private final NPCController npcController;


    public MapController(Map map) {
        super(map);

        this.playerTankController = new PlayerTankController(map);
        this.npcController = new NPCController(map);
        this.shootController = new ShootController(map);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel().getPlayerTank().getLife() == 0 || getModel().isHole(getModel().getPlayerTank().getPosition())) {
            game.setState(new GameOverState(new GameOver()));
        }
        else if (getModel().getNPCs().isEmpty()){
            GameState.finishGame(LoaderMapBuilder.getLevel());
            game.setState(new WinState(new Win()));
        }
        else {
            playerTankController.step(game, action, time);
            npcController.step(game, action, time);
            shootController.step(game, action, time);
        }
    }
}