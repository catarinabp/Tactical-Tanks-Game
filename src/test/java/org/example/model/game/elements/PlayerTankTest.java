package org.example.model.game.elements;

import org.example.model.game.elements.PlayerTank;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTankTest {

    @Test
    void testConstructor() {
        // Arrange
        int x = 1, y = 2;

        // Act
        PlayerTank playerTank = new PlayerTank(x, y);

        // Assert
        assertEquals(x, playerTank.getPosition().getX());
        assertEquals(y, playerTank.getPosition().getY());
        assertEquals(5, playerTank.getLife());
        assertEquals(10, playerTank.getBullets());
    }

    @Test
    void testDecreaseLife() {
        // Arrange
        PlayerTank playerTank = new PlayerTank(1, 2);

        // Act
        playerTank.decreaseLife();

        // Assert
        assertEquals(4, playerTank.getLife());
    }

    @Test
    void testDecreaseBullets() {
        // Arrange
        PlayerTank playerTank = new PlayerTank(1, 2);

        // Act
        playerTank.decreaseBullets();

        // Assert
        assertEquals(9, playerTank.getBullets());
    }

    @Test
    void testAddBullets() {
        // Arrange
        PlayerTank playerTank = new PlayerTank(1, 2);

        // Act
        playerTank.addBullets(5);

        // Assert
        assertEquals(15, playerTank.getBullets());
    }

    @Test
    void testGetLife() {
        // Arrange
        PlayerTank playerTank = new PlayerTank(1, 2);

        // Act
        int result = playerTank.getLife();

        // Assert
        assertEquals(5, result);
    }

    @Test
    void testGetBullets() {
        // Arrange
        PlayerTank playerTank = new PlayerTank(1, 2);

        // Act
        int result = playerTank.getBullets();

        // Assert
        assertEquals(10, result);
    }
}
