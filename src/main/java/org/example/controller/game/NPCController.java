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
        if (time - lastMovement > 500) {
            for (NPCs npc : getModel().getNPCs())
                moveNPC(npc, npc.getPosition().getRandomNeighbour());
            this.lastMovement = time;
        }
    }

    public void randomShoot() {

    }

    private void moveNPC(NPCs npc, Position position) {
        if (getModel().isEmpty(position)) {
            npc.setPosition(position);
            if (getModel().getPlayerTank().getPosition().equals(position))
                getModel().getPlayerTank().decreaseEnergy();
        }
    }
}
