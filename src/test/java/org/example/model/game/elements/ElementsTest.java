package org.example.model.game.elements;

import org.example.model.Position;
import org.example.model.game.elements.Element;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ElementsTest {

    @Test
    void testGetPositionWithMock() {
        // Arrange
        Position mockPosition = Mockito.mock(Position.class);
        when(mockPosition.getX()).thenReturn(1);
        when(mockPosition.getY()).thenReturn(2);

        Element element = new Element(0, 0); // Use o construtor existente

        // Act
        element.setPosition(mockPosition); // Modifique a posição usando o mock

        // Assert
        assertEquals(1, element.getPosition().getX());
        assertEquals(2, element.getPosition().getY());
    }

    @Test
    void testSetPositionWithMock() {
        // Arrange
        Position originalPosition = new Position(1, 2);
        Element element = new Element(0, 0); // Use o construtor existente

        Position mockPosition = Mockito.mock(Position.class);
        when(mockPosition.getX()).thenReturn(3);
        when(mockPosition.getY()).thenReturn(4);

        // Act
        element.setPosition(mockPosition); // Modifique a posição usando o mock

        // Assert
        assertEquals(3, element.getPosition().getX());
        assertEquals(4, element.getPosition().getY());
    }
}
