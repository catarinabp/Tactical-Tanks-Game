package org.example.model.menu;

import org.example.model.menu.Menu;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MenuTest {

    @Test
    void testNextEntry() {
        // Arrange
        Menu menu = Mockito.spy(new Menu());

        // Act
        menu.nextEntry();

        // Assert
        assertEquals(1, menu.currentEntry);
    }

    @Test
    void testPreviousEntry() {
        // Arrange
        Menu menu = Mockito.spy(new Menu());

        // Act
        menu.previousEntry();

        // Assert
        assertEquals(3, menu.currentEntry);
    }

    @Test
    void testGetEntry() {
        // Arrange
        Menu menu = new Menu();

        // Act
        String entry = menu.getEntry(2);

        // Assert
        assertEquals(" *  Record", entry);
    }

    @Test
    void testIsSelected() {
        // Arrange
        Menu menu = new Menu();

        // Act
        boolean isSelected = menu.isSelected(0);

        // Assert
        assertTrue(isSelected);
    }

    @Test
    void testIsSelectedExit() {
        // Arrange
        Menu menu = new Menu();

        // Act
        boolean isSelectedExit = menu.isSelectedExit();

        // Assert
        assertFalse(isSelectedExit);
    }

    @Test
    void testIsSelectedGame() {
        // Arrange
        Menu menu = new Menu();

        // Act
        boolean isSelectedGame = menu.isSelectedGame();

        // Assert
        assertTrue(isSelectedGame);
    }

    @Test
    void testIsSelectedInstr() {
        // Arrange
        Menu menu = new Menu();

        // Act
        boolean isSelectedInstr = menu.isSelectedInstr();

        // Assert
        assertFalse(isSelectedInstr);
    }

    @Test
    void testIsSelectedRec() {
        // Arrange
        Menu menu = new Menu();

        // Act
        boolean isSelectedRec = menu.isSelectedRec();

        // Assert
        assertFalse(isSelectedRec);
    }

    @Test
    void testGetNumberEntries() {
        // Arrange
        Menu menu = new Menu();

        // Act
        int numberEntries = menu.getNumberEntries();

        // Assert
        assertEquals(4, numberEntries);
    }
}
