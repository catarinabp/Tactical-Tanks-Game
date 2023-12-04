package org.example.controller.game;

import org.example.GUI.GUI;
import org.example.Game;
import org.example.model.game.map.Map;
import org.example.model.menu.Menu;
import org.example.states.MenuState;

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
        if (action == GUI.ACTION.QUIT || getModel().getPlayerTank().getLife() == 0)
            game.setState(new MenuState(new Menu()));
        else {
            playerTankController.step(game, action, time);
            npcController.step(game, action, time);
        }
    }
}
