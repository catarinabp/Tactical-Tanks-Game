package org.example.strategy;

import org.example.model.game.elements.PlayerTank;
import org.example.strategy.PacketStrategy;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class PacketStrategyTest {

    @Test
    void testApplyStrategy() {
        // Arrange
        PlayerTank mockPlayerTank = mock(PlayerTank.class);
        MockPacketStrategy mockPacketStrategy = new MockPacketStrategy();

        // Act
        mockPacketStrategy.applyStrategy(mockPlayerTank);

        // Assert
        // Verifique se o método applyStrategy da estratégia foi chamado exatamente uma vez com o argumento correto
        verify(mockPacketStrategy, times(1)).applyStrategy(eq(mockPlayerTank));
    }

    private static class MockPacketStrategy implements PacketStrategy {
        @Override
        public void applyStrategy(PlayerTank player) {
            // Implementação fictícia da estratégia para teste
        }
    }
}
