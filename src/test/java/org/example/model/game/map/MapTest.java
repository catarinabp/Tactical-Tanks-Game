package org.example.model.game.map;

import org.example.model.Position;
import org.example.model.game.elements.*;
import org.example.model.game.map.Map;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MapTest {

    @Test
    void testIsEmptyWithEmptyMap() {
        // Arrange
        Map map = new Map(5, 5);

        // Act
        boolean isEmpty = map.isEmpty(new Position(2, 3));

        // Assert
        assertTrue(isEmpty);
    }




    @Test
    void testIsEmptyWithWall() {
        // Arrange
        Map map = new Map(5, 5);
        Wall wall = new Wall(2, 3);
        map.setWalls(List.of(wall));

        // Act
        boolean isEmpty = map.isEmpty(new Position(2, 3));

        // Assert
        assertFalse(isEmpty);
    }

    @Test
    void testIsSpotEmptyWithHole() {
        // Arrange
        Map map = new Map(5, 5);
        Hole hole = Mockito.mock(Hole.class);
        when(hole.getPosition()).thenReturn(new Position(2, 3));
        map.setHoles(List.of(hole));

        // Act
        boolean isSpotEmpty = map.isSpotEmpty(new Position(2, 3));

        // Assert
        assertFalse(isSpotEmpty);
    }






    @Test
    void testIsNPCWithNPC() {
        // Arrange
        Map map = new Map(5, 5);
        NPCs npc = new NPCs(2, 3);
        map.setNPCs(List.of(npc));

        // Act
        boolean isNPC = map.isNPC(new Position(2, 3));

        // Assert
        assertTrue(isNPC);
    }

    @Test
    void testIsPacketWithPacket() {
        // Arrange
        Map map = new Map(5, 5);
        Packet packet = mock(Packet.class);
        when(packet.getPosition()).thenReturn(new Position(2, 3));
        map.setPacket(packet);

        // Act
        boolean isPacket = map.isPacket(new Position(2, 3));

        // Assert
        assertTrue(isPacket);
    }



    @Test
    void testIsBoxWithBox() {
        // Arrange
        Map map = new Map(5, 5);
        Box box = new Box(2, 3);
        map.setBoxes(List.of(box));

        // Act
        boolean isBox = map.isBox(new Position(2, 3));

        // Assert
        assertTrue(isBox);
    }

    @Test
    void testRemoveNPC() {
        // Arrange
        Map map = new Map(5, 5);
        NPCs npc = new NPCs(2, 3);
        map.setNPCs(new ArrayList<>(List.of(npc)));

        // Act
        map.removeNPC(npc);

        // Assert
        assertTrue(map.getNPCs().isEmpty());
    }

    @Test
    void testRemoveBox() {
        // Arrange
        Map map = new Map(5, 5);
        Box box = new Box(2, 3);
        map.setBoxes(new ArrayList<>(List.of(box)));

        // Act
        map.removeBox(box);

        // Assert
        assertTrue(map.getBoxes().isEmpty());
    }
}
