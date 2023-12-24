package org.example.strategy;

import org.example.model.game.elements.PlayerTank;
import org.example.strategy.OrangePacketStrategy;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class OrangepacketStrategyTest {

    @Test
    void testApplyStrategy() {
        // Arrange
        PlayerTank mockPlayerTank = mock(PlayerTank.class);
        OrangePacketStrategy orangePacketStrategy = new OrangePacketStrategy();

        // Act
        orangePacketStrategy.applyStrategy(mockPlayerTank);

        // Assert
        // Verifique se o método addBullets foi chamado exatamente uma vez com o argumento correto
        verify(mockPlayerTank, times(1)).addBullets(eq(3));
    }
}
