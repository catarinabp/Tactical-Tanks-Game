package org.example.GUI;

import org.example.model.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawPlayerTank(Position position);

    void drawPacket(Position position);

    void drawWall(Position position);
    void drawBox (Position position);

    void drawShoot (Position position);

    void drawHole (Position position);

    void drawNPC(Position position);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, SHOOTUP, SHOOTDOWN, SHOOTRIGHT, SHOOTLEFT}
}
