package org.example.model.game.elements;

import org.example.model.Position;
import org.example.model.game.elements.Wall;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class WallTest {

    @Test
    void testConstructorWithMock() {
        // Arrange
        int x = 1, y = 2;

        // Mocking
        Position mockPosition = Mockito.mock(Position.class);
        when(mockPosition.getX()).thenReturn(x);
        when(mockPosition.getY()).thenReturn(y);

        // Act
        Wall wall = new Wall(mockPosition.getX(), mockPosition.getY());

        // Assert
        assertEquals(x, wall.getPosition().getX());
        assertEquals(y, wall.getPosition().getY());
    }
}
