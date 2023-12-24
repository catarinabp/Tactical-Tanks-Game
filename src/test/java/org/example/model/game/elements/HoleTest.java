package org.example.model.game.elements;

import org.example.model.Position;
import org.example.model.game.elements.Hole;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HoleTest {

    @Test
    void testConstructor() {
        // Arrange
        int x = 1, y = 2;

        // Cria um mock para a classe Position
        Position mockPosition = Mockito.mock(Position.class);

        // Configura o comportamento esperado do mock
        Mockito.when(mockPosition.getX()).thenReturn(x);
        Mockito.when(mockPosition.getY()).thenReturn(y);

        // Act
        Hole hole = new Hole(mockPosition.getX(), mockPosition.getY());

        // Assert
        assertEquals(x, hole.getPosition().getX());
        assertEquals(y, hole.getPosition().getY());

        // Verifica se os métodos do mock foram chamados
        Mockito.verify(mockPosition, Mockito.times(1)).getX();
        Mockito.verify(mockPosition, Mockito.times(1)).getY();
    }
}
