package org.example.model.game.map;

import org.example.model.Position;
import org.example.model.game.elements.NPCs;
import org.example.model.game.elements.PlayerTank;
import org.example.model.game.elements.Wall;

import java.util.List;

public class Map {
    private final int width;
    private final int height;

    private PlayerTank playerTank;

    private List<NPCs> npcs;
    private List<Wall> walls;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public PlayerTank getPlayerTank() {
        return playerTank;
    }

    public void setPlayerTank(PlayerTank playerTank) {
        this.playerTank = playerTank;
    }

    public List<NPCs> getNPCs() {
        return npcs;
    }

    public void setNPCs(List<NPCs> npcs) {
        this.npcs = npcs;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }

    public boolean isNPC(Position position) {
        for (NPCs npcs : npcs)
            if (npcs.getPosition().equals(position))
                return true;
        return false;
    }
}
