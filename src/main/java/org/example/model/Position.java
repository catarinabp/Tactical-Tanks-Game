package org.example.model;

import org.example.GUI.GUI;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position getLeft() {
        return new Position(x - 1, y);
    }

    public Position getRight() {
        return new Position(x + 1, y);
    }

    public Position getUp() {
        return new Position(x, y - 1);
    }

    public Position getDown() {
        return new Position(x, y + 1);
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    public GUI.ACTION getDirection(Position destination) {
        int dx = destination.getX() - this.x;
        int dy = destination.getY() - this.y;

        if (dx > 0 && Math.abs(dx) >= Math.abs(dy)) {
            return GUI.ACTION.RIGHT;
        } else if (dx < 0 && Math.abs(dx) >= Math.abs(dy)) {
            return GUI.ACTION.LEFT;
        } else if (dy > 0 && Math.abs(dy) > Math.abs(dx)) {
            return GUI.ACTION.DOWN;
        } else {
            return GUI.ACTION.UP;
        }
    }

}
