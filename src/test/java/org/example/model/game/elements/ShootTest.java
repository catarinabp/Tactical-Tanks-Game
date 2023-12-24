package org.example.model.game.elements;

import org.example.model.Position;
import org.example.model.game.elements.Shoot;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ShootTest {

    @Test
    void testConstructorWithMock() {
        // Arrange
        int x = 1, y = 2;

        // Mocking
        Position mockPosition = Mockito.mock(Position.class);
        when(mockPosition.getX()).thenReturn(x);
        when(mockPosition.getY()).thenReturn(y);

        // Act
        Shoot shoot = new Shoot(mockPosition.getX(), mockPosition.getY());

        // Assert
        assertEquals(x, shoot.getPosition().getX());
        assertEquals(y, shoot.getPosition().getY());
    }
}
