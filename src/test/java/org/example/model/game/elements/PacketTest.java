package org.example.model.game.elements;

import org.example.model.game.elements.Packet;
import org.example.model.game.elements.PlayerTank;
import org.example.strategy.PacketStrategy;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PacketTest {

    @Test
    void testConstructor() {
        // Arrange
        int x = 1, y = 2;
        PacketStrategy mockStrategy = Mockito.mock(PacketStrategy.class);

        // Act
        Packet packet = new Packet(x, y, mockStrategy);

        // Assert
        assertEquals(x, packet.getPosition().getX());
        assertEquals(y, packet.getPosition().getY());
        assertEquals(mockStrategy, packet.getStrategy());
    }

    @Test
    void testApplyStrategy() {
        // Arrange
        PacketStrategy mockStrategy = Mockito.mock(PacketStrategy.class);
        Packet packet = new Packet(1, 2, mockStrategy);
        PlayerTank mockPlayer = Mockito.mock(PlayerTank.class);

        // Act
        packet.applyStrategy(mockPlayer);

        // Assert
        Mockito.verify(mockStrategy, Mockito.times(1)).applyStrategy(mockPlayer);
    }

    @Test
    void testGetStrategy() {
        // Arrange
        PacketStrategy mockStrategy = Mockito.mock(PacketStrategy.class);
        Packet packet = new Packet(1, 2, mockStrategy);

        // Act
        PacketStrategy result = packet.getStrategy();

        // Assert
        assertEquals(mockStrategy, result);
    }

    @Test
    void testSetStrategy() {
        // Arrange
        Packet packet = new Packet(1, 2, null);
        PacketStrategy newMockStrategy = Mockito.mock(PacketStrategy.class);

        // Act
        packet.setStrategy(newMockStrategy);

        // Assert
        assertEquals(newMockStrategy, packet.getStrategy());
    }
}
