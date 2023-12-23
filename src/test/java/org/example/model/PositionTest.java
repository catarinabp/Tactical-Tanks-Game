package org.example.model;

import org.example.GUI.GUI;
import org.example.model.Position;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PositionTest {

    @Test
    void testGetLeft() {
        // Arrange
        Position position = new Position(2, 3);

        // Act
        Position result = position.getLeft();

        // Assert
        assertEquals(new Position(1, 3), result);
    }

    @Test
    void testGetRight() {
        // Arrange
        Position position = new Position(2, 3);

        // Act
        Position result = position.getRight();

        // Assert
        assertEquals(new Position(3, 3), result);
    }

    @Test
    void testGetUp() {
        // Arrange
        Position position = new Position(2, 3);

        // Act
        Position result = position.getUp();

        // Assert
        assertEquals(new Position(2, 2), result);
    }

    @Test
    void testGetDown() {
        // Arrange
        Position position = new Position(2, 3);

        // Act
        Position result = position.getDown();

        // Assert
        assertEquals(new Position(2, 4), result);
    }



    @Test
    void testGetDirection() {
        // Arrange
        Position position = new Position(2, 3);
        Position destination = new Position(4, 3);

        // Act
        GUI.ACTION result = position.getDirection(destination);

        // Assert
        assertEquals(GUI.ACTION.RIGHT, result);
    }

    // Add more tests for other methods as needed
}
