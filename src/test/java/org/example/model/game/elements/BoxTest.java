package org.example.model.game.elements;

import org.example.model.game.elements.Box;
import org.example.model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BoxTest {

    @Test
    void testConstructor() {
        // Arrange
        int x = 1, y = 2;

        // Act
        Box box = new Box(x, y);

        // Assert
        Position position = box.getPosition();
        assertAll(
                () -> assertEquals(x, position.getX()),
                () -> assertEquals(y, position.getY()),
                () -> assertEquals(2, box.getLife())
        );
    }

    @Test
    void testDecreaseLife() {
        // Arrange
        Box box = spy(new Box(1, 2));

        // Act
        box.decreaseLife();

        // Assert
        verify(box, times(1)).decreaseLife();
        assertEquals(1, box.getLife());
    }

    @Test
    void testGetLife() {
        // Arrange
        Box box = new Box(1, 2);

        // Act
        int life = box.getLife();

        // Assert
        assertEquals(2, life);
    }
}

