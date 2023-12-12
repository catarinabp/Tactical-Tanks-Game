package org.example.controller.game;
import org.example.Game;
import org.example.GUI.GUI;
import org.example.model.Position;
import org.example.model.game.elements.Packet;
import org.example.model.game.map.Map;
import org.example.controller.game.ShootController;
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
            if (getModel().isPacket(position)) {
                generateRandomPacket();
                getModel().getPlayerTank().gainBullets();
            }
        }
    }

    private void generateRandomPacket() {
        int mapWidth = getModel().getWidth() - 2;
        int mapHeight = getModel().getHeight() - 2;

        // Generate random coordinates for the new packet
        int randomX;
        int randomY;
        Position position;
        do {
            randomX = (int) (Math.random() * mapWidth);
            randomY = (int) (Math.random() * mapHeight);
            position = new Position(randomX, randomY);
        } while (!getModel().isSpotEmpty(position));

        // Create a new packet and set its position on the map
        Packet newPacket = new Packet(randomX, randomY);
        getModel().setPacket(newPacket);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) movePlayerUp();
        if (action == GUI.ACTION.RIGHT) movePlayerRight();
        if (action == GUI.ACTION.DOWN) movePlayerDown();
        if (action == GUI.ACTION.LEFT) movePlayerLeft();
    }


}
