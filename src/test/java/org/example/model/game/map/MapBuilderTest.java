package org.example.model.game.map;

import org.example.model.game.elements.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MapBuilderTest {

    @Test
    void testCreateMap() {
        // Arrange
        MapBuilder mapBuilder = mock(MapBuilder.class);

        // Mock each method that is being called in createMap
        when(mapBuilder.getWidth()).thenReturn(5);
        when(mapBuilder.getHeight()).thenReturn(5);
        when(mapBuilder.createPlayerTank()).thenReturn(mock(PlayerTank.class));
        when(mapBuilder.createNPCs()).thenReturn(List.of(mock(NPCs.class)));
        when(mapBuilder.createPacket()).thenReturn(mock(Packet.class));
        when(mapBuilder.createWalls()).thenReturn(List.of(mock(Wall.class)));
        when(mapBuilder.createHoles()).thenReturn(List.of(mock(Hole.class)));
        when(mapBuilder.createBoxes()).thenReturn(List.of(mock(Box.class)));

        // Act
        Map map = mapBuilder.createMap();

        // Assert
        assertEquals(Integer.valueOf(5), map.getWidth());
        assertEquals(Integer.valueOf(5), map.getHeight());
        // Add more assertions based on your specific implementations
    }

}