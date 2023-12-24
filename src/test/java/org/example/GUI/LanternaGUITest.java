package org.example.GUI;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.example.GUI.LanternaGUI;
import org.example.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class LanternaGUITest {

    private Screen mockScreen;
    private LanternaGUI lanternaGUI;

    @BeforeEach
    void setUp() {
        mockScreen = mock(Screen.class);
        lanternaGUI = new LanternaGUI(mockScreen);
    }

    @Test
    void testDrawPlayerTank() throws IOException {
        // Arrange
        Position position = new Position(1, 2);
        TextGraphics mockTextGraphics = Mockito.mock(TextGraphics.class);
        when(mockScreen.newTextGraphics()).thenReturn(mockTextGraphics);

        // Act
        lanternaGUI.drawPlayerTank(position);

        // Assert
        verify(mockTextGraphics, times(1)).setForegroundColor(TextColor.Factory.fromString("#3333FF"));
        verify(mockTextGraphics, times(1)).putString(1, 3, "T");
    }



    @Test
    void testDrawGreyPacket() throws IOException {
        // Arrange
        Position position = new Position(1, 2);
        TextGraphics mockTextGraphics = Mockito.mock(TextGraphics.class);
        when(mockScreen.newTextGraphics()).thenReturn(mockTextGraphics);

        // Act
        lanternaGUI.drawGreyPacket(position);

        // Assert
        verify(mockTextGraphics, times(1)).setForegroundColor(TextColor.Factory.fromString("#808080"));
        verify(mockTextGraphics, times(1)).putString(1, 3, "*");
    }



    @Test
    void testDrawOrangePacket() throws IOException {
        // Arrange
        Position position = new Position(1, 2);
        TextGraphics mockTextGraphics = Mockito.mock(TextGraphics.class);
        when(mockScreen.newTextGraphics()).thenReturn(mockTextGraphics);

        // Act
        lanternaGUI.drawOrangePacket(position);

        // Assert
        verify(mockTextGraphics, times(1)).setForegroundColor(TextColor.Factory.fromString("#FFA500"));
        verify(mockTextGraphics, times(1)).putString(1, 3, "*");
    }


    @Test
    void testDrawWall() throws IOException {
        // Arrange
        Position position = new Position(1, 2);
        TextGraphics mockTextGraphics = Mockito.mock(TextGraphics.class);
        when(mockScreen.newTextGraphics()).thenReturn(mockTextGraphics);

        // Act
        lanternaGUI.drawWall(position);

        // Assert
        verify(mockTextGraphics, times(1)).setForegroundColor(TextColor.Factory.fromString("#E1C16E"));
        verify(mockTextGraphics, times(1)).putString(1, 3, "#");
    }


    @Test
    void testDrawBox() throws IOException {
        // Arrange
        Position position = new Position(1, 2);
        TextGraphics mockTextGraphics = Mockito.mock(TextGraphics.class);
        when(mockScreen.newTextGraphics()).thenReturn(mockTextGraphics);

        // Act
        lanternaGUI.drawBox(position);

        // Assert
        verify(mockTextGraphics, times(1)).setForegroundColor(TextColor.Factory.fromString("#842020"));
        verify(mockTextGraphics, times(1)).putString(1, 3, "=");
    }


    @Test
    void testDrawHole() throws IOException {
        // Arrange
        Position position = new Position(1, 2);
        TextGraphics mockTextGraphics = Mockito.mock(TextGraphics.class);
        when(mockScreen.newTextGraphics()).thenReturn(mockTextGraphics);

        // Act
        lanternaGUI.drawHole(position);

        // Assert
        verify(mockTextGraphics, times(1)).setForegroundColor(TextColor.Factory.fromString("#3333FF"));
        verify(mockTextGraphics, times(1)).putString(1, 3, "O");
    }


    @Test
    void testDrawNPC() throws IOException {
        // Arrange
        Position position = new Position(1, 2);
        TextGraphics mockTextGraphics = Mockito.mock(TextGraphics.class);
        when(mockScreen.newTextGraphics()).thenReturn(mockTextGraphics);

        // Act
        lanternaGUI.drawNPC(position);

        // Assert
        verify(mockTextGraphics, times(1)).setForegroundColor(TextColor.Factory.fromString("#CC0000"));
        verify(mockTextGraphics, times(1)).putString(1, 3, "X");
    }


    @Test
    void testDrawShoot() throws IOException {
        // Arrange
        Position position = new Position(1, 2);
        TextGraphics mockTextGraphics = Mockito.mock(TextGraphics.class);
        when(mockScreen.newTextGraphics()).thenReturn(mockTextGraphics);

        // Act
        lanternaGUI.drawShoot(position);

        // Assert
        verify(mockTextGraphics, times(1)).setForegroundColor(TextColor.Factory.fromString("#CC0000"));
        verify(mockTextGraphics, times(1)).putString(1, 3, "+");
    }



    @Test
    void testDrawText() throws IOException {
        // Arrange
        Position position = new Position(1, 2);
        String text = "Test";
        String color = "#FFFFFF";

        TextGraphics mockTextGraphics = Mockito.mock(TextGraphics.class);
        when(mockScreen.newTextGraphics()).thenReturn(mockTextGraphics);

        // Act
        lanternaGUI.drawText(position, text, color);

        // Assert
        verify(mockTextGraphics, times(1)).setForegroundColor(TextColor.Factory.fromString(color));
        verify(mockTextGraphics, times(1)).putString(position.getX(), position.getY(), text);
    }

    @Test
    void testClear() throws IOException {
        // Act
        lanternaGUI.clear();

        // Assert
        verify(mockScreen, times(1)).clear();
    }

    @Test
    void testRefresh() throws IOException {
        // Act
        lanternaGUI.refresh();

        // Assert
        verify(mockScreen, times(1)).refresh();
    }

    @Test
    void testClose() throws IOException {
        // Act
        lanternaGUI.close();

        // Assert
        verify(mockScreen, times(1)).close();
    }

    private void verifyDrawCharacter(int x, int y, char c, String color) throws IOException {
        verify(mockScreen, times(1)).newTextGraphics();
        verify(mockScreen, times(1)).pollInput(); // Ensure that pollInput is called at least once
        verify(mockScreen, times(1)).refresh(); // Ensure that refresh is called at least once

        TextGraphics mockTextGraphics = Mockito.mock(TextGraphics.class);
        when(mockScreen.newTextGraphics()).thenReturn(mockTextGraphics);

        verify(mockTextGraphics, times(1)).setForegroundColor(TextColor.Factory.fromString(color));
        verify(mockTextGraphics, times(1)).putString(x, y + 1, "" + c);
    }
}
