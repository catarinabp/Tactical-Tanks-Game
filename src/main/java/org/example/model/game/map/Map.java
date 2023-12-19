package org.example.model.game.map;

import org.example.model.Position;
import org.example.model.game.elements.*;

import java.util.List;

public class Map {
    private final int width;
    private final int height;

    private PlayerTank playerTank;
    private Packet packet;
    private Shoot shoot;


    private List<NPCs> npcs;

    private List<Box> boxes;

    private List<Wall> walls;

    private List<Hole> holes;

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

    public Packet getPacket() {
        return packet;
    }

    public void setPacket(Packet packet) {
        this.packet = packet;
    }

    public Shoot getShoot() {
        return shoot;
    }


    public void setShoot(Shoot shoot) {
        this.shoot = shoot;
    }

    public List<NPCs> getNPCs() {
        return npcs;
    }

    public void setNPCs(List<NPCs> npcs) {
        this.npcs = npcs;
    }

    public List<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<Box> boxes) {
        this.boxes = boxes;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public List<Hole> getHoles() {
        return holes;
    }

    public void setHoles(List<Hole> holes) {
        this.holes = holes;
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls){
            if (wall.getPosition().equals(position))
                return false;
        }
        return true;
    }

    public boolean isSpotEmpty(Position position) {
        for (Wall wall : walls){
            if (wall.getPosition().equals(position))
                return false;
        }
        for (Hole hole : holes){
            if (hole.getPosition().equals(position))
                return false;
        }
        return true;
    }

    public boolean isNPC(Position position) {
        for (NPCs npcs : npcs)
            if (npcs.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isPacket(Position position) {
        if (packet.getPosition().equals(position))
            return true;
        return false;
    }

    public boolean isHole(Position position) {
        for (Hole hole : holes)
            if (hole.getPosition().equals(position))
                return true;
        return false;
    }

    public void removeNPC(NPCs npcToRemove) {
        if (npcs != null && npcs.contains(npcToRemove)) {
            npcs.remove(npcToRemove);
        }
    }

    public boolean isBox(Position position) {
        for (Box box : boxes)
            if (box.getPosition().equals(position))
                return true;
        return false;
    }

    public void removeBox(Box boxToRemove) {
        if (boxes != null && boxes.contains(boxToRemove)) {
            boxes.remove(boxToRemove);
        }
    }
}