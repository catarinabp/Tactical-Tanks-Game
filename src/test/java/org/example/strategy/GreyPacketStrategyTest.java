package org.example.strategy;

import org.example.model.game.elements.PlayerTank;
import org.example.strategy.GreyPacketStrategy;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GreyPacketStrategyTest {

    @Test
    void testApplyStrategy() {
        // Arrange
        PlayerTank mockPlayerTank = mock(PlayerTank.class);
        GreyPacketStrategy greyPacketStrategy = new GreyPacketStrategy();

        // Act
        greyPacketStrategy.applyStrategy(mockPlayerTank);

        // Assert
        // Verifique se o método addBullets foi chamado exatamente uma vez com o argumento correto
        verify(mockPlayerTank, times(1)).addBullets(eq(1));
    }
}
