package org.example.GUI;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import org.example.model.Position;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI {
    private final Screen screen;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character) {
            char c = keyStroke.getCharacter();
            switch (c) {
                case 'w':
                    return ACTION.UP;
                case 'W':
                    return ACTION.UP;
                case 'a':
                    return ACTION.LEFT;
                case 'A':
                    return ACTION.LEFT;
                case 's':
                    return ACTION.DOWN;
                case 'S':
                    return ACTION.DOWN;
                case 'd':
                    return ACTION.RIGHT;
                case 'D':
                    return ACTION.RIGHT;
                case 'q':
                    return ACTION.QUIT;
                case 'Q':
                    return ACTION.QUIT;
            }
        }
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.SHOOTDOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.SHOOTUP;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.SHOOTLEFT;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.SHOOTRIGHT;

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;

    }

    @Override
    public void drawPlayerTank(Position position) {

        drawCharacter(position.getX(), position.getY(), 'T', "#3333FF");
    }

    @Override
    public void drawPacket(Position position) {

        drawCharacter(position.getX(), position.getY(), '*', "#808080");
    }

    @Override
    public void drawWall(Position position) {

        drawCharacter(position.getX(), position.getY(), '#', "#E1C16E");
    }

    @Override
    public void drawBox(Position position) {

        drawCharacter(position.getX(), position.getY(), '-', "#3333FF");
    }

    @Override
    public void drawHole(Position position) {
        drawCharacter(position.getX(), position.getY(), 'O', "#3333FF");
    }

    @Override
    public void drawNPC(Position position) {

        drawCharacter(position.getX(), position.getY(), 'X', "#CC0000");
    }

    @Override
    public void drawShoot(Position position) {

        drawCharacter(position.getX(), position.getY(), '+', "#CC0000");
    }


    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    private void drawCharacter(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + c);
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }


}



