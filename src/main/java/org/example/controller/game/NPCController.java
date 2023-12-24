package org.example.controller.game;

import org.example.GUI.GUI;
import org.example.Game;
import org.example.model.Position;
import org.example.model.game.elements.NPCs;
import org.example.model.game.map.Map;

import java.io.IOException;

public class NPCController extends GameController {
    private long lastMovement;

    public NPCController(Map map) {
        super(map);

        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 1000) {
            for (NPCs npc : getModel().getNPCs())
                moveNPC(npc);
            this.lastMovement = time;
        }
    }


    private void moveNPC(NPCs npc) {
        Position playerPosition = getModel().getPlayerTank().getPosition();
        Position npcPosition = npc.getPosition();

        int playerX = playerPosition.getX();
        int playerY = playerPosition.getY();
        int npcX = npcPosition.getX();
        int npcY = npcPosition.getY();

        int dx = Integer.compare(playerX, npcX);
        int dy = Integer.compare(playerY, npcY);

        Position newPosition = new Position(npcX + dx, npcY + dy);

        // Check if the new position is not already occupied by another NPC
        boolean positionOccupied = getModel().getNPCs().stream()
                .anyMatch(otherNPC -> otherNPC.getPosition().equals(newPosition));

        if (!positionOccupied && getModel().isSpotEmpty(newPosition)) {
            npc.setPosition(newPosition);
            if (getModel().getPlayerTank().getPosition().equals(newPosition)) {
                getModel().getPlayerTank().decreaseLife();
            }
        }
    }

}