package org.example.model.game.map;

import org.example.model.game.map.Map;
import org.example.model.game.map.RandomMapBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomMapBuilderTest {

    @Test
    void testCreateRandomMap() {
        // Arrange
        int width = 10;
        int height = 10;
        int numberOfNPCs = 5;

        RandomMapBuilder mapBuilder = new RandomMapBuilder(width, height, numberOfNPCs);

        // Act
        Map map = mapBuilder.createMap();

        // Assert
        assertEquals(width, map.getWidth());
        assertEquals(height, map.getHeight());

        // Additional assertions based on the specific logic of your RandomMapBuilder
        assertNotNull(map.getPlayerTank());
        assertNotNull(map.getPacket());
        assertFalse(map.getNPCs().isEmpty());
        assertTrue(map.getBoxes().isEmpty()); // Assuming boxes are not added in this implementation
        assertTrue(map.getHoles().isEmpty()); // Assuming holes are not added in this implementation
    }
}
