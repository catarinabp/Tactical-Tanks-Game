package org.example.model.menu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GameOverTest {

    @Test
    void testSetAndGetGameOver() {
        // Arrange
        GameOver gameOverMenu = new GameOver();
        String[] gameOverText = {"Game", "Over"};

        // Act
        gameOverMenu.setGameOver(gameOverText);
        String[] result = gameOverMenu.getGameOver();

        // Assert
        assertArrayEquals(gameOverText, result);
    }
}
