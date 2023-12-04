package org.example.controllers;


import org.example.GUI.GUI;
import org.example.model.Position;
import org.example.controller.game.PlayerTankController;
import org.example.model.game.elements.PlayerTank;
import org.example.model.game.map.Map;
import org.example.model.game.map.RandomMapBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapControllerTest {

    @Test
    void PlayerTankStaysWithinBounds() {

        int width = 10;
        int height = 10;
        RandomMapBuilder rab = new RandomMapBuilder(width, height, 0);
        Map map = rab.createMap();
        PlayerTankController controller = new PlayerTankController(map);

        PlayerTankController spyController = Mockito.spy(controller);


        GUI.ACTION[] actions = {GUI.ACTION.UP, GUI.ACTION.RIGHT, GUI.ACTION.DOWN, GUI.ACTION.LEFT};

        for (GUI.ACTION action : actions) {
            Mockito.doNothing().when(spyController).step(Mockito.any(), Mockito.eq(action), Mockito.anyLong());
            spyController.step(null, action, 100);
        }


        Position heroPosition = spyController.getModel().getPlayerTank().getPosition();
        assertTrue(heroPosition.getX() >= 0 && heroPosition.getX() < width);
        assertTrue(heroPosition.getY() >= 0 && heroPosition.getY() < height);
    }
}
