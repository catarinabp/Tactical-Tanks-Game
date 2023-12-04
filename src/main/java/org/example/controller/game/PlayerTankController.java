package org.example.controller.game;
import org.example.Game;
import org.example.GUI.GUI;
import org.example.model.Position;
import org.example.model.game.map.Map;
public class PlayerTankController extends GameController {
    public PlayerTankController(Map arena) {
        super(arena);
    }

    public void movePlayerLeft() {

        movePlayer(getModel().getPlayerTank().getPosition().getLeft());
    }

    public void movePlayerRight() {

        movePlayer(getModel().getPlayerTank().getPosition().getRight());
    }

    public void movePlayerUp() {

        movePlayer(getModel().getPlayerTank().getPosition().getUp());
    }

    public void movePlayerDown() {

        movePlayer(getModel().getPlayerTank().getPosition().getDown());
    }


    private void movePlayer(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getPlayerTank().setPosition(position);
            if (getModel().isNPC(position)) {
                getModel().getPlayerTank().decreaseLife();
            }
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) movePlayerUp();
        if (action == GUI.ACTION.RIGHT) movePlayerRight();
        if (action == GUI.ACTION.DOWN) movePlayerDown();
        if (action == GUI.ACTION.LEFT) movePlayerLeft();
    }


}
